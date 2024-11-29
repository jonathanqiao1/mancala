package us.jonathans.use_case.start_game;

public record StartGameInputData(
        String playerUsername,
        String playerPhoneNumber,
        boolean usePhoneNumber,
        String engineId
){}
