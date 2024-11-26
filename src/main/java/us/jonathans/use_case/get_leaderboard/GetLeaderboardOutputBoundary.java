package us.jonathans.use_case.get_leaderboard;

import us.jonathans.entity.leaderboard.Leaderboard;

public interface GetLeaderboardOutputBoundary {
    String[][] getLeaderboardData(Leaderboard leaderboard);

    void prepareUpdateScreen(GetLeaderboardOutputData getLeaderboardOutputData);
}
