package control;

import model.UsernamesManagement;
import view.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @param Classe per la gestione degli eventi della registrazione
 */
public class ControllerSignUp implements ActionListener {

    /**
     * @param attributi
     */
    private final GUI GUI;
    private final RegisterPanel registerPanel;
    private final UsernamesManagement usernamesManagement;

    /**
     * @param costruttore
     */
    public ControllerSignUp(GUI GUI, RegisterPanel registerPanel, UsernamesManagement usernamesManagement) {
        this.GUI = GUI;
        this.registerPanel = registerPanel;
        this.usernamesManagement = usernamesManagement;
        registerPanel.listener(this);
    }

    /**
     *
     * @param e the event to be processed
     * @param metodo per gli eventi della classe
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // ############################## BOTTONE REGISTRATI ##############################
        if (e.getSource() == registerPanel.getBtnRegistrazione()) {
            // --- creazione attributi temporanei contenenti il testo presente nei vari txtFields e passwordField
            String cognome = registerPanel.getTxtFCognomeSignUp().getText();
            String nome = registerPanel.getTxtFNomeSignUp().getText();
            String username = registerPanel.getTxtFUsernameSignUp().getText();
            String password = String.valueOf(registerPanel.getPassFRegisterSignUp().getPassword());

            // --- controllo che i campi non siano vuoti + la password sia >= 5 caratteri
            if (!cognome.equals("") && !nome.equals("") && !username.equals("") && !password.equals("") && password.length() > 4) {
                // -- creazione di un file di controllo
                FileWriter fileWriter;
                try {
                    String check_file = "";
                    try {
                        // - istanzio file di controllo aprendo il file con lo username dato nei campi
                        check_file = new Scanner(new File(username + ".txt")).next();
                    } catch (FileNotFoundException ex) {

                    }
                    // --- controllo se il file di controllo non contiene nulla vuol dire che possiamo creare un profilo con quel username, per evitare doppioni
                    if (check_file.equals("")) {
                        // -- creo un file txt con lo username dell'utente da registrare
                        fileWriter = new FileWriter(username + ".txt");
                        // -- se il file esiste posso scriverci dentro
                        try (BufferedWriter bufferedwriter = new BufferedWriter(fileWriter)) {
                            // - scrivo sul file nome, cognome, username e password
                            bufferedwriter.write(cognome + "\n");
                            bufferedwriter.write(nome + "\n");
                            bufferedwriter.write(username + "\n");
                            bufferedwriter.write(password + "\n");
                            bufferedwriter.write(0 + "\n"); // - win
                            bufferedwriter.write(0 + "\n"); // - loss
                            bufferedwriter.write(0 + "\n"); // - win/loss
                            bufferedwriter.write(0 + "\n"); // - rank
                            bufferedwriter.write("//\n");
                            // - chiamo il metodo per aggiungere lo username del nuovo profilo creato al "database"
                            usernamesManagement.add(username);
                            // - chiudo il file e finisco di scrivere
                            bufferedwriter.close();
                            registerPanel.emptyFields();
                            registerPanel.emptyMsg();
                            GUI.setContent(1, new Dimension(800, 500));
                        }
                    } else {
                        // -- messaggio di profilo gia' esistente
                        registerPanel.emptyMsg();
                        GUI.setContent(0, new Dimension(900, 650));
                        registerPanel.errorMsg(4, "Attenzione profilo gi\u00E1 esistente");
                        registerPanel.emptyFields();
                    }
                } catch (Exception ev) {
                    ev.printStackTrace();
                }
            } else if (cognome.equals("")) {
                // -- messaggio di mancanza inserimento del cognome
                registerPanel.emptyMsg();
                GUI.setContent(0, new Dimension(1000, 650));
                registerPanel.warningMsg(0, "Attenzione inserire il cognome!");
            } else if (nome.equals("")) {
                // -- messaggio di mancanza inserimento del nome
                registerPanel.emptyMsg();
                GUI.setContent(0, new Dimension(1000, 650));
                registerPanel.warningMsg(1, "Attenzione inserire il nome!");
            } else if (username.equals("")) {
                // --- messaggio di mancanza inserimento dello username
                registerPanel.emptyMsg();
                GUI.setContent(0, new Dimension(1000, 650));
                registerPanel.warningMsg(2, "Attenzione inserire lo username!");
            } else if (password.equals("")) {
                // --- messaggio di mancanza inserimento della password
                registerPanel.emptyMsg();
                GUI.setContent(0, new Dimension(1000, 650));
                registerPanel.warningMsg(3, "Attenzione inserire la password!");
            } else if (password.length() <= 4) {
                // --- messaggio di password troppo corta
                registerPanel.emptyMsg();
                GUI.setContent(0, new Dimension(1200, 650));
                registerPanel.warningMsg(3, "Attenzione inserire una password che abbia pi\u00F9 di 4 caratteri");
            }
        }

        // ############################## BOTTONE ACCEDI ##############################
        if (e.getSource() == registerPanel.getBtnLogIn()) {
            // -- reindirizzo al pannello di login
            GUI.setContent(1, new Dimension(800, 500));
            registerPanel.emptyFields();
            registerPanel.emptyMsg();
        }
    }
}
