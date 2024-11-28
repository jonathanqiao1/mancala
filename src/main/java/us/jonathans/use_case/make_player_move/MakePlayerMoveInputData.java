package us.jonathans.use_case.make_player_move;

import us.jonathans.entity.rule.*;

public class MakePlayerMoveInputData {

    private final MancalaBoard board;
    private final MancalaRuleSet ruleSet;
    private final MancalaMove move;

    public MakePlayerMoveInputData(MancalaBoard board, MancalaRuleSet ruleSet, MancalaMove move) {
        this.board = board;
        this.ruleSet = ruleSet;
        this.move = move;
    }

    MancalaBoard getBoard() {
        return this.board;
    }

    MancalaRuleSet getRuleSet() {
        return this.ruleSet;
    }

    MancalaSide getMancalaSide() {
        return this.move.side();
    }

    MancalaHole getMancalaHole() {
        return this.move.hole();
    }
}
