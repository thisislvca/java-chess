package view;

import model.UsernamesManagement;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 * @param Finestra per le opzioni di gioco
 */
public class GameOptionsPanel extends JPanel {

    // --- attributi
    private UsernamesManagement usernamesManagement;
    private JPanel              contentPane;
    private JLabel              lblTitolo;
    private JLabel              lblModiltaGioco;
    private JLabel              lblColore;
    private ButtonGroup         gameMode;
    private JRadioButton        radBtnSP;
    private JRadioButton        radBtnMP;
    private ButtonGroup         colors;
    private JRadioButton        radBtnWhite;
    private JRadioButton        radBtnBlack;
    private JLabel              lblTimer;
    private JComboBox           comboBox1;
    private JButton             BtnStartGame;
    private JButton             BtnLogOut;
    private JButton             BtnModify;
    private JLabel              lblMsg;
    private JComboBox           comboBoxOpponents;
    private JLabel              lblOpponents;
    private JPanel              spacer10;
    private boolean             checkVisibility;

    /**
     * @param costruttore
     * @param usernamesManagement
     * @param checkVisibility
     */
    public GameOptionsPanel(UsernamesManagement usernamesManagement, boolean checkVisibility) {
        this.usernamesManagement = usernamesManagement;
        this.checkVisibility = checkVisibility;
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        lblTitolo = new JLabel();
        Font lblTitoloFont = this.$$$getFont$$$(null, -1, 48, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Avvia Partita");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        contentPane.add(lblTitolo, gbc);
        lblModiltaGioco = new JLabel();
        lblModiltaGioco.setEnabled(true);
        Font lblModiltaGiocoFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblModiltaGioco.getFont());
        if (lblModiltaGiocoFont != null) lblModiltaGioco.setFont(lblModiltaGiocoFont);
        lblModiltaGioco.setHorizontalAlignment(0);
        lblModiltaGioco.setText("Modalit\u00E1 Gioco");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        contentPane.add(lblModiltaGioco, gbc);
        lblColore = new JLabel();
        Font lblColoreFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblColore.getFont());
        if (lblColoreFont != null) lblColore.setFont(lblColoreFont);
        lblColore.setHorizontalAlignment(0);
        lblColore.setText("Colore");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        contentPane.add(lblColore, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 25;
        contentPane.add(spacer2, gbc);
        radBtnSP = new JRadioButton();
        radBtnSP.setText("SinglePlayer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        contentPane.add(radBtnSP, gbc);
        radBtnMP = new JRadioButton();
        radBtnMP.setText("MultiPlayer");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        contentPane.add(radBtnMP, gbc);
        radBtnBlack = new JRadioButton();
        radBtnBlack.setText("Neri");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 40;
        contentPane.add(radBtnBlack, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 25;
        contentPane.add(spacer3, gbc);
        radBtnWhite = new JRadioButton();
        radBtnWhite.setText("Bianchi");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 10;
        contentPane.add(radBtnWhite, gbc);
        lblTimer = new JLabel();
        Font lblTimerFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblTimer.getFont());
        if (lblTimerFont != null) lblTimer.setFont(lblTimerFont);
        lblTimer.setText("Timer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        contentPane.add(lblTimer, gbc);
        comboBox1 = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(comboBox1, gbc);
        BtnStartGame = new JButton();
        Font BtnStartGameFont = this.$$$getFont$$$(null, Font.BOLD, -1, BtnStartGame.getFont());
        if (BtnStartGameFont != null) BtnStartGame.setFont(BtnStartGameFont);
        BtnStartGame.setText("AVVIA");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 7;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        contentPane.add(BtnStartGame, gbc);
        BtnLogOut = new JButton();
        BtnLogOut.setText("LOGOUT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 3;
        contentPane.add(BtnLogOut, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 80;
        contentPane.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 20;
        contentPane.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer8, gbc);
        BtnModify = new JButton();
        Font BtnModifyFont = this.$$$getFont$$$(null, -1, -1, BtnModify.getFont());
        if (BtnModifyFont != null) BtnModify.setFont(BtnModifyFont);
        BtnModify.setText("MODIFICA ACCOUNT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 3;
        contentPane.add(BtnModify, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 5;
        contentPane.add(spacer9, gbc);
        lblMsg = new JLabel();
        lblMsg.setHorizontalAlignment(0);
        lblMsg.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 30;
        contentPane.add(lblMsg, gbc);
        spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer10, gbc);
        comboBoxOpponents = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        comboBoxOpponents.setVisible(checkVisibility);
        contentPane.add(comboBoxOpponents, gbc);
        lblOpponents = new JLabel();
        Font lblOpponentsFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblOpponents.getFont());
        if (lblOpponentsFont != null) lblOpponents.setFont(lblOpponentsFont);
        lblOpponents.setText("Scegli Avversario");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        lblOpponents.setVisible(checkVisibility);
        contentPane.add(lblOpponents, gbc);
        gameMode = new ButtonGroup();
        gameMode.add(radBtnSP);
        gameMode.add(radBtnMP);
        colors = new ButtonGroup();
        colors.add(radBtnWhite);
        colors.add(radBtnBlack);

        comboBox1.addItem("1 minuto");
        comboBox1.addItem("3 minuti");
        comboBox1.addItem("5 minuti");
        comboBox1.addItem("10 minuti");

        add(contentPane);
        setVisible(true);
    }

    // --- Getters
    // #################### JLABELS ####################
    public JLabel getLblMsg() {
        return lblMsg;
    }

    public JLabel getLblOpponents() {
        return lblOpponents;
    }

    // #################### JCOMBO BOX ####################
    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getComboBoxOpponents() {
        return comboBoxOpponents;
    }

    // #################### JBUTTON GROUPS ####################
    public ButtonGroup getGameMode() {
        return gameMode;
    }

    public ButtonGroup getColors() {
        return colors;
    }

    // #################### JBUTTONS ####################
    public JRadioButton getRadBtnSP() {
        return radBtnSP;
    }

    public JRadioButton getRadBtnMP() {
        return radBtnMP;
    }

    public JRadioButton getRadBtnWhite() {
        return radBtnWhite;
    }

    public JRadioButton getRadBtnBlack() {
        return radBtnBlack;
    }

    public JButton getBtnStartGame() {
        return BtnStartGame;
    }

    public JButton getBtnLogOut() {
        return BtnLogOut;
    }

    public JButton getBtnModify() {
        return BtnModify;
    }

    // #################### METODI CAMBIO VISIBILITA' MULTIPLAYER  ####################

    public void setOnVisibility() {
        getComboBoxOpponents().setVisible(true);
        getLblOpponents().setVisible(true);
    }

    public void setOffVisibility() {
        getComboBoxOpponents().setVisible(false);
        getLblOpponents().setVisible(false);
    }

    // #################### METODO TIMER ####################
    public int setTime() {
        String time = String.valueOf(getComboBox1().getSelectedItem());
        int timeForTimer;
        switch (time) {
            case "1 minuto" -> timeForTimer = 1;
            case "3 minuti" -> timeForTimer = 3;
            case "5 minuti" -> timeForTimer = 5;
            case "10 minuti" -> timeForTimer = 10;
            default -> timeForTimer = 0;
        }
        return timeForTimer;
    }

    // #################### METODO COMBO BOX MULTIPLAYER ####################
    public void createComboBoxMultiplayer() {
        Scanner read;
        try {
            // -- istanzio un fileReader cosi' da poter leggere i dati contenuti nell'UsernamesManagement file
            read = new Scanner(new BufferedReader(new FileReader("UsernamesManagement.txt")));
            // -- istanzio un array di String per contenere gli usernames che otteniamo dal file aperto in read
            String[] data = new String[64];

            int i = 0;
            boolean check = false;
            do {
                // -- affinche' il file UsernamesManagement ha del contenuto il ciclo continua
                while (read.hasNext()) {
                    // - quindi mi salvo all'interno dell'array il contenuto del file
                    data[i] = read.nextLine();
                    // - se quest ultimo e' vuoto
                    if (data[i].equals("")) {
                        // lo faccio uscire dal ciclo
                        check = true;
                        break;
                    }
                    i++;
                }
            } while (check);
            read.close();
            System.out.println("Read chiuso");

            // --- for che mi serve per inserire dentro la comboBox gli avversari disponibili
            for (i = 0; i < data.length; i++) {
                // -- controllo se la stringa all'interno dell'array non sia null e dopo controllo se la stringa presa sia uguale al player1, ovvero quello loggato, e se lo e' non lo aggiungo alla comboBox
                if (data[i] != null && !data[i].equals(usernamesManagement.getP1())) {
                    comboBoxOpponents.addItem(data[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // #################### METODI RESET CAMPI ####################
    public void emptyFields() {
        getGameMode().clearSelection();
        getColors().clearSelection();
        getComboBox1().setSelectedIndex(0);
        getComboBoxOpponents().removeAllItems();
        setOffVisibility();
    }

    public void emptyMsg() {
        lblMsg.setText("");
    }

    // #################### METODI MESSAGGI ####################
    public void errorMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsg().setForeground(new Color(208, 1, 1));
                getLblMsg().setText(frase);
            }
        }
    }

    public void successMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsg().setForeground(new Color(1, 178, 16));
                getLblMsg().setText(frase);
            }
        }
    }

    public void warningMsg(int i, String frase) {
        switch (i) {
            case 0 -> {
                getLblMsg().setForeground(new Color(208, 150, 1));
                getLblMsg().setText(frase);
            }
        }
    }

    // #################### METODO LISTENER ####################
    public void listener(ActionListener e) {
        getBtnLogOut().addActionListener(e);
        getBtnStartGame().addActionListener(e);
        getBtnModify().addActionListener(e);
        getRadBtnSP().addActionListener(e);
        getRadBtnMP().addActionListener(e);
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
        contentPane.setLayout(new GridBagLayout());
        lblTitolo = new JLabel();
        Font lblTitoloFont = this.$$$getFont$$$(null, -1, 48, lblTitolo.getFont());
        if (lblTitoloFont != null) lblTitolo.setFont(lblTitoloFont);
        lblTitolo.setHorizontalAlignment(0);
        lblTitolo.setText("Avvia Partita");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        contentPane.add(lblTitolo, gbc);
        lblModiltaGioco = new JLabel();
        lblModiltaGioco.setEnabled(true);
        Font lblModiltaGiocoFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblModiltaGioco.getFont());
        if (lblModiltaGiocoFont != null) lblModiltaGioco.setFont(lblModiltaGiocoFont);
        lblModiltaGioco.setHorizontalAlignment(0);
        lblModiltaGioco.setText("Modalita Gioco");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        contentPane.add(lblModiltaGioco, gbc);
        lblColore = new JLabel();
        Font lblColoreFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblColore.getFont());
        if (lblColoreFont != null) lblColore.setFont(lblColoreFont);
        lblColore.setHorizontalAlignment(0);
        lblColore.setText("Colore");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        contentPane.add(lblColore, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 25;
        contentPane.add(spacer2, gbc);
        radBtnSP = new JRadioButton();
        radBtnSP.setText("SinglePlayer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        contentPane.add(radBtnSP, gbc);
        radBtnMP = new JRadioButton();
        radBtnMP.setText("MultiPlayer");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        contentPane.add(radBtnMP, gbc);
        radBtnBlack = new JRadioButton();
        radBtnBlack.setText("Neri");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 40;
        contentPane.add(radBtnBlack, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 25;
        contentPane.add(spacer3, gbc);
        radBtnWhite = new JRadioButton();
        radBtnWhite.setText("Bianchi");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 10;
        contentPane.add(radBtnWhite, gbc);
        lblTimer = new JLabel();
        Font lblTimerFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblTimer.getFont());
        if (lblTimerFont != null) lblTimer.setFont(lblTimerFont);
        lblTimer.setText("Timer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        contentPane.add(lblTimer, gbc);
        comboBox1 = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(comboBox1, gbc);
        BtnStartGame = new JButton();
        Font BtnStartGameFont = this.$$$getFont$$$(null, Font.BOLD, -1, BtnStartGame.getFont());
        if (BtnStartGameFont != null) BtnStartGame.setFont(BtnStartGameFont);
        BtnStartGame.setText("AVVIA");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 7;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        contentPane.add(BtnStartGame, gbc);
        BtnLogOut = new JButton();
        BtnLogOut.setText("LOGOUT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 3;
        contentPane.add(BtnLogOut, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 40;
        contentPane.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 80;
        contentPane.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 20;
        contentPane.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer8, gbc);
        BtnModify = new JButton();
        Font BtnModifyFont = this.$$$getFont$$$(null, -1, -1, BtnModify.getFont());
        if (BtnModifyFont != null) BtnModify.setFont(BtnModifyFont);
        BtnModify.setText("MODIFICA ACCOUNT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 3;
        contentPane.add(BtnModify, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 5;
        contentPane.add(spacer9, gbc);
        lblMsg = new JLabel();
        lblMsg.setHorizontalAlignment(0);
        lblMsg.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 30;
        contentPane.add(lblMsg, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        contentPane.add(spacer11, gbc);
        comboBoxOpponents = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 150;
        contentPane.add(comboBoxOpponents, gbc);
        lblOpponents = new JLabel();
        Font lblOpponentsFont = this.$$$getFont$$$(null, Font.BOLD, -1, lblOpponents.getFont());
        if (lblOpponentsFont != null) lblOpponents.setFont(lblOpponentsFont);
        lblOpponents.setText("Scegli Avversario");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(lblOpponents, gbc);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radBtnSP);
        buttonGroup.add(radBtnMP);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radBtnWhite);
        buttonGroup.add(radBtnBlack);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
