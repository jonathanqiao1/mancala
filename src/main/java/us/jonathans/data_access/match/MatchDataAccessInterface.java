package us.jonathans.data_access.match;

import us.jonathans.entity.match.EngineMatch;

public interface MatchDataAccessInterface {
    EngineMatch getCurrentMatch();

    void setCurrentMatch(EngineMatch match);
}
