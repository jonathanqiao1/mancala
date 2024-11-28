package us.jonathans.entities.engine;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MancalaHole;
import us.jonathans.entity.rule.MancalaSide;

public interface Engine {

    // Finds the best move for the current player
    public MancalaHole findBestMove(MancalaBoard board, MancalaSide player);
}
