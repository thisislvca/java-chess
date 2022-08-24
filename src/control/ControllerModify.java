package control;

import model.UsernamesManagement;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @param Classe per la gestione degli eventi della modifica dell'account
 */
public class ControllerModify implements ActionListener {

    // --- attributi
    private final GUI                 GUI;
    private final ModifyPanel         modifyPanel;
    private final OptionPaneMod       optionPaneMod;
    private final UsernamesManagement usernamesManagement;

    /**
     * @param costruttore
     * @param GUI
     * @param modifyPanel
     * @param optionPaneMod
     * @param usernamesManagement
     */

    public ControllerModify(GUI GUI, ModifyPanel modifyPanel, OptionPaneMod optionPaneMod, UsernamesManagement usernamesManagement) {
        this.GUI = GUI;
        this.modifyPanel = modifyPanel;
        this.optionPaneMod = optionPaneMod;
        this.usernamesManagement = usernamesManagement;
        modifyPanel.listener(this);
    }

    /**
     * @param metodo per gli eventi
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // ############################## BOTTONE MODIFCA ##############################
        if (e.getSource() == modifyPanel.getBtnModify()) {
            // -- creazione attributi temporanei per il controllo dei campi
            String old_username = modifyPanel.getTxtFUsernameModProfile().getText();
            String old_password = String.valueOf(modifyPanel.getPassFModProfile().getPassword());

            // --- controllo che i campi richiesti non siano vuoti + il campo password abbia una stringa con caratteri >= di 5
            if (!old_username.equals("") && !old_password.equals("") && old_password.length() > 4) {
                FileWriter fileWriter;
                try {
                    // -- JOptionPane per inserire i nuovi campi
                    int ris = JOptionPane.showConfirmDialog(null, optionPaneMod, "Sei sicuro di modificare il profilo?\nInserire i dati richiesti", JOptionPane.OK_CANCEL_OPTION);
                    switch (ris) {
                        case 0 -> {
                            // - creazione di attributi temporanei per la modifica dei campi
                            String new_username = optionPaneMod.getTxtFUsernameOptionPane().getText();
                            String new_password = String.valueOf(optionPaneMod.getPassFOptionPane().getPassword());

                            String check_file = "";
                            try {
                                // - istanzio file di controllo aprendo il file con lo username dato nei campi
                                check_file = new Scanner(new File(new_username + ".txt")).next();
                            } catch (FileNotFoundException ex) {

                            }
                            if (check_file.equals("")) {
                                // - stesso ragionamento del controllerLogin
                                Scanner read = new Scanner(new BufferedReader(new FileReader(old_username + ".txt")));
                                String[] data = new String[25];

                                int i = 0;
                                boolean check = false;
                                do {
                                    while (read.hasNext()) {
                                        read.useDelimiter("//");
                                        data[i] = Arrays.toString(read.nextLine().split("\n"));
                                        if (data[i].equals("")) {
                                            check = true;
                                            break;
                                        }
                                        i++;
                                    }
                                } while (check);
                                read.close();

                                // --- controllo se lo username e password corrispondo a quelle precedenti
                                if (Arrays.toString(new String[]{old_username}).equals(data[2]) && Arrays.toString(new String[]{old_password}).equals(data[3])) {
                                    // -- creo un file txt nel quale riscrivo i dati aggiornati
                                    fileWriter = new FileWriter(new_username + ".txt");
                                    // -- se il file esiste posso scriverci dentro
                                    try (BufferedWriter bufferedwriter = new BufferedWriter(fileWriter)) {
                                        // - apro il file vecchio
                                        File old_file = new File(old_username + ".txt");
                                        // - per poi eliminarlo
                                        old_file.delete();

                                        // - scrivo sul file username e password aggiornati
                                        bufferedwriter.write(data[0] + "\n");
                                        bufferedwriter.write(data[1] + "\n");
                                        bufferedwriter.write(new_username + "\n");
                                        bufferedwriter.write(new_password + "\n");
                                        bufferedwriter.write(data[4] + "\n"); // win
                                        bufferedwriter.write(data[5] + "\n"); // loss
                                        bufferedwriter.write(data[6] + "\n"); // win/loss
                                        bufferedwriter.write(data[7] + "\n"); // rank
                                        bufferedwriter.write("//\n");
                                        // - chiamo il metodo per modificare lo username all'interno del "database"
                                        usernamesManagement.modify(old_username, new_username);
                                        // - chiudo il file e finisco di scrivere
                                        bufferedwriter.close();
                                        modifyPanel.emptyFields();
                                        modifyPanel.emptyMsg();
                                        // - reindirizzo alla pagina di gioco
                                        usernamesManagement.setP1(new_username);
                                        GUI.setContent(2, new Dimension(1000, 650));
                                        optionPaneMod.emptyFields();
                                    } catch (Exception ev) {

                                    }
                                } else if (!Arrays.toString(new String[]{old_username}).equals(data[2])) {
                                    // -- creazione messaggio per avvertire l'utente che lo username inserito non corrisponde a nessun file
                                    modifyPanel.emptyMsg();
                                    GUI.setContent(3, new Dimension(1100, 550));
                                    modifyPanel.warningMsg(2, "Attenzione il vecchio username non corrisponde con nessun profilo esistente");
                                } else if (!Arrays.toString(new String[]{old_password}).equals(data[3])) {
                                    // -- creazione messaggio per avvertire l'utente che la password non e' corretta
                                    modifyPanel.emptyMsg();
                                    GUI.setContent(3, new Dimension(800, 550));
                                    modifyPanel.warningMsg(2, "Attenzione la password non \u00E9 corretta");
                                }
                            } else {
                                GUI.setContent(3, new Dimension(800, 550));
                                modifyPanel.warningMsg(2, "Attenzione lo username inserito \u00E9 gi\u00E1 preso!");
                                modifyPanel.emptyMsg();
                                optionPaneMod.emptyFields();
                            }
                        }
                        case 1 -> {
                            // -- nel caso avesse cliccato cancel pulisco i campi
                            modifyPanel.emptyMsg();
                            modifyPanel.emptyFields();
                            optionPaneMod.emptyFields();
                        }
                        case 2 -> {
                            // -- nel caso avesse cliccato no pulisco i campi
                            modifyPanel.emptyMsg();
                            modifyPanel.emptyFields();
                            optionPaneMod.emptyFields();
                        }
                        default -> {
                            // -- in caso di errori non monitorati
                            modifyPanel.emptyFields();
                            modifyPanel.errorMsg(3, "Errore modifica");
                        }
                    }
                } catch (Exception ev) {
                    ev.printStackTrace();
                }
            } else if (old_username.equals("")) {
                modifyPanel.emptyMsg();
                GUI.setContent(3, new Dimension(800, 550));
                modifyPanel.warningMsg(0, "Attenzione inserire lo username!");
            } else if (old_password.equals("")) {
                modifyPanel.emptyMsg();
                GUI.setContent(3, new Dimension(800, 550));
                modifyPanel.warningMsg(1, "Attenzione inserire la password!");
            } else if (old_password.length() <= 4) {
                modifyPanel.emptyMsg();
                GUI.setContent(3, new Dimension(1100, 550));
                modifyPanel.warningMsg(1, "Attenzione inserire una password che abbia pi\u00F9 di 4 caratteri");
            }
        }

        // ############################## BOTTONE INDIETRO ##############################
        if (e.getSource() == modifyPanel.getBtnBack()) {
            // -- reindirizzo alla pagina di gioco
            GUI.setContent(2, new Dimension(1000, 650));
            modifyPanel.emptyFields();
            modifyPanel.emptyMsg();
        }
    }
}
