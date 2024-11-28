package us.jonathans.use_case.make_player_move;

import us.jonathans.entity.rule.*;

public class MakePlayerMoveInputData {

    private final MancalaMove move;

    public MakePlayerMoveInputData(MancalaMove move) {
        this.move = move;
    }

    MancalaSide getMancalaSide() {
        return this.move.side();
    }

    MancalaHole getMancalaHole() {
        return this.move.hole();
    }
}
