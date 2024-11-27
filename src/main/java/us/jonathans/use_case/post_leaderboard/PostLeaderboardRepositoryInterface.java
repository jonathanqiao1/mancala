package us.jonathans.use_case.post_leaderboard;

import java.io.IOException;

public interface PostLeaderboardRepositoryInterface {
    void postLeaderboard(String username, String opponent, int score, long timestamp) throws IOException, InterruptedException;
}
