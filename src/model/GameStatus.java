package model;

/**
 * @param Status della partita
 */
public enum GameStatus {
    ACTIVE,     // game status attivo
    BLACK_WIN,  // game status vittoria neri
    WHITE_WIN,  // game status vittoria bianchi
    FORFEIT,    // partita finita per aver sforato il tempo
    STALEMATE,  // situazione di stallo o patta
    RESIGNATION // uno dei due giocatori si è arreso
}