package us.jonathans.interface_adapter.start_game;

import us.jonathans.use_case.start_game.StartGameOutputData;

public class StartGameViewModel {
    private final String startGameAnnouncement;

    public StartGameViewModel(String playerUsername, String playerPhoneNumber, String engineId) {
        this.startGameAnnouncement = "Started a game between "
                + playerUsername + " (" + playerPhoneNumber + ") "
                + "and " + engineId;
    }

    public String getStartGameAnnouncement() {
        return this.startGameAnnouncement;
    }

    public static StartGameViewModel build(StartGameOutputData startGameOutputData) {
        return new StartGameViewModel(
                startGameOutputData.playerUsername(),
                startGameOutputData.playerPhoneNumber(),
                startGameOutputData.engineId()
        );
    }
}
