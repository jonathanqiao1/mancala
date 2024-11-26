package us.jonathans.use_case.post_leaderboard;

public class PostLeaderboardOutputData {
    private boolean caseFailed;

    public PostLeaderboardOutputData(boolean caseFailed) {
        this.caseFailed = caseFailed;
    }

    public boolean isCaseFailed() {
        return caseFailed;
    }
}
