package control;

import model.Turn;
import model.UsernamesManagement;
import view.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @param Classe per la gestione degli eventi delle opzioni del gioco
 */
public class ControllerGameOptions implements ActionListener {

    // --- attributi
    private final GUI                 GUI;
    private final GameOptionsPanel    gameOptionsPanel;
    private final UsernamesManagement usernamesManagement;
    private       Turn                turn;

    /**
     * @param costruttore
     * @param GUI
     * @param gameOptionsPanel
     * @param usernamesManagement
     */
    public ControllerGameOptions(GUI GUI, GameOptionsPanel gameOptionsPanel, UsernamesManagement usernamesManagement, Turn turn) {
        this.GUI = GUI;
        this.gameOptionsPanel = gameOptionsPanel;
        this.usernamesManagement = usernamesManagement;
        this.turn = turn;

        gameOptionsPanel.listener(this);
    }

    // ---

    /**
     * @param metodo per gli eventi
     * @param e      the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // ############################## BOTTONE RADIO MULTIPLAYER ##############################
        if (e.getSource() == gameOptionsPanel.getRadBtnMP()) {
            // -- chiamo il metodo per aggiungere alla comboBox degli avversari tutti gli usernames presenti nel database
            gameOptionsPanel.createComboBoxMultiplayer();
            // -- rendo visibile la comboBox
            GUI.getGameOptionsPanel().setOnVisibility();
            GUI.setContent(2, new Dimension(950, 750));
        }

        // ############################## BOTTONE RADIO SINGLEPLAYER ##############################
        if (e.getSource() == gameOptionsPanel.getRadBtnSP()) {
            // -- rimuovo ogni elemento della comboBox degli avversari
            gameOptionsPanel.getComboBoxOpponents().removeAllItems();
            // -- rendo non visibile la comboBox
            GUI.getGameOptionsPanel().setOffVisibility();
            GUI.setContent(2, new Dimension(950, 750));
        }

//        // ############################## BOTTONE RADIO BIANCHI ##############################
//        if(e.getSource() == gameOptionsPanel.getRadBtnWhite()){
//
//        }
//
//        // ############################## BOTTONE RADIO NERI ##############################
//        if(e.getSource() == gameOptionsPanel.getRadBtnBlack()){
//
//        }

        // ############################## BOTTONE AVVIA PARTITA ##############################
        if (e.getSource() == gameOptionsPanel.getBtnStartGame()) {

            // --- varie dichiarazioni degli attributi temporanei
            char colors = ' ';
            String game_mode = "";
            String timer = (String) gameOptionsPanel.getComboBox1().getSelectedItem();
            String p2 = (String) gameOptionsPanel.getComboBoxOpponents().getSelectedItem();

            // --- controllo i radio buttons, se sono selezionati gli do' un certo valore
            if (gameOptionsPanel.getRadBtnMP().isSelected()) {
                // -- mp se multiplayer
                game_mode = "MP";
            }
            if (gameOptionsPanel.getRadBtnSP().isSelected()) {
                // -- sp se singleplayer
                game_mode = "SP";
            }

            if (gameOptionsPanel.getRadBtnWhite().isSelected()) {
                // -- W se bianchi
                colors = 'W';
                usernamesManagement.setP2(p2);
            }

            if (gameOptionsPanel.getRadBtnBlack().isSelected()) {
                // -- B se neri
                colors = 'B';
                String p1 = usernamesManagement.getP1();
                usernamesManagement.setP1(p2);
                usernamesManagement.setP2(p1);
            }

            // --- if di controllo dati temporanei
            if (game_mode.equals("MP") || game_mode.equals("SP") && colors == 'W' || colors == 'B') {
                // -- esecuzione gioco
                turn.hasGameStarted = true;
                GUI.setContent(4, new Dimension(800, 800));
            } else if (!game_mode.equals("MP") && !game_mode.equals("SP")) {
                // -- creazione messaggio per avvertire l'utente che nessun radio button della modalita' di gioco e' stato selezionato
                gameOptionsPanel.emptyMsg();
                GUI.setContent(2, new Dimension(950, 750));
                gameOptionsPanel.warningMsg(0, "Selezionare una modalit\u00E1 di gioco!");
                gameOptionsPanel.emptyFields();
            } else if (colors != 'W' && colors != 'B') {
                // -- creazione messaggio per avvertire l'utente che nessun radio button dei colori e' stato selezionato
                gameOptionsPanel.emptyMsg();
                GUI.setContent(2, new Dimension(950, 750));
                gameOptionsPanel.warningMsg(0, "Selezionare un colore!");
                gameOptionsPanel.emptyFields();
            } else {
                // -- creazione messaggio d'errore per qualsiasi riscontro avuto oltre a quelli specificati
                gameOptionsPanel.emptyMsg();
                GUI.setContent(2, new Dimension(950, 750));
                gameOptionsPanel.errorMsg(0, "Errore avvio partita");
                gameOptionsPanel.emptyFields();
            }
        }

        // ############################## BOTTONE MODIFICA ACCOUNT ##############################
        if (e.getSource() == gameOptionsPanel.getBtnModify()) {
            // -- reindirizzo al pannello modifica profilo
            GUI.setContent(3, new Dimension(600, 500));
            gameOptionsPanel.emptyFields();
            gameOptionsPanel.emptyMsg();
        }

        // ############################## BOTTONE LOGOUT ##############################
        if (e.getSource() == gameOptionsPanel.getBtnLogOut()) {
            // -- resetto i player1 e 2 perche' l'utente ha fatto il log out
            usernamesManagement.setP1("");
            usernamesManagement.setP2("");
            // -- reindirizzo al pannello login
            GUI.setContent(1, new Dimension(750, 550));
            gameOptionsPanel.emptyFields();
            gameOptionsPanel.emptyMsg();
        }

    }
}
