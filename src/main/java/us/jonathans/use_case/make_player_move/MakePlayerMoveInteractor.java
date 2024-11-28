package us.jonathans.use_case.make_player_move;

import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.data_access.user.UserDataAccessInterface;
import us.jonathans.use_case.start_game.StartGameOutputBoundary;

public class MakePlayerMoveInteractor implements MakePlayerMoveInputBoundary {

    private final MatchDataAccessInterface matchDataAccessObject;
    private final MakePlayerMoveOutputBoundary startGamePresenter;

    public MakePlayerMoveInteractor(MatchDataAccessInterface matchDataAccessObject, MakePlayerMoveOutputBoundary startGamePresenter) {

        this.matchDataAccessObject = matchDataAccessObject;
        this.startGamePresenter = startGamePresenter;
    }

    @Override
    public void execute(MakePlayerMoveInputData inputData) {

    }
}
