package us.jonathans.use_case.get_leaderboard;

import us.jonathans.entity.leaderboard.Leaderboard;

import java.io.IOException;

public interface GetLeaderboardRepositoryInterface {
    Leaderboard getLeaderboard() throws IOException, InterruptedException;
}
