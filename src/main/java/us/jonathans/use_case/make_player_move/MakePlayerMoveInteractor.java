package us.jonathans.use_case.make_player_move;

import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.entity.rule.Game;
import us.jonathans.entity.rule.MoveResult;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMovePresenter;

public class MakePlayerMoveInteractor implements MakePlayerMoveInputBoundary {

    private final MatchDataAccessInterface matchDataAccessObject;
    private final MakePlayerMoveOutputBoundary makePlayerMovePresenter;

    public MakePlayerMoveInteractor(MatchDataAccessInterface matchDataAccessObject, MakePlayerMoveOutputBoundary makePlayerMovePresenter) {

        this.matchDataAccessObject = matchDataAccessObject;
        this.makePlayerMovePresenter = makePlayerMovePresenter;
    }

    @Override
    public void execute(MakePlayerMoveInputData inputData) {
        Game game = matchDataAccessObject.getCurrentMatch().getGame();
        Boolean result = game.makeMove(
                inputData.getMancalaHole()
        );
        makePlayerMovePresenter.presentUpdatedBoard(new MakePlayerMoveOutputData(
                game.getBoard(),
                result
        ));
    }
}
