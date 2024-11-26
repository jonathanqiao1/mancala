package us.jonathans.entity;

/**
 * Represents a mancala game between two entities.
 */
public class MancalaGame {
    private String id;

    public MancalaGame(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
