package us.jonathans.use_case.get_leaderboard;

import us.jonathans.entity.leaderboard.Leaderboard;

import java.io.IOException;

public class GetLeaderboardInteractor implements GetLeaderboardInputBoundary {
    GetLeaderboardRepositoryInterface getLeaderboardRepository;
    GetLeaderboardOutputBoundary getLeaderboardPresenter;


    public GetLeaderboardInteractor(GetLeaderboardRepositoryInterface getLeaderboardRepository, GetLeaderboardOutputBoundary getLeaderboardOutputBoundary) {
        this.getLeaderboardRepository = getLeaderboardRepository;
        this.getLeaderboardPresenter = getLeaderboardOutputBoundary;
    }

    public Leaderboard getLeaderboard() throws IOException, InterruptedException {
        return getLeaderboardRepository.getLeaderboard();
    }

    public void execute() throws IOException, InterruptedException {
        GetLeaderboardOutputData getLeaderboardOutputData = new
                GetLeaderboardOutputData(getLeaderboardRepository.getLeaderboard());
        getLeaderboardPresenter.prepareUpdateScreen(getLeaderboardOutputData);
    }

}
