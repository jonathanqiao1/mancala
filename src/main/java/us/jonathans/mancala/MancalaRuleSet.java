package us.jonathans.mancala;

import us.jonathans.MoveResult;

import java.util.Set;

public interface MancalaRuleSet {

    public MoveResult makeMove(MancalaBoard board, MancalaSide player, MancalaHole hole);

    public Set<MancalaHole> getLegalMoves(MancalaBoard board, MancalaSide player);

    public MancalaSide checkWin(MancalaBoard board);

    public Boolean isGameOver(MancalaBoard board);

}