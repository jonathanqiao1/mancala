package us.jonathans.interface_adapter.make_player_move;

import us.jonathans.entity.rule.MancalaHole;
import us.jonathans.entity.rule.MancalaMove;
import us.jonathans.entity.rule.MancalaSide;
import us.jonathans.use_case.make_player_move.MakePlayerMoveInputData;
import us.jonathans.use_case.make_player_move.MakePlayerMoveInteractor;

public class MakePlayerMoveController {
    private final MakePlayerMoveInteractor makePlayerMoveInteractor;

    public MakePlayerMoveController(MakePlayerMoveInteractor makePlayerMoveInteractor) {
        this.makePlayerMoveInteractor = makePlayerMoveInteractor;
    }

    public void execute(MancalaSide mancalaSide, MancalaHole mancalaHole) {

        MakePlayerMoveInputData inputData = new MakePlayerMoveInputData(new MancalaMove(mancalaSide, mancalaHole));
        makePlayerMoveInteractor.execute(inputData);
    }
}
