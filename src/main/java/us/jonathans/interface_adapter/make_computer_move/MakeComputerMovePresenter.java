package us.jonathans.interface_adapter.make_computer_move;

import us.jonathans.use_case.make_computer_move.MakeComputerMoveOutputBoundary;
import us.jonathans.use_case.make_computer_move.MakeComputerMoveOutputData;

public class MakeComputerMovePresenter implements MakeComputerMoveOutputBoundary {
    private final MakeComputerMoveViewModel viewModel;

    /**
     * Initializes the presenter with the view model.
     *
     * @param viewModel The view model that maintains the board state.
     */
    public MakeComputerMovePresenter(MakeComputerMoveViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(MakeComputerMoveOutputData makeComputerMoveOutputData) {
        MakeComputerMoveState makeComputerMoveState = new MakeComputerMoveState(
                makeComputerMoveOutputData.board()
        );
        viewModel.setState(makeComputerMoveState);
        viewModel.firePropertyChanged();
    }
}
