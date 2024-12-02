package us.jonathans.interface_adapter.make_player_move;

import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputData;

public class MakePlayerMoveState {

    private int[] board;
    private Boolean success;

    public MakePlayerMoveState(MakePlayerMoveOutputData outputData) {
        this.board = outputData.board().asArray();
        this.success = outputData.success();
    }

    public int[] getBoard() {
        return board;
    }

    public Boolean getSuccess() {
        return success;
    }
}
