package us.jonathans.UseCase.GetLeaderboard;

import us.jonathans.Entities.Leaderboard;

import java.util.ArrayList;
import java.util.Map;

public interface GetLeaderboardOutputBoundary {
    String[][] getLeaderboardData(Leaderboard leaderboard);

    void prepareUpdateScreen(GetLeaderboardOutputData getLeaderboardOutputData);
}
