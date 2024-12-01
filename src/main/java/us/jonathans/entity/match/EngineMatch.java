package us.jonathans.entity.match;

import us.jonathans.entity.rule.Game;
import java.util.UUID;

public class EngineMatch {
    final UUID playerId;
    final String engineId;
    final Game game = new Game();

    public EngineMatch(UUID playerId, String engineId) {
        this.playerId = playerId;
        this.engineId = engineId;
    }

    public Game getGame() {
        return game;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public String getEngineId() {
        return engineId;
    }
}
