package model.player;

/**
 * @param Classe astratta player per suddividere tra umano e computer
 */

public abstract class Player {
    public boolean whiteSide;
    public boolean humanPlayer;

    public boolean isWhiteSide()
    {
        return this.whiteSide;
    }
    public boolean isHumanPlayer()
    {
        return this.humanPlayer;
    }
}

