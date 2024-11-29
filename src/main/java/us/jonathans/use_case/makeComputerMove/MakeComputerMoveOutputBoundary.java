package us.jonathans.use_case.makeComputerMove;

import us.jonathans.entity.rule.MancalaBoard;

public interface MakeComputerMoveOutputBoundary {
    void presentUpdatedBoard(MancalaBoard board);
}
