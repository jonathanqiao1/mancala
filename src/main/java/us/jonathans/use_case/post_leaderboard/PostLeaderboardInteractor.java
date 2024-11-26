package us.jonathans.use_case.post_leaderboard;

public class PostLeaderboardInteractor implements PostLeaderboardInputBoundary{
    PostLeaderboardRepositoryInterface postLeaderboardRepository;
    PostLeaderboardOutputBoundary postLeaderboardPresenter;

    public PostLeaderboardInteractor(PostLeaderboardRepositoryInterface postLeaderboardRepository,
                                     PostLeaderboardOutputBoundary postLeaderboardPresenter) {
        this.postLeaderboardRepository = postLeaderboardRepository;
        this.postLeaderboardPresenter = postLeaderboardPresenter;
    }

    @Override
    public void execute(PostLeaderboardInputData postLeaderboardInputData) {
        postLeaderboardRepository.postLeaderboard(postLeaderboardInputData.getUsername(),
                postLeaderboardInputData.getOpponent(),
                postLeaderboardInputData.getScore(),
                postLeaderboardInputData.getTimestamp());

        PostLeaderboardOutputData postLeaderboardOutputData = new PostLeaderboardOutputData(false);
        postLeaderboardPresenter.prepareSuccessView(postLeaderboardOutputData);
    }
}
