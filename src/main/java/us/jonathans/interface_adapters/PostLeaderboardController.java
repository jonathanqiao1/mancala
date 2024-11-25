package us.jonathans.interface_adapters;

import us.jonathans.entities.Leaderboard;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardInteractor;

public class PostLeaderboardController {
    private final PostLeaderboardInteractor postLeaderboardInteractor;


    public PostLeaderboardController(PostLeaderboardInteractor postLeaderboardInteractor) {
        this.postLeaderboardInteractor = postLeaderboardInteractor;
    }

    public void execute(Leaderboard leaderboard) {
        postLeaderboardInteractor.postLeaderboard(leaderboard);
    }
}
