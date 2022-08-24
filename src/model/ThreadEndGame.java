package model;

import java.util.Timer;

public class ThreadEndGame extends Thread {

    private Turn  turn;
    private Timer timer;

    /**
     * @param ThreadEndGame costruttore thread
     * @param turn
     * @param timer
     */
    public ThreadEndGame(Turn turn, Timer timer) {
        this.turn = turn;
        this.timer = timer;

        this.start();
    }

    /**
     * @param run metodo esecuzione thread
     */
    public void run() {
        while (true) {
            if (turn.hasGameEnded) {
                timer.cancel();
                timer.purge();
                System.out.println("Timer terminato");
                break;
            }
        }
    }

}
