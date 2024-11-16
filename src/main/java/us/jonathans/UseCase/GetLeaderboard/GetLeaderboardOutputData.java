package us.jonathans.UseCase.GetLeaderboard;

import us.jonathans.Entities.Leaderboard;

public class GetLeaderboardOutputData {
    private final Leaderboard leaderboard;

    public GetLeaderboardOutputData(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }
}
