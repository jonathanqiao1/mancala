package us.jonathans.entity.rule;

import java.util.Set;

public interface MancalaRuleSet {

    MoveResult makeMove(MancalaBoard board, MancalaSide player, MancalaHole hole);

    Set<MancalaHole> getLegalMoves(MancalaBoard board, MancalaSide player);

    MancalaSide checkWin(MancalaBoard board);

    Boolean isGameOver(MancalaBoard board);



}