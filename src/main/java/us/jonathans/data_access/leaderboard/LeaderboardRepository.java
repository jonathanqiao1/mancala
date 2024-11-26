package us.jonathans.data_access.leaderboard;

import us.jonathans.entity.leaderboard.Leaderboard;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardRepositoryInterface;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardRepositoryInterface;

import java.util.*;

public class LeaderboardRepository implements GetLeaderboardRepositoryInterface, PostLeaderboardRepositoryInterface {
    // For testing purposes until the get and post api method gets done

    private Map<String, List<Set>> database;
    public LeaderboardRepository(){}

    @Override
    public Leaderboard getLeaderboard() {
        // To be completed after api is ready
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.add("Bob", "Alice", 34, 1732317767);
        leaderboard.add("Angel", "Alice", 32, 1731982658);

        return leaderboard;
    }

    @Override
    public void postLeaderboard(String username, String opponent, int score, long timestamp) {
        // To be finished by Richard
        System.out.println(username);
        System.out.println(opponent);
        System.out.println(score);
        System.out.println(timestamp);
    }
}
