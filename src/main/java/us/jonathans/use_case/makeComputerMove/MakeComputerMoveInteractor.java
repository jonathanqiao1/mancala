package us.jonathans.use_case.makeComputerMove;

import us.jonathans.entities.engine.Engine;
import us.jonathans.entities.engine.EngineManager;
import us.jonathans.entity.rule.MancalaBoard;
import us.jonathans.entity.rule.MancalaHole;
import us.jonathans.entity.rule.MancalaRuleSet;
import us.jonathans.entity.rule.MancalaSide;

public class MakeComputerMoveInteractor implements MakeComputerMoveInputBoundary{

    MakeComputerMoveInputData inputData;

    // include all parameters in input data and pass it into the interactor
    // add id parameter
    public MakeComputerMoveInteractor (MakeComputerMoveInputData inputData) {
        this.inputData = inputData;
    }

    @Override
    public void execute() {
        EngineManager engineManager = new EngineManager();
        Engine engine = engineManager.getEngine(inputData.getId(), inputData.getRuleSet());
        MancalaHole bestMove = engine.findBestMove(inputData.getBoard(), inputData.getComputerSide());
        inputData.getRuleSet().makeMove(inputData.getBoard(), inputData.getComputerSide(), bestMove);
    }

}
