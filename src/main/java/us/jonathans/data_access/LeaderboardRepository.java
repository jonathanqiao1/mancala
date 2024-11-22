package us.jonathans.data_access;

import us.jonathans.entities.Leaderboard;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardRepositoryInterface;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardRepositoryInterface;

import java.util.*;

public class LeaderboardRepository implements GetLeaderboardRepositoryInterface, PostLeaderboardRepositoryInterface {
    // For testing purposes until the get and post api method gets done

    private Map<String, List<Set>> database;
    public LeaderboardRepository(){}

    @Override
    public Leaderboard getLeaderboard() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.add("Bob", "Alice", 34, 1731981570);
        leaderboard.add("Angel", "Alice", 32, 1731982658);

        return leaderboard;
    }

    @Override
    public void postLeaderboard(Leaderboard leaderboard) {
    }
}
