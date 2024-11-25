package us.jonathans.use_case.post_leaderboard;

public class PostLeaderboardInputData {
    private final String username;
    private final String opponent;
    private final int score;
    private long timestamp;

    public PostLeaderboardInputData(String username, String opponent, int score) {
        this.username = username;
        this.opponent = opponent;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public String getOpponent() {
        return opponent;
    }

    public int getScore() {
        return score;
    }

    public long getTimestamp() {
        timestamp = System.currentTimeMillis()/1000;
        return timestamp;
    }
}
