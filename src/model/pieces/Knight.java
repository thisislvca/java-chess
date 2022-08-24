package model.pieces;

import model.Board;
import model.Spot;

/**
 * @param Cavaliere
 */
public class Knight extends Piece {
    /**
     * @param costruttore cavaliere
     * @param white
     */
    public Knight(boolean white) {
        super(white);
    }

    /**
     * @param metodo per vedere se il cavaliere si può muovere
     * @param board
     * @param start
     * @param end
     * @return false se non si può muovere
     */
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if(end.getPiece() != null){
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2;      // cavallo si muove solo su pezzi a 2 di distanza
    }

}

