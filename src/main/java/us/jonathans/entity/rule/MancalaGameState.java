package us.jonathans.entity.rule;

import java.util.UUID;

/**
 * Represents a mancala game between two entities.
 */
public class MancalaGameState {
    private final UUID id;
    private final GameBoard gameBoard;


    public GameBoard getGameBoard() {
        return this.gameBoard;

    }

    public MancalaGameState() {
        this.id = UUID.randomUUID();
        this.gameBoard = new GameBoard();
    }

    public UUID getId() {
        return id;
    }
}
