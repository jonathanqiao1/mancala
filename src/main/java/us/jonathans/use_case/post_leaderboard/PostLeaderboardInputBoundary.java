package us.jonathans.use_case.post_leaderboard;

import java.io.IOException;

public interface PostLeaderboardInputBoundary {
    void execute(PostLeaderboardInputData postLeaderboardInputData) throws IOException, InterruptedException;
}
