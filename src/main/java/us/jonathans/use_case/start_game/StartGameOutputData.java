package us.jonathans.use_case.start_game;

import us.jonathans.entity.rule.MancalaBoard;

public record StartGameOutputData(
        String playerUsername,
        String playerPhoneNumber,
        String engineId,
        MancalaBoard board
) {
}
