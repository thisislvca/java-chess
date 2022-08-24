package model.pieces;

import model.Board;
import model.Spot;

/**
 * @param Torre
 */
public class Rook extends Piece {
    /**
     * @param costruttore torre
     * @param white
     */
    public Rook(boolean white) {
        super(white);
    }

    /**
     * @param metodo per vedere se la torre si può muovere
     * @param board
     * @param start
     * @param end
     * @return true o false in base al caso
     */
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }

        if (start.getX() == end.getX()) {
            if ((start.getY() < end.getY())) {  // torre va verso il basso
                for (int i = end.getY() - 1; i > start.getY(); i--) {
                    if (board.getBox(start.getX(), i).getPiece() != null) {
                        return false;
                    }
                }
                return true;
            } else {                              // torre va verso l'alto
                for (int i = start.getY() - 1; i > end.getY(); i--) { // ciclo da lontano a vicino
                    if (board.getBox(start.getX(), i).getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }
        }


        if (start.getY() == end.getY()) {
            if ((start.getX() < end.getX())) {          // torre va verso destra
                for (int i = end.getX() - 1; i > start.getX(); i--) {
                    if (board.getBox(i, start.getY()).getPiece() != null) {
                        return false;
                    }
                }
                return true;
            } else {                                      // torre va verso sinistra
                for (int i = start.getX() - 1; i > end.getX(); i--) {
                    if (board.getBox(i, start.getY()).getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }


}
