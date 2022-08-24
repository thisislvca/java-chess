package model.pieces;

import model.Board;
import model.Spot;

/**
 * @param Re
 */
public class King extends Piece {

    private boolean castlingDone = false;

    /**
     * @param costruttore re
     * @param white
     */
    public King(boolean white) {
        super(white);
    }

    // castling è l'inglese per arrocco (quando inverto re e torre).

    /**
     * @param metodo per vedere se sta facendo l'arrocco
     * @return
     */
    public boolean isCastlingDone() {
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    /**
     * @param metodo per vedere se il re può muoversi
     * @param board
     * @param start
     * @param end
     * @return
     */
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // don't need to do stuff about colliding with pieces since I only need to move it in a 1x1 area
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            if (wontGetKilled(board, start, end)) {
                return true;
            }
        }
        if (x == 1) {
            if (y == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param metodo per vedere se l'arrocco è valido
     * @param board
     * @param start
     * @param end
     * @return
     */
    public boolean isValidCastling(Board board, Spot start, Spot end) { // se posso fare l'arrocc

        if (!this.isCastlingDone()) {
            int colorKingInt;

            if (start.getPiece().isWhite()) {
                colorKingInt = 0;
            } else {
                colorKingInt = 7;
            }

            if (start.getPiece() instanceof King) {
                if (start.getX() == colorKingInt && start.getY() == 4) {

                    // controllo se ci sono pezzi tra torre e re

                    if (start.getY() < end.getY()) {
                        for (int i = start.getY(); i < end.getY(); i++) {
                            if (board.getBox(colorKingInt, i).getPiece() == null) {
                                // check sul rook
                                if (board.getBox(colorKingInt, (end.getY() + 1)).getPiece() instanceof Rook) {
                                    return true;
                                }
                            }
                        }

                    } else {
                        for (int i = end.getY(); i < start.getY(); i++) {
                            if (board.getBox(colorKingInt, i).getPiece() == null) {
                                // check sul rook
                                if (board.getBox(colorKingInt, (end.getY() - 1)).getPiece() instanceof Rook) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param metodo backup per controllo arrocco
     * @param start
     * @param end
     * @return
     */
    public boolean isCastlingMove(Spot start, Spot end) {
        if (end.getPiece() instanceof Rook) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param metodo per vedere se il re non può essere mangiato
     * @param board
     * @param start
     * @param end
     * @return false se può essere mangiato
     * @return true se non può essere mangiato
     */
    public boolean wontGetKilled(Board board, Spot start, Spot end) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBox(i, j).getPiece() != null) {
                    if (board.getBox(i, j).getPiece().isWhite() != this.isWhite()) {
                        if (board.getBox(i, j).getPiece().canMove(board, board.getBox(i, j), end)) {  // check avversario kill
                            return false; // ritorno false se può essere mangiato
                        }
                    }
                }
            }
        }
        return true;
    }   // funziona
}

