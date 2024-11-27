package us.jonathans.interface_adapter.start_game;

import us.jonathans.use_case.start_game.StartGameOutputBoundary;
import us.jonathans.use_case.start_game.StartGameOutputData;

public class StartGamePresenter implements StartGameOutputBoundary {
    private final StartGameViewModel startGameViewModel;

    public StartGamePresenter(StartGameViewModel startGameViewModel) {
        this.startGameViewModel = startGameViewModel;
    }


    public void prepareSuccessView(StartGameOutputData startGameOutputData) {
        startGameViewModel.setState(
                StartGameState.build(startGameOutputData)
        );
        startGameViewModel.firePropertyChanged();
    }
}
