package model.pieces;

import model.Board;
import model.Spot;

/**k
 * @param Pezzo
 */
public abstract class Piece {

    private boolean killed = false;
    private boolean white = false;

    /**
     * @param costruttore pezzo
     * @param white
     */
    public Piece(boolean white) {
        this.setWhite(white);
    }       // colore

    /**
     * @param metodo per vedere se il pezzo è bianco
     * @return white
     */
    public boolean isWhite() {
        return this.white;
    }             // getter colore

    /**
     * @param metodo per settare il colore a bianco
     * @param white
     */
    public void setWhite(boolean white) {
        this.white = white;
    }   // setter colore

    /**
     * @param metodo per vedere se il pezzo è stato ucciso
     * @return killed
     */
    public boolean isKilled() {
        return this.killed;
    }             // getter killed

    /**
     * @param metodo per settare che il pezzo è stato ucciso
     * @param killed
     */
    public void setKilled(boolean killed) {
        this.killed = killed;
    }   // setter killed

    /**
     * @param metodo astratto per vedere se il pezzo si può muovere
     * @param board
     * @param start
     * @param end
     * @return
     */
    public abstract boolean canMove(Board board, Spot start, Spot end);  // metodo astratto, ritorna se muovibile o no

}
