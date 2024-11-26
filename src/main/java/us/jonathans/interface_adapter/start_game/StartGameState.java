package us.jonathans.interface_adapter.start_game;

import us.jonathans.use_case.start_game.StartGameOutputData;

public class StartGameState {
    private final String startGameAnnouncement;
    private int[] board;

    public StartGameState(String playerUsername,
                              String playerPhoneNumber,
                              String engineId,
                              int[] board) {
        this.startGameAnnouncement = "Started a game between "
                + playerUsername + " (" + playerPhoneNumber + ") "
                + "and " + engineId;
        this.board = board;
    }

    public String getStartGameAnnouncement() {
        return this.startGameAnnouncement;
    }

    public int[] getBoard() {
        return board;
    }

    public static StartGameState build(StartGameOutputData startGameOutputData) {
        return new StartGameState(
                startGameOutputData.playerUsername(),
                startGameOutputData.playerPhoneNumber(),
                startGameOutputData.engineId(),
                startGameOutputData.board().asArray()
        );
    }
}
