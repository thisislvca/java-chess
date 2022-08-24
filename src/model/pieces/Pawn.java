package model.pieces;

import model.Board;
import model.Spot;

/**
 * @param Pedina
 */
public class Pawn extends Piece {
    /**
     * @param costruttore pedina
     * @param white
     */
    public Pawn(boolean white) {
        super(white);
    }

    /**
     * @param metodo per vedere se la pedina può muoversi
     * @param board
     * @param start
     * @param end
     * @return false se è bianca, o a seconda del caso
     */
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {       // se è bianco
                return false;                                       // ritorna false
            }
            if (canEat(board, start, end)) {      // controllando l'eating laterale del pedone
                return true;
            }
        }
        if (this.isWhite()) {
            if (start.getY() == 6) {        // doppio passo se è la prima mossa
                if (end.getPiece() != null) {
                    return false;
                }
                if (start.getY() - end.getY() <= 2 && start.getY() - end.getY() > -1) {
                    if (start.getX() == end.getX()) {
                        if (board.getBox(start.getX(), (start.getY() - 1)).getPiece() != null) {        // check
                            return false;
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (start.getY() - end.getY() == 1) {       // se non è la prima mossa
                if (start.getX() == end.getX()) {
                    if (end.getPiece() != null) {
                        return false;
                    }
                    return true;
                }
            } else {
                return false;
            }
        } else {
            if (start.getY() == 1) {     // doppio passo se è la prima mossa
                if (end.getPiece() != null) {
                    return false;
                }
                if (end.getY() - start.getY() <= 2 && end.getY() - start.getY() > -1) {
                    if (start.getX() == end.getX()) {
                        if (board.getBox(start.getX(), (start.getY() + 1)).getPiece() != null) {        // check
                            return false;
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (end.getY() - start.getY() == 1) {       // se non è la prima mossa
                if (start.getX() == end.getX()) {
                    if (end.getPiece() != null) {
                        return false;
                    }
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * @param metodo per vedere se la pedina può mangiare
     * @param board
     * @param start
     * @param end
     * @return false a seconda del caso
     */
    public boolean canEat(Board board, Spot start, Spot end) {
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
            if (this.isWhite()) {     // se è bianco
                if (Math.abs(start.getY() - end.getY()) == 1) {
                    if (start.getX() != end.getX()) {
                        if (Math.abs(start.getX() - end.getX()) <= 1) {
                            if (start.getY() > end.getY()) {
                                return true;
                            }
                        }
                    }
                } else {
                    return false;
                }
            } else {      // è nero
                if (Math.abs(start.getY() - end.getY()) == 1) {
                    if (start.getX() != end.getX()) {
                        if (Math.abs(start.getX() - end.getX()) <= 1) {
                            if (start.getY() < end.getY()) {
                                return true;
                            }
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
