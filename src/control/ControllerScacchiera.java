package control;

import model.Spot;
import model.ThreadEndGame;
import model.UsernamesManagement;
import model.pieces.*;
import view.ChessBoard;
import view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @param Classe per la gestione degli eventi della scacchiera
 */

public class ControllerScacchiera implements ActionListener {
    Spot oldBox = null;
    ChessBoard view;
    GUI GUI;
    private UsernamesManagement usernamesManagement;

    /**
     * @param costruttore
     * @param GUI
     * @param view
     */
    public ControllerScacchiera(GUI GUI, ChessBoard view, UsernamesManagement usernamesManagement) {
        this.GUI = GUI;
        this.view = view;
        this.usernamesManagement = usernamesManagement;
        view.listener(this);


        TimerTask task = new TimerTask() {

            public void run() {

                if (view.getGame().isCurrentTurnBianco()) {
                    if (!view.getThreadTimerP1().isAlive())
                        view.getThreadTimerP1().start();
                    GUI.getTurn().turn = 0;
                    if (view.getThreadTimerP1().getHasTimerStopped()) {
                        int ris = JOptionPane.showOptionDialog(null, "La partita e' finita!\nCongratulazioni, il player 1 ha finito il tempo a disposizione", "Partita Finita", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        if (ris == JOptionPane.OK_OPTION || ris == JOptionPane.CANCEL_OPTION) {
                            GUI.getTurn().hasGameEnded = true;
                            usernamesManagement.aggiungiVittoria(usernamesManagement.getP1());
                            usernamesManagement.aggiungiPerdita(usernamesManagement.getP2());
                            System.exit(1);
                        }
                    }
                } else {
                    if (!view.getThreadTimerP2().isAlive())
                        view.getThreadTimerP2().start();
                    GUI.getTurn().turn = 1;
                    if (view.getThreadTimerP2().getHasTimerStopped()) {
                        int ris = JOptionPane.showOptionDialog(null, "La partita e' finita!\nCongratulazioni, il player 2 ha finito il tempo a disposizione", "Partita Finita", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        if (ris == JOptionPane.OK_OPTION || ris == JOptionPane.CANCEL_OPTION) {
                            GUI.getTurn().hasGameEnded = true;
                            usernamesManagement.aggiungiVittoria(usernamesManagement.getP2());
                            usernamesManagement.aggiungiPerdita(usernamesManagement.getP1());
                            System.exit(1);
                        }
                    }
                }
            }
        };


        java.util.Timer timer = new Timer();
        long delay = 1000L; // delay in ms before task is to be executed.
        long period = 1000L; // time in ms between successive task executions
        timer.scheduleAtFixedRate(task, delay, period);
        ThreadEndGame threadEndGame = new ThreadEndGame(GUI.getTurn(), timer);
    }

    /**
     * @param metodo per gli eventi
     * @param e      the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 8; i++) {       // colonna
            for (int j = 0; j < 8; j++) {   // riga
                if (e.getSource() == view.getChessBoardSquares(i, j)) {
                    if (view.getGame().getBoard().getBox(i, j).getPiece() != null) {
                        if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite() != view.getGame().isCurrentTurnBianco()) {
                            if (oldBox.getPiece().canMove(view.getGame().getBoard(), oldBox, view.getGame().getBoard().getBox(i, j))) {
                                view.getGame().makeMove(oldBox.getX(), oldBox.getY(), i, j);        // mangio un pezzo
                                updateChessBoardIcons();        // aggiorno e pulisco la scacchiera
                            }
                        } else {
                            oldBox = view.getGame().getBoard().getBox(i, j);
                            updateChessBoardIcons();
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    if (view.getGame().getBoard().getBox(i, j).getPiece().canMove(view.getGame().getBoard(), view.getGame().getBoard().getBox(i, j), view.getGame().getBoard().getBox(k, l))) {
                                        if (view.getGame().isCurrentTurnBianco()) {
                                            if (view.getGame().getBoard().getBox(k, l).getPiece() != null) {
                                                updateRiskIcon(k, l);
                                            } else
                                                view.getChessBoardSquares(k, l).setIcon(new ImageIcon("clickable_white.png"));
                                        } else {
                                            if (view.getGame().getBoard().getBox(k, l).getPiece() != null) {
                                                updateRiskIcon(k, l);
                                            } else
                                                view.getChessBoardSquares(k, l).setIcon(new ImageIcon("clickable_black.png"));
                                        }
                                    }
                                }
                            }
                        }
                    } else {        // making moves etc
                        try {
                            if (view.getGame().isCurrentTurnBianco()) {
                                if (view.getChessBoardSquares(i, j).getIcon().toString() == "clickable_white.png") {
                                    if (oldBox.getPiece().canMove(view.getGame().getBoard(), oldBox, view.getGame().getBoard().getBox(i, j))) {
                                        view.getGame().makeMove(oldBox.getX(), oldBox.getY(), i, j);
                                        updateChessBoardIcons();        // aggiorno e pulisco la scacchiera
                                    }
                                }
                            } else {
                                if (view.getChessBoardSquares(i, j).getIcon().toString() == "clickable_black.png") {
                                    if (oldBox.getPiece().canMove(view.getGame().getBoard(), oldBox, view.getGame().getBoard().getBox(i, j))) {
                                        view.getGame().makeMove(oldBox.getX(), oldBox.getY(), i, j);
                                        updateChessBoardIcons();        // aggiorno e pulisco la scacchiera
                                    }
                                }
                            }
                        } catch (NullPointerException noIconException) {            // eccezione custom
                            System.out.println(noIconException.getMessage());
                            updateChessBoardIcons();        // se clicco sul bianco allora resetto la scacchiera
                        }
                    }
                }
            }
        }
        boardOutput();

    }

    /**
     * @param metodo che aggiorna le icone della chessboard
     */
    public void updateChessBoardIcons() {
        for (int i = 0; i < 8; i++) {       // guardando la scacchiera in Board.java
            for (int j = 0; j < 8; j++) {

                if (view.getGame().getBoard().getBox(i, j).getPiece() == null) { // se nessun pezzo
                    view.getChessBoardSquares(i, j).setIcon(null);
                }

                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof King) {    // se king
                    if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite()) {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(1, 0)));
                    } else {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(0, 0)));
                    }
                }

                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Queen) {
                    if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite()) {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(1, 1)));
                    } else {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(0, 1)));
                    }
                }

                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Rook) {
                    if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite()) {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(1, 2)));
                    } else {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(0, 2)));
                    }
                }

                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Knight) {
                    if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite()) {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(1, 3)));
                    } else {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(0, 3)));
                    }
                }

                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Bishop) {
                    if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite()) {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(1, 4)));
                    } else {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(0, 4)));
                    }
                }

                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Pawn) {
                    if (view.getGame().getBoard().getBox(i, j).getPiece().isWhite()) {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(1, 5)));
                    } else {
                        view.getChessBoardSquares(i, j).setIcon(new ImageIcon(view.getChessPieceImage(0, 5)));
                    }
                }
            }
        }
    }

    public void updateRiskIcon(int a, int b) {
        if (view.getGame().getBoard().getBox(a, b).getPiece() instanceof King) {    // se king
            if (view.getGame().getBoard().getBox(a, b).getPiece().isWhite()) {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(1, 0)));
            } else {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(0, 0)));
            }
        }

        if (view.getGame().getBoard().getBox(a, b).getPiece() instanceof Queen) {
            if (view.getGame().getBoard().getBox(a, b).getPiece().isWhite()) {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(1, 1)));
            } else {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(0, 1)));
            }
        }

        if (view.getGame().getBoard().getBox(a, b).getPiece() instanceof Rook) {
            if (view.getGame().getBoard().getBox(a, b).getPiece().isWhite()) {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(1, 2)));
            } else {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(0, 2)));
            }
        }

        if (view.getGame().getBoard().getBox(a, b).getPiece() instanceof Knight) {
            if (view.getGame().getBoard().getBox(a, b).getPiece().isWhite()) {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(1, 3)));
            } else {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(0, 3)));
            }
        }

        if (view.getGame().getBoard().getBox(a, b).getPiece() instanceof Bishop) {
            if (view.getGame().getBoard().getBox(a, b).getPiece().isWhite()) {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(1, 4)));
            } else {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(0, 4)));
            }
        }

        if (view.getGame().getBoard().getBox(a, b).getPiece() instanceof Pawn) {
            if (view.getGame().getBoard().getBox(a, b).getPiece().isWhite()) {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(1, 5)));
            } else {
                view.getChessBoardSquares(a, b).setIcon(new ImageIcon(view.getChessRiskImages(0, 5)));
            }
        }
    }

    public void boardOutput() {
        for (int j = 0; j < 8; j++) { // Y
            for (int i = 0; i < 8; i++) { // X
                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Rook)
                    System.out.print(j + " | " + i + " //Rook//    ");
                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Knight)
                    System.out.print(j + " | " + i + " //Knight//  ");
                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Bishop)
                    System.out.print(j + " | " + i + " //Bishop//  ");
                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Queen)
                    System.out.print(j + " | " + i + " //Queen//   ");
                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof King)
                    System.out.print(j + " | " + i + " //King//    ");
                if (view.getGame().getBoard().getBox(i, j).getPiece() instanceof Pawn)
                    System.out.print(j + " | " + i + " //Pawn//    ");
                if (view.getGame().getBoard().getBox(i, j).getPiece() == null)
                    System.out.print(j + " | " + i + " ||Empty||   ");
            }
            System.out.println("\n");
        }   // System out di tutta la Board.java
        System.out.println("\n ---- FINE CONTROLLO ---- ");
    }

    public void checkMate() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (view.getGame().getBoard().getBox(i, j).getPiece().canMove(view.getGame().getBoard(), view.getGame().getBoard().getBox(i,j), view.getGame().getBoard().getBox(k,l))){
                            if(view.getGame().getBoard().getBox(k,l).getPiece() instanceof King){
                                int count = 0;
                                for (int m = 0; m < 8; m++) {
                                    for (int n = 0; n < 8; n++) {
                                        if(view.getGame().getBoard().getBox(k, l).getPiece().canMove(view.getGame().getBoard(), view.getGame().getBoard().getBox(k,l),view.getGame().getBoard().getBox(m,n))){
                                            count++;
                                        }
                                    }
                                }
                                if(count == 0){
                                    // è un checkmate

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
