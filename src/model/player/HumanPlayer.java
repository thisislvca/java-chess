package model.player;

/**
 * @param Classe per il giocatore umano
 */
public class HumanPlayer extends Player implements Comparable<HumanPlayer> {

    private String username;
    private boolean whiteSide;

    /**
     * @param costrttore classe
     * @param whiteSide
     * @param username
     */
    public HumanPlayer(boolean whiteSide, String username) {
        this.whiteSide = whiteSide;         // bianco o nero
        this.humanPlayer = true;            // sono umano (se voglio)
    }

    /**
     * @param metodo per ritornare l'username del giocatore
     * @return username
     */
    public String getUsername() {
        return username;
    }

    @Override
    public int compareTo(HumanPlayer player) {
        if (this.username.compareTo(player.username) == 0) {
            return this.username.compareTo(player.username);
        }
        return -1;
    }
}
