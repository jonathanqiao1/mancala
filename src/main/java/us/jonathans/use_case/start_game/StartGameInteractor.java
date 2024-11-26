package us.jonathans.use_case.start_game;

import us.jonathans.data_access.GameDataAccessInterface;

public class StartGameInteractor implements StartGameInputBoundary {
    private final GameDataAccessInterface gameDataAccessObject;
    private final StartGameOutputBoundary startGamePresenter;

    public StartGameInteractor(GameDataAccessInterface gameDataAccessInterface,
                           StartGameOutputBoundary startGameOutputBoundary) {
        this.gameDataAccessObject = gameDataAccessInterface;
        this.startGamePresenter = startGameOutputBoundary;
    }

    @Override
    public void execute(StartGameInputData startGameInputData) {
        final String username = startGameInputData.playerUsername();
        final String phoneNumber = startGameInputData.playerPhoneNumber();
        final String engine = startGameInputData.engineId();
        final StartGameOutputData loginOutputData = new StartGameOutputData(
                username,
                phoneNumber,
                engine
        );
        startGamePresenter.prepareSuccessView(loginOutputData);
    }
}
