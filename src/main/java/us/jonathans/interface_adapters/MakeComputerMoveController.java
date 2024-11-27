package us.jonathans.interface_adapters;

import us.jonathans.use_case.makeComputerMove.MakeComputerMoveInputBoundary;
import us.jonathans.view.MakeComputerMoveView;

public class MakeComputerMoveController {
    private final MakeComputerMoveInputBoundary makeComputerMoveInteractor;

    public MakeComputerMoveController(MakeComputerMoveInputBoundary MakeComputerMoveInteractor) {
        this.makeComputerMoveInteractor = MakeComputerMoveInteractor;
    }

    public void execute() {
        makeComputerMoveInteractor.execute();
    }

}
