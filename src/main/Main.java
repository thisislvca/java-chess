package main;

import control.*;
import model.ThreadEndGame;
import model.Turn;
import model.UsernamesManagement;
import view.GUI;

import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Baldin Riccardo, Giacomo de Marchi, Meneghetti Luca
 * @param Main
 */
public class Main {
    public static void main(String[] args) {
        Turn turn = new Turn();
        UsernamesManagement usernamesManagement = new UsernamesManagement();
        GUI GUI = new GUI(usernamesManagement, turn);
        ControllerSignUp controllerSignUp = new ControllerSignUp(GUI, GUI.getRegisterPanel(), usernamesManagement);
        ControllerLogIn controllerLogIn = new ControllerLogIn(GUI, GUI.getLogInPanel(), usernamesManagement);
        ControllerModify controllerModify = new ControllerModify(GUI, GUI.getModifyPanel(), GUI.getOptionPaneMod(), usernamesManagement);
        ControllerGameOptions controllerGameOptions = new ControllerGameOptions(GUI, GUI.getGameOptionsPanel(), usernamesManagement, GUI.getTurn());

        TimerTask task = new TimerTask() {

            public void run() {
                if (GUI.getChessBoard() != null) {
                    if (GUI.getTurn().hasGameStarted) {
                        ControllerScacchiera controllerScacchiera = new ControllerScacchiera(GUI, GUI.getChessBoard(), usernamesManagement);
                    }
                    GUI.getTurn().hasGameStarted = false;

                }
            }
        };


        Timer timer = new Timer();
        long delay = 1000L; // delay in ms before task is to be executed.
        long period = 1000L; // time in ms between successive task executions
        timer.scheduleAtFixedRate(task, delay, period);
        ThreadEndGame threadEndGame = new ThreadEndGame(GUI.getTurn(), timer);
    }
}