package us.jonathans.data_access.match;

import us.jonathans.entity.match.EngineMatch;

public class InMemoryMatchDataAccess implements MatchDataAccessInterface {
    private static InMemoryMatchDataAccess singletonInstance = null;

    private EngineMatch currentMatch;

    public static InMemoryMatchDataAccess getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new InMemoryMatchDataAccess();
        }
        return singletonInstance;
    }

    @Override
    public EngineMatch getCurrentMatch() {
        return this.currentMatch;
    }

    @Override
    public void setCurrentMatch(EngineMatch match) {
        this.currentMatch = match;
    }
}
