package us.jonathans.interface_adapters;

import us.jonathans.mancala.MancalaBoard;
import us.jonathans.mancala.MancalaHole;
import us.jonathans.mancala.MancalaSide;
import us.jonathans.use_case.makeComputerMove.MakeComputerMoveOutputBoundary;
import us.jonathans.view.MakeComputerMoveView;

public class MakeComputerMovePresenter implements MakeComputerMoveOutputBoundary {
    private final MakeComputerMoveView view;

    // Constructor
    public MakeComputerMovePresenter(MakeComputerMoveView view) {
        this.view = view;
    }

    @Override
    public void presentUpdatedBoard(MancalaBoard board) {
        // Convert board data to a view model
        MakeComputerMoveViewModel viewModel = createBoardViewModel(board);

        // Pass the view model to the view
        view.displayUpdatedBoard(viewModel);
    }

    // Helper method to create a view model from the MancalaBoard
    private MakeComputerMoveViewModel createBoardViewModel(MancalaBoard board) {
        MakeComputerMoveViewModel viewModel = new MakeComputerMoveViewModel();

        for (MancalaHole hole : MancalaHole.values()) {
            int stones = board.getStones(hole);
            viewModel.setHoleState(hole.ordinal(), stones);
        }

        return viewModel;
    }
}
