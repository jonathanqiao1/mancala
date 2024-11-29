package us.jonathans.entity.rule;

import java.util.UUID;

/**
 * Represents a mancala game between two entities.
 */
public class MancalaGameState {
    private final UUID id;
    private final MancalaBoard gameBoard;


    public MancalaBoard getGameBoard() {
        return this.gameBoard;
    }

    public MancalaGameState() {
        this.id = UUID.randomUUID();
        this.gameBoard = new JonathanMancalaBoard(4);
    }

    public UUID getId() {
        return id;
    }
}
