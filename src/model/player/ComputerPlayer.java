package model.player;

/**
 * @param Classe per identificare il computer
 */
public class ComputerPlayer extends Player {
    /**
     * @param costruttore classe
     * @param whiteSide
     */
    public ComputerPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;     // se sono bianco o no
        this.humanPlayer = false;       // computer player, quindi false
    }
}
