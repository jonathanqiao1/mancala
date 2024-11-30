package us.jonathans.use_case.make_player_move;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MoveResult;

public record MakePlayerMoveOutputData (
    MancalaBoard board,
    Boolean success
){}