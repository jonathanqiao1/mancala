package us.jonathans.use_case.makeComputerMove;

import us.jonathans.entities.engine.Engine;
import us.jonathans.entities.engine.EngineManager;
import us.jonathans.mancala.MancalaBoard;
import us.jonathans.mancala.MancalaHole;
import us.jonathans.mancala.MancalaRuleSet;
import us.jonathans.mancala.MancalaSide;

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
