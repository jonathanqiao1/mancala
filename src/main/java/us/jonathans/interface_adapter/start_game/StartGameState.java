package us.jonathans.interface_adapter.start_game;

import us.jonathans.use_case.start_game.StartGameOutputData;

public class StartGameState {
    private final String playerUsername;
    private final String playerPhoneNumber;
    private final boolean usePhoneNumber;
    private final String engineId;
    private final int[] board;
    private final boolean successful;
    private final String failReason;

    public StartGameState(
            String playerUsername,
            String playerPhoneNumber,
            boolean usePhoneNumber,
            String engineId,
            int[] board,
            boolean successful,
            String failReason
    ) {
        this.playerUsername = playerUsername;
        this.playerPhoneNumber = playerPhoneNumber;
        this.usePhoneNumber = usePhoneNumber;
        this.engineId = engineId;
        this.board = board;
        this.successful = successful;
        this.failReason = failReason;
    }

    public static StartGameState build(StartGameOutputData startGameOutputData) {
        return new StartGameState(
                startGameOutputData.playerUsername(),
                startGameOutputData.playerPhoneNumber(),
                startGameOutputData.usePhoneNumber(),
                startGameOutputData.engineId(),
                startGameOutputData.board() != null ? startGameOutputData.board().asArray() : null,
                startGameOutputData.successful(),
                startGameOutputData.failReason()
        );
    }

    public String getPlayerUsername() {
        return playerUsername;
    }

    public String getPlayerPhoneNumber() {
        return playerPhoneNumber;
    }

    public boolean isUsePhoneNumber() {
        return usePhoneNumber;
    }

    public String getEngineId() {
        return engineId;
    }

    public int[] getBoard() {
        return board;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getFailReason() {
        return failReason;
    }
}
