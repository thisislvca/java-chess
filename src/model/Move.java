package model;

import model.pieces.Piece;

/**
 * @param Mossa
 */
public class Move {
    private Spot start; // spot mossa iniziale
    private Spot end;   // spot mossa finale
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove = false;

    /**
     * @param costruttore mossa
     * @param start
     * @param end
     */
    public Move(Spot start, Spot end) {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    /**
     * @param metodo per vedere se sta facendo l'arrocco
     * @return
     */
    public boolean isCastlingMove() {
        return this.castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Spot getStart() {
        return start;
    }

    public void setStart(Spot start) {
        this.start = start;
    }

    public Spot getEnd() {
        return end;
    }

    public void setEnd(Spot end) {
        this.end = end;
    }

    public void setPieceKilled(Piece destPiece) {
        destPiece.setKilled(true);
    }
}

