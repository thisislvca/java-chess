package model.pieces;

import model.Board;
import model.Spot;

/**
 * @param Queen
 */
public class Queen extends Piece {
    /**
     * @param costruttore regina
     * @param white
     */
    public Queen(boolean white) {
        super(white);
    }

    /**
     * @param metodo per vedere se la regina si può muovere
     * @param board
     * @param start
     * @param end
     * @return true o false in base al caso
     */
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // le mosse di una regina sono le stesse di un alfiere + una torre
        if(new Rook(this.isWhite()).canMove(board, start, end)){
            return true;
        }
        if(new Bishop(this.isWhite()).canMove(board, start, end)){
            return true;
        }
        return false;
    }
}
