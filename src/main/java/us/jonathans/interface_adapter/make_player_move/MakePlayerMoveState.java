package us.jonathans.interface_adapter.make_player_move;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputData;

public class MakePlayerMoveState {

    private int[] board;

    public MakePlayerMoveState(MakePlayerMoveOutputData outputData) {
        this.board = outputData.board().asArray();
    }
}
