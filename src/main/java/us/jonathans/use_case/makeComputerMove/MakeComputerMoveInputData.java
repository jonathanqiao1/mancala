package us.jonathans.use_case.makeComputerMove;

import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MancalaRuleSet;
import us.jonathans.entity.rule.MancalaSide;

public class MakeComputerMoveInputData {

    private final MancalaBoard board;
    private final MancalaRuleSet ruleSet;
    private final MancalaSide computerSide;
    private final String Id;

    public MakeComputerMoveInputData(MancalaBoard board, MancalaRuleSet ruleSet,
                                     MancalaSide computerSide, String Id) {
        this.board = board;
        this.ruleSet = ruleSet;
        this.computerSide = computerSide;
        this.Id = Id;
    }

    MancalaBoard getBoard() {
        return this.board;
    }

    MancalaRuleSet getRuleSet() {
        return this.ruleSet;
    }

    MancalaSide getComputerSide() {
        return this.computerSide;
    }

    String getId() {
        return this.Id;
    }
}
