package view;

import model.Game;
import model.ThreadTimer;
import model.Turn;
import model.UsernamesManagement;
import model.player.HumanPlayer;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;

/**
 * @param Scacchiera
 */
public class ChessBoard {

    private              Game        game              = null;
    private final        JPanel      gui               = new JPanel(new BorderLayout(3, 3));
    private              JButton[][] chessBoardSquares = new JButton[8][8];
    private              Image[][]   chessPieceImages  = new Image[2][6];
    private              Image[][]   chessRiskImages   = new Image[2][6];
    private              JPanel      chessBoard;
    private final        JLabel      message           = new JLabel("Scacchi in java!"); // @note attention
    private static final String      COLS              = "ABCDEFGH";
    public static final  int         QUEEN             = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK};
    public static final int   BLACK        = 0, WHITE = 1;
    private ThreadTimer         threadTimerP1;
    private JLabel              lblTimerP1;
    private ThreadTimer         threadTimerP2;
    private JLabel              lblTimerP2;
    private UsernamesManagement usernamesManagement;
    private Turn                turn;


    public ChessBoard(int timerSetUp, UsernamesManagement usernamesManagement, Turn turn) {        // costruttore finestra
        this.usernamesManagement = usernamesManagement;
        this.turn = turn;
        setUpThreadTimer(timerSetUp);
    }

    /**
     * @param metodo di setup per il thread del timer
     * @param timerSetUp
     */
    public void setUpThreadTimer(int timerSetUp) {
        // -- creo una label che mi servira' poi per il timer
        lblTimerP1 = new JLabel();
        // -- creo il threadTimer per istanziare i suoi attributi con il tempo scelto dall'utente e passandogli la lbl che modifichera' ogni secondo
        threadTimerP1 = new ThreadTimer(timerSetUp, lblTimerP1, turn, 0);


        lblTimerP2 = new JLabel();
        threadTimerP2 = new ThreadTimer(timerSetUp, lblTimerP2, turn, 1);

        // -- inizializzo la gui della ChessBoard
        initializeGui();
    }

    /**
     * @param metodo per inizializzare la GUI
     */
    public final void initializeGui() {
        // create the images for the chess pieces
        createImages();
        createRiskImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));

        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        tools.setBackground(new Color(140, 140, 140));
        tools.addSeparator(new Dimension(360, 0));

        Scanner read;
        if (usernamesManagement.getP2().equals("")) {
            try {
                read = new Scanner(new BufferedReader(new FileReader(usernamesManagement.getP1() + ".txt")));
                String[] data = new String[12];

                int i = 0;
                boolean check = false;
                do {
                    while (read.hasNext()) {
                        data[i] = read.nextLine();
                        if (data[i].equals("")) {
                            check = true;
                            break;
                        }
                        i++;
                    }
                } while (check);
                read.close();
                System.out.println("Read chiuso");

                tools = new JToolBar();
                tools.setFloatable(false);
                tools.setBackground(new Color(140, 140, 140));
                tools.addSeparator(new Dimension(3, 0));
                tools.add(new JLabel("Player " + usernamesManagement.getP1()));
                tools.addSeparator();
                if (data[7].equals("0")) {
                    tools.add(new JLabel("Nessun Rank"));
                } else {
                    tools.add(new JLabel("Rank #" + data[7]));
                }

                tools.addSeparator(new Dimension(510, 0));
                tools.add(lblTimerP1);
                gui.add(tools, BorderLayout.PAGE_END);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                read = new Scanner(new BufferedReader(new FileReader(usernamesManagement.getP1() + ".txt")));
                String[] data = new String[12];

                int i = 0;
                boolean check = false;
                do {
                    while (read.hasNext()) {
                        data[i] = read.nextLine();
                        if (data[i].equals("")) {
                            check = true;
                            break;
                        }
                        i++;
                    }
                } while (check);
                read.close();
                System.out.println("Read chiuso");

                tools = new JToolBar();
                tools.setFloatable(false);
                tools.setBackground(new Color(140, 140, 140));
                tools.addSeparator(new Dimension(3, 0));
                tools.add(new JLabel("Player " + usernamesManagement.getP1()));
                tools.addSeparator();
                if (data[7].equals("0")) {
                    tools.add(new JLabel("Nessun Rank"));
                } else {
                    tools.add(new JLabel("Rank #" + data[7]));
                }

                tools.addSeparator(new Dimension(510, 0));
                tools.add(lblTimerP1);
                gui.add(tools, BorderLayout.PAGE_END);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                read = new Scanner(new BufferedReader(new FileReader(usernamesManagement.getP2() + ".txt")));
                String[] data = new String[12];

                int i = 0;
                boolean check = false;
                do {
                    while (read.hasNext()) {
                        data[i] = read.nextLine();
                        if (data[i].equals("")) {
                            check = true;
                            break;
                        }
                        i++;
                    }
                } while (check);
                read.close();
                System.out.println("Read chiuso");

                tools = new JToolBar();
                tools.setFloatable(false);
                tools.setBackground(new Color(140, 140, 140));
                tools.addSeparator(new Dimension(3, 0));
                tools.add(new JLabel("Player " + usernamesManagement.getP2()));
                tools.addSeparator();
                if (data[7].equals("0")) {
                    tools.add(new JLabel("Nessun Rank"));
                } else {
                    tools.add(new JLabel("Rank #" + data[7]));
                }

                tools.addSeparator(new Dimension(510, 0));
                tools.add(lblTimerP2);
                gui.add(tools, BorderLayout.PAGE_START);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


        gui.setBackground(new Color(140, 140, 140));

        chessBoard = new JPanel(new GridLayout(0, 9)) {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstraint (so it is centered).
             */

            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
                } else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (Math.min(w, h));
                return new Dimension(s, s);
            }
        };

        chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));

        // Setto il background color

        chessBoard.setBackground(new Color(140, 140, 140));
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(new Color(140, 140, 140));
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // fill the white non pawn pieces
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                b.setBorderPainted(false);
                b.setOpaque(true);
                if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.white);
                    b.setForeground(Color.white);
                } else {
                    b.setBackground(Color.black);
                    b.setForeground(Color.black);
                }
                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                chessBoardSquares[jj][ii] = b;
            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(new JLabel(COLS.substring(ii, ii + 1), SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9 - (ii + 1)), SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }

    public final JComponent getGui() {
        return gui;
    }

    /**
     * @param metodo per creare le immagini delle pedine
     */
    private final void createImages() {
        try {
            BufferedImage bi = ImageIO.read(this.getClass().getResource("chessPieces_toEdit.png"));
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private final void createRiskImages() {
        try {
            BufferedImage bi = ImageIO.read(this.getClass().getResource("chessPieces_killRisk.png"));
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessRiskImages[ii][jj] = bi.getSubimage(jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param Inizializza le icone dei posti iniziali dei pezzi della scacchiera
     */
    public final void setupNewGame() {
        message.setText("Fai una mossa!");
        // set up the black pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][0].setIcon(new ImageIcon(chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][1].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
        }
        // set up the white pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][6].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][7].setIcon(new ImageIcon(chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }

        HumanPlayer player1 = new HumanPlayer(true, "pippo");
        HumanPlayer player2 = new HumanPlayer(false, "baudo");

        game = new Game(player1, player2);
    }


    public JButton getChessBoardSquares(int x, int y) {
        return chessBoardSquares[x][y];
    }

    public Game getGame() {
        return game;
    }

    public void listener(ActionListener e) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardSquares[i][j].addActionListener(e);
            }
        }
    }

    public Image getChessPieceImage(int color, int piece) {
        return chessPieceImages[color][piece];
    }

    public Image getChessRiskImages(int color, int piece) {
        return chessRiskImages[color][piece];
    }

    public ThreadTimer getThreadTimerP1() {
        return threadTimerP1;
    }

    public ThreadTimer getThreadTimerP2() {
        return threadTimerP2;
    }
}