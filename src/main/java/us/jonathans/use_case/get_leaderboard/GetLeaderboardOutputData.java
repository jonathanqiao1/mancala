package us.jonathans.use_case.get_leaderboard;

import us.jonathans.entities.Leaderboard;

public class GetLeaderboardOutputData {
    private final Leaderboard leaderboard;

    public GetLeaderboardOutputData(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }
}
