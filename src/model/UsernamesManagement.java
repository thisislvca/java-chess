package model;

import java.io.*;
import java.util.*;

/**
 * @param Classe per amministrare l'username
 */
public class UsernamesManagement {

    private String p1, p2;

    /**
     * @param costruttore della classe
     */
    public UsernamesManagement() {
        p1 = "";
        p2 = "";
    }

    /**
     * @param metodo per aggiungere l'username
     */
    public void add(String username) {

        FileWriter fileWriter;

        try {
            boolean check_file = false;
            try {
                check_file = new Scanner(new File("UsernamesManagement.txt")).hasNext();
            } catch (FileNotFoundException e) {

            }

            if (!check_file) {
                fileWriter = new FileWriter("UsernamesManagement.txt");
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(username + "\n");
                    bufferedWriter.close();
                    System.out.println("UsernamesManagement Chiuso");
                }
            } else {
                Scanner read = new Scanner(new BufferedReader(new FileReader("UsernamesManagement.txt")));
                String[] data = new String[64];

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

                fileWriter = new FileWriter("NewUsernamesManagement.txt");

                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    File old_file = new File("UsernamesManagement.txt");
                    old_file.delete();

                    for (i = 0; i < data.length; i++) {
                        if (data[i] != null)
                            bufferedWriter.write(data[i] + "\n");
                    }
                    bufferedWriter.write(username + "\n");
                    bufferedWriter.close();
                    System.out.println("NewUsernamesManagement chiuso");
                }

                File new_file = new File("NewUsernamesManagement.txt");
                new_file.renameTo(new File("UsernamesManagement.txt"));
                System.out.println("NewUsernamesManagement.txt -> UsernamesManagement.txt");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param metodo per modificare l'username
     */
    public void modify(String old_username, String new_username) {

        FileWriter fileWriter;

        try {
            boolean check_file = false;
            try {
                check_file = new Scanner(new File("UsernamesManagement.txt")).hasNext();
            } catch (FileNotFoundException e) {

            }

            if (check_file) {
                Scanner read = new Scanner(new BufferedReader(new FileReader("UsernamesManagement.txt")));
                String[] data = new String[64];

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

                fileWriter = new FileWriter("NewUsernamesManagement.txt");

                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    File old_file = new File("UsernamesManagement.txt");
                    old_file.delete();

                    for (i = 0; i < data.length; i++) {
                        if (data[i] != null)
                            if (data[i].equals(old_username))
                                bufferedWriter.write(new_username + "\n");
                            else
                                bufferedWriter.write(data[i] + "\n");
                    }
                    bufferedWriter.close();
                    System.out.println("NewUsernamesManagement chiuso");
                }

                File new_file = new File("NewUsernamesManagement.txt");
                new_file.renameTo(new File("UsernamesManagement.txt"));
                System.out.println("NewUsernamesManagement.txt -> UsernamesManagement.txt");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void aggiungiVittoria(String username) {
        FileWriter fileWriter;

        try {
            boolean check_file = false;
            try {
                check_file = new Scanner(new File(username + ".txt")).hasNext();
            } catch (FileNotFoundException e) {

            }

            if (check_file) {
                Scanner read = new Scanner(new BufferedReader(new FileReader(username + ".txt")));
                String[] data = new String[64];

                int i = 0;
                boolean check = false;
                do {
                    while (read.hasNext()) {
                        read.useDelimiter("//");
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

                fileWriter = new FileWriter("New" + username + ".txt");

                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    File old_file = new File(username + ".txt");
                    old_file.delete();

                    bufferedWriter.write(data[0] + "\n"); // cognome
                    bufferedWriter.write(data[1] + "\n"); // nome
                    bufferedWriter.write(data[2] + "\n"); // username
                    bufferedWriter.write(data[3] + "\n"); // password
                    int win1 = Integer.parseInt(data[4]);
                    win1 = win1 + 1;
                    data[4] = String.valueOf(win1);
                    bufferedWriter.write(data[4] + "\n"); // win
                    bufferedWriter.write(data[5] + "\n"); // loss
                    int win = Integer.parseInt(data[4]);
                    int loss = Integer.parseInt(data[5]);
                    double win_loss = 0;
                    if (loss != 0) {
                        win_loss = Math.floor(win / loss);
                    }
                    data[6] = String.valueOf(win_loss);
                    bufferedWriter.write(data[6] + "\n"); // win/loss
                    bufferedWriter.write(data[7] + "\n"); // rank
                    bufferedWriter.write("//\n");
                    bufferedWriter.close();
                    System.out.println("New" + username + " chiuso");
                }

                File new_file = new File("New" + username + ".txt");
                new_file.renameTo(new File(username + ".txt"));
                System.out.println("New" + username + ".txt -> " + username + ".txt");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void aggiungiPerdita(String username) {
        FileWriter fileWriter;

        try {
            boolean check_file = false;
            try {
                check_file = new Scanner(new File(username + ".txt")).hasNext();
            } catch (FileNotFoundException e) {

            }

            if (check_file) {
                Scanner read = new Scanner(new BufferedReader(new FileReader(username + ".txt")));
                String[] data = new String[64];

                int i = 0;
                boolean check = false;
                do {
                    while (read.hasNext()) {
                        read.useDelimiter("//");
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

                fileWriter = new FileWriter("New" + username + ".txt");

                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    File old_file = new File(username + ".txt");
                    old_file.delete();

                    bufferedWriter.write(data[0] + "\n"); // cognome
                    bufferedWriter.write(data[1] + "\n"); // nome
                    bufferedWriter.write(data[2] + "\n"); // username
                    bufferedWriter.write(data[3] + "\n"); // password
                    bufferedWriter.write(data[4] + "\n"); // win
                    int loss1 = Integer.parseInt(data[5]);
                    loss1 = loss1 + 1;
                    data[5] = String.valueOf(loss1);
                    bufferedWriter.write(data[5] + "\n"); // loss
                    int win = Integer.parseInt(data[4]);
                    int loss = Integer.parseInt(data[5]);
                    double win_loss = 0;
                    if (loss != 0) {
                        win_loss = Math.floor(win / loss);
                    }
                    data[6] = String.valueOf(win_loss);
                    bufferedWriter.write(data[6] + "\n"); // win/loss
                    bufferedWriter.write(data[7] + "\n"); // rank
                    bufferedWriter.write("//\n");
                    bufferedWriter.close();
                    System.out.println("New" + username + " chiuso");
                }

                File new_file = new File("New" + username + ".txt");
                new_file.renameTo(new File(username + ".txt"));
                System.out.println("New" + username + ".txt -> " + username + ".txt");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP1(String username) {
        p1 = username;
    }

    public void setP2(String username) {
        p2 = username;
    }
}
