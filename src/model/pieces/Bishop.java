package model.pieces;

import model.Board;
import model.Spot;

/**
 * @param Alfiere
 */
public class Bishop extends Piece {
    /**
     * @param costruttore alfiere
     * @param white
     */
    public Bishop(boolean white) {
        super(white);
    }

    /**
     * @param metodo per vedere se l'alfiere può muoversi
     * @param board
     * @param start
     * @param end
     * @return
     */
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }

        float diffSum = 0;
        float diff1 = 0;
        float diff2 = 0;
        int diffToBorderY = 0;
        int diffToBorderX = 0;

        if (start.getY() == end.getY()) {       // tolgo orizzontale
            // non si sta muovendo in diagonale
            return false;
        }

        if (start.getX() == end.getX()) {       // tolgo verticale
            // non si sta muovendo in diagonale
            return false;
        }

        diff1 = (start.getY() - end.getY());
        diff2 = (start.getX() - end.getX());

        diffSum = (diff1 / diff2);
        if (diffSum < 0) diffSum *= -1;
        if (diffSum == 1) {   // tolgo non diagonali

            if (start.getY() < end.getY()) {        // bottom half
                if (start.getX() < end.getX()) {    // right side of the bottom half

                    diffToBorderY = end.getY() - start.getY();
                    diffToBorderX = end.getX() - start.getX();

                    /*System.out.println("\nRight Side Bottom Half");
                    System.out.println("Start Y " + start.getY() + "     Start X " + start.getX());
                    System.out.println("Diff Y " + diffToBorderY + "     Diff X " + diffToBorderX + "\n");*/

                    for (int i = 1; i < diffToBorderX; i++) {
                        if (board.getBox(start.getX() + i, start.getY() + i).getPiece() != null) {
                            return false;
                        }
                    }
                    return true;

                } else {                             // left side of the bottom half
                    // delta y positivo, delta x negativo -> y va da 8 a start.y, x va da 0 a start.x
                    diffToBorderY = end.getY() - start.getY();
                    diffToBorderX = start.getX() - end.getX();

                    for (int i = 1; i < diffToBorderX; i++) {
                        if (board.getBox(start.getX() - i, start.getY() + i).getPiece() != null) {
                            return false;
                        }
                    }
                    return true;
                }


            } else { // top half
                if (start.getX() < end.getX()) { // right side of the top half

                    diffToBorderY = start.getY() - end.getY();
                    diffToBorderX = end.getX() - start.getX();

                    for (int i = 1; i < diffToBorderX; i++) {
                        if (board.getBox(start.getX() + i, start.getY() - i).getPiece() != null) {
                            return false;
                        }
                    }
                    return true;

                } else { // left side of the top half

                    diffToBorderY = start.getY() - end.getY();
                    diffToBorderX = start.getX() - end.getX();

                    System.out.println("\nLeft Side Top Half");
                    System.out.println("Start Y " + start.getY() + "     Start X " + start.getX());
                    System.out.println("Diff Y " + diffToBorderY + "     Diff X " + diffToBorderX + "\n");

                    for (int i = 1; i < diffToBorderX; i++) {
                        if (board.getBox(start.getX() - i, start.getY() - i).getPiece() != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }

        return false;

    }
}
