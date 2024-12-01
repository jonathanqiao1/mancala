package us.jonathans.interface_adapter.make_computer_move;

import us.jonathans.data_access.match.InMemoryMatchDataAccess;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.rule.MancalaSide;
import us.jonathans.use_case.make_computer_move.MakeComputerMoveInputBoundary;
import us.jonathans.use_case.make_computer_move.MakeComputerMoveInputData;

public class MakeComputerMoveController {
    private final MakeComputerMoveInputBoundary makeComputerMoveInteractor;

    public MakeComputerMoveController(MakeComputerMoveInputBoundary MakeComputerMoveInteractor) {
        this.makeComputerMoveInteractor = MakeComputerMoveInteractor;
    }

    public void execute() {
        makeComputerMoveInteractor.execute(new MakeComputerMoveInputData());
    }

    public void startComputerMoveThread() {
        Thread.startVirtualThread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                EngineMatch engineMatch = InMemoryMatchDataAccess.getInstance().getCurrentMatch();
                if (engineMatch == null) {
                    continue;
                }
                MancalaSide playerToMove = engineMatch.getGame().getCurrentSide();
                if (playerToMove == engineMatch.getEngineSide() && !engineMatch.getGame().isGameOver()) {
                    this.execute();
                }
            }
        });
    }
}
