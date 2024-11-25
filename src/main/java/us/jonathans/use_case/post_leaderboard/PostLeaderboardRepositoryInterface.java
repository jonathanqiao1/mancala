package us.jonathans.use_case.post_leaderboard;

import us.jonathans.entities.Leaderboard;

public interface PostLeaderboardRepositoryInterface {
    void postLeaderboard(Leaderboard leaderboard);
}
