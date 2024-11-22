package us.jonathans.interface_adapters.post_leaderboard;

import us.jonathans.use_case.post_leaderboard.PostLeaderboardOutputBoundary;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardOutputData;

public class PostLeaderboardPresenter implements PostLeaderboardOutputBoundary {

    private final PostLeaderboardViewModel postLeaderboardViewModel;

    public PostLeaderboardPresenter(PostLeaderboardViewModel postLeaderboardViewModel) {
        this.postLeaderboardViewModel = postLeaderboardViewModel;
    }

    @Override
    public void prepareSuccessView(PostLeaderboardOutputData postLeaderboardOutputData) {
        if(!postLeaderboardOutputData.isCaseFailed()) {
            postLeaderboardViewModel.firePropertyChanged("postLeaderboard", postLeaderboardOutputData);
        }
    }
}
