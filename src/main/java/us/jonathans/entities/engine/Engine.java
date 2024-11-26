package us.jonathans.entities.engine;

import us.jonathans.mancala.MancalaBoard;
import us.jonathans.mancala.MancalaHole;
import us.jonathans.mancala.MancalaSide;

public interface Engine {

    // Finds the best move for the current player
    public MancalaHole findBestMove(MancalaBoard board, MancalaSide player);
}
