package control;

import model.UsernamesManagement;
import view.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @param Classe per la gestione degli eventi del login
 */
public class ControllerLogIn implements ActionListener {

    // --- attributi
    private final GUI GUI;
    private final LogInPanel logInPanel;
    private final UsernamesManagement usernamesManagement;

    /**
     * @param costruttore
     * @param GUI
     * @param logInPanel
     * @param usernamesManagement
     */
    public ControllerLogIn(GUI GUI, LogInPanel logInPanel, UsernamesManagement usernamesManagement) {
        this.GUI = GUI;
        this.logInPanel = logInPanel;
        this.usernamesManagement = usernamesManagement;
        logInPanel.listener(this);
    }

    /**
     * @param metodo per gli eventi
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // ############################## BOTTONE ACCEDI ##############################
        if (e.getSource() == logInPanel.getBtnLogIn()) {

            // -- creazione attributi temporanei per il login
            String username = logInPanel.getTxtFUsernameLogIn().getText();
            String password = String.valueOf(logInPanel.getPassFLogIn().getPassword());

            // --- controllo che i campi non siano vuoti + che il campo password abbia una password con il numero di carattere che siano >= 5
            if (!username.equals("") && !password.equals("") && password.length() > 4) {
                try {
                    // -- creazione di un bufferedReader che legge il testo da una stream di input di caratteri, memorizzando i caratteri nel buffer in modo da fornire una lettura efficiente di caratteri, array e files
                    Scanner read = new Scanner(new BufferedReader(new FileReader(username + ".txt")));
                    // -- creo un array di tipo stringa per immagazzinare le info del file
                    String[] data = new String[25];

                    // -- attributi per il ciclo seguente
                    int i = 0;
                    boolean check = false;

                    do {
                        // -- affinche' il file ha una string successiva continua il ciclo
                        while (read.hasNext()) {
                            // -- useDelimiter permette di impostare un "flag" nella lettura del file, ovvero il bufferedReader appena trova i due caratteri // ferma la lettura del file
                            read.useDelimiter("//");
                            // -- dal momento che le informazioni nel file sono scritte riga \n riga \n ecc..., ogni volta che il reader incontra '\n' splitta la stringa
                            data[i] = Arrays.toString(read.nextLine().split("\n"));
                            // -- piccolo controllo nel caso lo useDelimiter andasse in errore
                            if (data[i].equals("")) {
                                check = true;
                                break;
                            }
                            i++;
                        }
                    } while (check);
                    read.close();

                    // --- controllo che lo username preso dal pannello sia lo stesso del file + la password
                    if (Arrays.toString(new String[]{username}).equals(data[2]) && Arrays.toString(new String[]{password}).equals(data[3])) {
                        // -- imposto il player1 come lo username loggato
                        usernamesManagement.setP1(username);
                        // -- reindirizzo al pannello di gioco
                        GUI.setContent(2, new Dimension(950, 750));
                        logInPanel.emptyFields();
                        logInPanel.emptyMsg();
                    } else if (!Arrays.toString(new String[]{username}).equals(data[2])) {
                        // -- creazione messaggio per avvertire l'utente che nessun profilo ha uno username uguale a quello messo in input
                        logInPanel.emptyMsg();
                        GUI.setContent(1, new Dimension(1000, 550));
                        logInPanel.errorMsg(2, "Attenzione non esiste alcun profilo con lo username: " + username);
                    } else if (!Arrays.toString(new String[]{password}).equals(data[3])) {
                        // -- creazione messaggio per avvertire l'utente che la password non e' corretta
                        logInPanel.emptyMsg();
                        GUI.setContent(1, new Dimension(1000, 550));
                        logInPanel.errorMsg(1, "Attenzione inserire la password corretta!");
                    }
                } catch (Exception ev) {
                    ev.printStackTrace();
                    // -- creazione messaggio per avvertire l'utente che nessun profilo ha uno username uguale a quello messo in input
                    logInPanel.emptyMsg();
                    GUI.setContent(1, new Dimension(800, 500));
                    logInPanel.errorMsg(2, "Attenzione non esiste alcun profilo con lo username: " + username);
                    logInPanel.emptyFields();
                }
            } else if (username.equals("")) {
                // -- creazione messaggio per avvertire l'utente che deve inserire uno username
                logInPanel.emptyMsg();
                GUI.setContent(1, new Dimension(1000, 550));
                logInPanel.warningMsg(0, "Attenzione inserire lo username!");
            } else if (password.equals("")) {
                // -- creazione messaggio per avvertire l'utente che deve inserire una password
                logInPanel.emptyMsg();
                GUI.setContent(1, new Dimension(1000, 550));
                logInPanel.warningMsg(1, "Attenzione inserire la password!");
            } else if (password.length() <= 4) {
                // -- creazione messaggio per avvertire l'utente che deve inserire una password con piu' di 4 caratteri
                logInPanel.emptyMsg();
                GUI.setContent(1, new Dimension(1100, 550));
                logInPanel.warningMsg(1, "Attenzione inserire una password che abbia pi\u00F9 di 4 caratteri");
            }
        }

        // ############################## BOTTONE REGISTRATI ##############################
        if (e.getSource() == logInPanel.getBtnRegister()) {
            // -- reindirizzo al pannello di registrazione
            GUI.setContent(0, new Dimension(800, 650));
            logInPanel.emptyFields();
            logInPanel.emptyMsg();
        }
    }
}
