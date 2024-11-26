package us.jonathans.interface_adapters.post_leaderboard;

import us.jonathans.use_case.post_leaderboard.PostLeaderboardInputBoundary;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardInputData;

public class PostLeaderboardController {
    private final PostLeaderboardInputBoundary postLeaderboardInteractor;

    public PostLeaderboardController(PostLeaderboardInputBoundary postLeaderboardInteractor) {
        this.postLeaderboardInteractor = postLeaderboardInteractor;
    }

    public void execute(String username, String opponent, int score) {
        PostLeaderboardInputData postLeaderboardInputData =
                new PostLeaderboardInputData(username, opponent, score);

        postLeaderboardInteractor.execute(postLeaderboardInputData);
    }
}
