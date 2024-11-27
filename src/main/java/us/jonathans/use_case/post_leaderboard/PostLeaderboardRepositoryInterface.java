package us.jonathans.use_case.post_leaderboard;

public interface PostLeaderboardRepositoryInterface {
    void postLeaderboard(String username, String opponent, int score, long timestamp);
}
