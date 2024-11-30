package us.jonathans.use_case.make_player_move;

import us.jonathans.entity.rule.MancalaBoard;

public record MakePlayerMoveOutputData (
        MancalaBoard board,
        Boolean result
){}