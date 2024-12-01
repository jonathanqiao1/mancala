package us.jonathans.interface_adapter.make_computer_move;

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

}
