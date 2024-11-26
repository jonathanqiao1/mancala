package us.jonathans.interface_adapter.start_game;

import us.jonathans.use_case.start_game.StartGameOutputBoundary;
import us.jonathans.use_case.start_game.StartGameOutputData;
import us.jonathans.view.StartGameTextView;

public class StartGamePresenter implements StartGameOutputBoundary {
    public void prepareSuccessView(StartGameOutputData startGameOutputData) {
        StartGameTextView startGameTextView = new StartGameTextView();
        startGameTextView.updateAndPresent(
                StartGameViewModel.build(startGameOutputData)
        );

    }
}
