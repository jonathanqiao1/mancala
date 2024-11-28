package us.jonathans.interface_adapters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MakeComputerMoveViewModel {
    private int[] board; // Represents the stones in each hole on the board
    private final PropertyChangeSupport pcs;

    public MakeComputerMoveViewModel() {
        this.board = new int[14]; // Initialize board with default size
        this.pcs = new PropertyChangeSupport(this);
    }

    /**
     * Sets the state of the board and notifies listeners.
     *
     * @param newBoard The updated board state.
     */
    public void setBoard(int[] newBoard) {
        int[] oldBoard = this.board.clone();
        this.board = newBoard.clone(); // Deep copy to avoid modification issues
        pcs.firePropertyChange("board", oldBoard, this.board); // Notify listeners
    }

    /**
     * Gets the current state of the board.
     *
     * @return The current board state.
     */
    public int[] get_board() {
        return this.board.clone(); // Return a copy to preserve encapsulation
    }

    /**
     * Adds a property change listener to observe board changes.
     *
     * @param listener The listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Removes a property change listener.
     *
     * @param listener The listener to remove.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
