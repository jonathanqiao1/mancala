package us.jonathans.interface_adapter.make_player_move;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MoveResult;
import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputData;

public class MakePlayerMoveState {

    private int[] board;
    private MoveResult moveResult;

    public MakePlayerMoveState(MakePlayerMoveOutputData outputData) {
        this.board = outputData.board().asArray();
        this.moveResult = outputData.result();
    }

    public int[] getBoard() {
        return board;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
