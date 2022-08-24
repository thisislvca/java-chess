package model;

import model.pieces.*;

/**
 * @param Scacchiera
 */
public class Board {
    Spot[][] boxes = new Spot[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
        this.resetBoard();
    }   // il costruttore resetta la scacchiera

    /**
     * @param Getter della scacchiera
     * @param x
     * @param y
     * @return boxes[x][y]
     */
    public Spot getBox(int x, int y) {
        return boxes[x][y];
    }

    /**
     * @param metodo per resettare la scacchiera
     */
    public void resetBoard() {

        // inizializzo pezzi neri
        boxes[0][0] = new Spot(0, 0, new Rook(false));
        boxes[1][0] = new Spot(1, 0, new Knight(false));
        boxes[2][0] = new Spot(2, 0, new Bishop(false));
        boxes[3][0] = new Spot(3, 0, new Queen(false));
        boxes[4][0] = new Spot(4, 0, new King(false));
        boxes[5][0] = new Spot(5, 0, new Bishop(false));
        boxes[6][0] = new Spot(6, 0, new Knight(false));
        boxes[7][0] = new Spot(7, 0, new Rook(false));

        boxes[0][1] = new Spot(0, 1, new Pawn(false));
        boxes[1][1] = new Spot(1, 1, new Pawn(false));
        boxes[2][1] = new Spot(2, 1, new Pawn(false));
        boxes[3][1] = new Spot(3, 1, new Pawn(false));
        boxes[4][1] = new Spot(4, 1, new Pawn(false));
        boxes[5][1] = new Spot(5, 1, new Pawn(false));
        boxes[6][1] = new Spot(6, 1, new Pawn(false));
        boxes[7][1] = new Spot(7, 1, new Pawn(false));

        // inizializzo pezzi bianchi

        boxes[0][7] = new Spot(0, 7, new Rook(true));
        boxes[1][7] = new Spot(1, 7, new Knight(true));
        boxes[2][7] = new Spot(2, 7, new Bishop(true));
        boxes[3][7] = new Spot(3, 7, new Queen(true));
        boxes[4][7] = new Spot(4, 7, new King(true));
        boxes[5][7] = new Spot(5, 7, new Bishop(true));
        boxes[6][7] = new Spot(6, 7, new Knight(true));
        boxes[7][7] = new Spot(7, 7, new Rook(true));

        boxes[0][6] = new Spot(0, 6, new Pawn(true));
        boxes[1][6] = new Spot(1, 6, new Pawn(true));
        boxes[2][6] = new Spot(2, 6, new Pawn(true));
        boxes[3][6] = new Spot(3, 6, new Pawn(true));
        boxes[4][6] = new Spot(4, 6, new Pawn(true));
        boxes[5][6] = new Spot(5, 6, new Pawn(true));
        boxes[6][6] = new Spot(6, 6, new Pawn(true));
        boxes[7][6] = new Spot(7, 6, new Pawn(true));

        // inizializzo gli spot dove non ci sono pezzi

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[j][i] = new Spot(j, i, null);
            }
        }
    }
}
