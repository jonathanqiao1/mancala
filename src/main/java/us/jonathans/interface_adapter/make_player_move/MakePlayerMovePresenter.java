package us.jonathans.interface_adapter.make_player_move;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputBoundary;
import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputData;

public class MakePlayerMovePresenter implements MakePlayerMoveOutputBoundary {
    private final MakePlayerMoveViewModel makePlayerMoveViewModel;

    public MakePlayerMovePresenter(MakePlayerMoveViewModel makePlayerMoveViewModel) {
        this.makePlayerMoveViewModel = makePlayerMoveViewModel;
    }
    @Override
    public void presentUpdatedBoard(MakePlayerMoveOutputData outputData) {
        makePlayerMoveViewModel.setState(
                new MakePlayerMoveState(outputData)
        );
        makePlayerMoveViewModel.firePropertyChanged();
    }
}
