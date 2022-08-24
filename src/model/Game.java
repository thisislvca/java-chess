package model;

import model.pieces.King;
import model.pieces.Piece;
import model.player.Player;

import java.util.List;

/**
 * @param Partita
 */
public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;

    private boolean isCurrentTurnBianco;
    private GameStatus status;

    /**
     * @param costruttore della partita
     * @param p1
     * @param p2
     */
    public Game(Player p1, Player p2) {    // costruttore
        initialize(p1, p2);     // inizializzo la partita
    }

    /**
     * @param metodo per avviare partita, setta chi deve giocare per primo
     * @param p1
     * @param p2
     */
    private void initialize(Player p1, Player p2)
    {
        players = new Player[20];
        players[0] = p1;
        players[1] = p2;

        board = new Board();

        board.resetBoard();                 // resetto la board

        isCurrentTurnBianco = true;
    }

    /**
     * @param metodo per vedere se la partita è finita
     * @return lo status del gioco, se finito o no
     */
    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE; // metodo che controlla la fine o meno della partita
    }

    /**
     * @param getter per ritornare lo status della partita
     * @return
     */
    public GameStatus getStatus() {
        return this.status;
    }
    /**
     * @param setter per settare lo status della partita
     * @return
     */
    public void setStatus(GameStatus status) {
        this.status = status;
    }

    /**
     * @param metodo per fare una mossa
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return la mossa che si sta facendo
     */
    public boolean makeMove(int startX, int startY, int endX, int endY) {
        Spot startBox = board.getBox(startX, startY);               // il player muove
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(startBox, endBox);
        return makeActualMove(move);
    }

    /**
     * @param metodo per eseguire la mossa scelta
     * @param move
     * @return false in base al caso
     */
    private boolean makeActualMove(Move move) {

        Piece sourcePiece = move.getStart().getPiece();             // eseguo la mossa
        if (sourcePiece == null) {
            return false;
        }

        if (sourcePiece.isWhite() != isCurrentTurnBianco) {
            return false;
        }
        // controllo se la mossa è valida
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        // uccide un pezzo avversario?
        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // fa l'arrocco?
        if (sourcePiece instanceof King && ((King) sourcePiece).isCastlingMove(move.getStart(), move.getEnd())) {
            move.setCastlingMove(true);
        }

        // muovo il pezzo da start a end
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece != null && destPiece instanceof King) {   // controllo se è scacco matto
            if (isCurrentTurnBianco) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // do il turno all'altro player

        /*if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }*/

        if (isCurrentTurnBianco) {
            isCurrentTurnBianco = false;
        } else {
            isCurrentTurnBianco = true;
        }

        return true;
    }

    // getters e setters


    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }


    public boolean isCurrentTurnBianco() {
        return isCurrentTurnBianco;
    }

    public void setCurrentTurnBianco(boolean currentTurnBianco) {
        isCurrentTurnBianco = currentTurnBianco;
    }
}
