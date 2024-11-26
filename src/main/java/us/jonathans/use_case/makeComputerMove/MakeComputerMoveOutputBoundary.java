package us.jonathans.use_case.makeComputerMove;

import us.jonathans.mancala.MancalaBoard;
import us.jonathans.mancala.MancalaSide;

public interface MakeComputerMoveOutputBoundary {
    void presentUpdatedBoard(MancalaBoard board);
}
