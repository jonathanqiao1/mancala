package AI;

import us.jonathans.mancala.MancalaBoard;
import us.jonathans.mancala.MancalaHole;
import us.jonathans.mancala.MancalaSide;

public interface AIEngine {

    // Minimax Algorithm
    public int minimax(MancalaBoard board, int depth, boolean isMaximizingPlayer, MancalaSide player);

    // Finds the best move for the current player
    public MancalaHole findBestMove(MancalaBoard board, MancalaSide player);
}
