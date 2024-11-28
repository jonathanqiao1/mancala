package us.jonathans.interface_adapter.cancel_match;

import us.jonathans.use_case.cancel_match.CancelMatchInputBoundary;
import us.jonathans.use_case.cancel_match.CancelMatchInputData;
import us.jonathans.use_case.start_game.StartGameInputBoundary;
import us.jonathans.use_case.start_game.StartGameInputData;

public class CancelMatchController {
    private final CancelMatchInputBoundary cancelMatchUseCaseInteractor;

    public CancelMatchController(CancelMatchInputBoundary cancelMatchUseCaseInteractor) {
        this.cancelMatchUseCaseInteractor = cancelMatchUseCaseInteractor;
    }

    public void execute() {
        final CancelMatchInputData cancelMatchInputData = new CancelMatchInputData();
        cancelMatchUseCaseInteractor.execute(cancelMatchInputData);
    }
}
