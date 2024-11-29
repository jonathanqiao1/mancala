package us.jonathans.interface_adapter.start_game;

import us.jonathans.use_case.start_game.StartGameInputBoundary;
import us.jonathans.use_case.start_game.StartGameInputData;

public class StartGameController {
    private final StartGameInputBoundary startGameUseCaseInteractor;

    public StartGameController(StartGameInputBoundary startGameUseCaseInteractor) {
        this.startGameUseCaseInteractor = startGameUseCaseInteractor;
    }

    /**
     * Executes the StartGame Use Case.
     * @param playerUsername the username of the user starting the game
     * @param playerPhoneNumber the phone number of the user starting the game
     * @param engineId the ID of the opponent engine
     */
    public void execute(
            String playerUsername,
            String playerPhoneNumber,
            boolean usePhoneNumber,
            String engineId
    ) {
        final StartGameInputData startGameInputData = new StartGameInputData(
                playerUsername,
                playerPhoneNumber,
                usePhoneNumber,
                engineId
        );

        startGameUseCaseInteractor.execute(startGameInputData);
    }
}
