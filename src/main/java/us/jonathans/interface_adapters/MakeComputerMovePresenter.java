package us.jonathans.interface_adapters;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MancalaHole;
import us.jonathans.use_case.makeComputerMove.MakeComputerMoveOutputBoundary;
import us.jonathans.view.MakeComputerMoveView;

public class MakeComputerMovePresenter implements MakeComputerMoveOutputBoundary {
    private MakeComputerMoveViewModel viewModel;

    /**
     * Initializes the presenter with the view model.
     *
     * @param viewModel The view model that maintains the board state.
     */
    public MakeComputerMovePresenter(MakeComputerMoveViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Updates the board state in the view model after a move.
     *
     * @param board The Mancala board containing the current state.
     */
    public void displayUpdatedBoard(MancalaBoard board) {
        int[] updatedBoard = new int[14];

        // Loop through the Mancala holes to populate the board state.
        for (MancalaHole hole : MancalaHole.values()) {
            updatedBoard[hole.ordinal()] = board.getStones(hole);
        }

        // Update the view model, which triggers UI updates.
        viewModel.setBoard(updatedBoard);
    }

}
