package model;

import javax.swing.*;

public class ThreadTimer extends Thread {

    private int     timeSetUp;
    private String  timer;
    private JLabel  lblTimer;
    private Turn    turn;
    private int     _id;
    private boolean hasTimerStopped;

    /**
     * @param ThreadTimer costruttore del thread per il timer
     * @param timeSetUp
     * @param lblTimer
     * @param turn
     * @param id
     */
    public ThreadTimer(int timeSetUp, JLabel lblTimer, Turn turn, int id) {
        // -- timeSetUp sono i minuti che vengono passati nel momento della creazione dell'istanza, che dopo converto in secondi
        this.timeSetUp = timeSetUp * 60;
        // -- timer e' una stringa di default che mette sul display 0:0
        timer = timeSetUp + ":" + 0;
        lblTimer.setText(timer);
        // -- lblTimer che viene modificata ad ogni ciclo
        this.lblTimer = lblTimer;
        this.turn = turn;
        this._id = id;
        hasTimerStopped = false;
    }

    /**
     * @param run metodo per l'esecuzione del threadTimer
     */
    public void run() {
        while (true) {
            if (turn.turn == _id && timeSetUp >= 0) {
                // -- riconverto timeSetUp in minuti
                int minutes = timeSetUp / 60;
                // -- mi prendo il valore dei secondi facendo il modulo di timeSetUp, ovvero se timeSetUp = 180 i secondi saranno 180 % 60 = 0, un altro esempio se timeSetUp = 173 i secondi saranno 173 % 60 = 53
                int seconds = timeSetUp % 60;
                // -- cambio il valore della lbl ogni ciclo con il timer aggiornato
                if (seconds > 9)
                    lblTimer.setText(minutes + ":" + seconds);
                else
                    lblTimer.setText(minutes + ":0" + seconds);
//                System.out.println(minutes + ":" + seconds);
                // -- diminuisco il timeSetUp per diminuire i secondi
                timeSetUp = timeSetUp - 1;
            }
            if (timeSetUp < 0) {
                hasTimerStopped = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean getHasTimerStopped() {
        return hasTimerStopped;
    }

}
