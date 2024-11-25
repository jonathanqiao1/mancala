package us.jonathans.use_case.post_leaderboard;

import us.jonathans.entities.Leaderboard;

public class PostLeaderboardInteractor {
    PostLeaderboardRepositoryInterface postLeaderboardRepository;

    public PostLeaderboardInteractor(PostLeaderboardRepositoryInterface postLeaderboardRepository) {
        this.postLeaderboardRepository = postLeaderboardRepository;
    }

    public void postLeaderboard(Leaderboard leaderboard){
        postLeaderboardRepository.postLeaderboard(leaderboard);
    }
}
