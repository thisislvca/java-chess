package view;

import model.ThreadEndGame;
import model.Turn;
import model.UsernamesManagement;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @param GUI
 */
public class GUI extends JFrame {

    // --- attributi

    private       JPanel              contentPane;
    private final LogInPanel          logInPanel;
    private final RegisterPanel       registerPanel;
    private final ModifyPanel         modifyPanel;
    private final GameOptionsPanel    gameOptionsPanel;
    private final OptionPaneMod       optionPaneMod;
    private       ChessBoard          chessBoard;
    private       UsernamesManagement usernamesManagement;
    private       Turn                turn;

    /**
     * @param costruttore         GUI
     * @param usernamesManagement
     */
    public GUI(UsernamesManagement usernamesManagement, Turn turn) {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocation(new Point(100, 100));
        setSize(new Dimension(600, 400));

        // -- creazione di istanze per ogni pannello
        logInPanel = new LogInPanel();
        registerPanel = new RegisterPanel();
        modifyPanel = new ModifyPanel();
        this.usernamesManagement = usernamesManagement;
        this.turn = turn;
        gameOptionsPanel = new GameOptionsPanel(usernamesManagement, false);
        optionPaneMod = new OptionPaneMod();


        setSize(new Dimension(750, 650));
        setContentPane(registerPanel);

        this.setTitle("ScacchiGarim");
        setVisible(true);
    }

    // --- Getters
    // #################### GETTERS DEI PANNELLI ####################
    public LogInPanel getLogInPanel() {
        return logInPanel;
    }

    public RegisterPanel getRegisterPanel() {
        return registerPanel;
    }

    public ModifyPanel getModifyPanel() {
        return modifyPanel;
    }

    public GameOptionsPanel getGameOptionsPanel() {
        return gameOptionsPanel;
    }

    public OptionPaneMod getOptionPaneMod() {
        return optionPaneMod;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public Turn getTurn() {
        return turn;
    }

    // #################### METODO CAMBIO PANNELLI ####################
    public void setContent(int n, Dimension dimension) {
        switch (n) {
            case 1 -> {
                setSize(dimension);
                setContentPane(logInPanel);
            }
            case 2 -> {
                getTurn().hasGameStarted = false;
                getTurn().hasGameEnded = false;
                setSize(dimension);
                setContentPane(gameOptionsPanel);
            }
            case 3 -> {
                setSize(dimension);
                setContentPane(modifyPanel);
            }
            case 4 -> {
                setSize(dimension);

                JPanel chessPanel = new JPanel();
                chessPanel.setBackground(new Color(140, 140, 140));
                // -- creo un timerTask per creare una ChessBoard che possa andare insieme al threadTimer
                // -- altrimenti non si potrebbe aggiornare sia la mossa dell'utente che il timer allo stesso tempo
                TimerTask task = new TimerTask() {

                    public void run() {
                        setChessBoard(chessBoard = new ChessBoard(gameOptionsPanel.setTime(), usernamesManagement, getTurn()));
                        chessPanel.add(chessBoard.getGui());
                        chessBoard.setupNewGame();

                        chessPanel.setVisible(true);
                        setContentPane(chessPanel);
                    }
                };
                // -- creo il timer vero
                Timer timer = new Timer();
                // delay e' in millisecondi prima che la task sia eseguita in ms before task is to be executed.
                long delay = 1;
                // period e' in millisecondi serve per stabilire il tempo che deve passare per ogni esecuzione della task, per precauzione prendo il tempo scelto dall'utente e lo aumento
                long period = gameOptionsPanel.setTime() + 2 * 1000000L;
                timer.scheduleAtFixedRate(task, delay, period);
                ThreadEndGame threadEndGame = new ThreadEndGame(getTurn(), timer);
            }
            default -> {
                setSize(dimension);
                setContentPane(registerPanel);
            }
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
