package us.jonathans.use_case.make_player_move;

import us.jonathans.entity.rule.MancalaBoard;

public interface MakePlayerMoveOutputBoundary {
    void presentUpdatedBoard(MancalaBoard board);
}
