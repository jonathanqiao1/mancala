package us.jonathans.interface_adapters;

import us.jonathans.entities.Leaderboard;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardOutputBoundary;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardOutputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetLeaderboardPresenter implements GetLeaderboardOutputBoundary {
    GetLeaderboardViewModel getLeaderboardViewModel;

    public GetLeaderboardPresenter(GetLeaderboardViewModel getLeaderboardViewModel) {
        this.getLeaderboardViewModel = getLeaderboardViewModel;
    }

    @Override
    public String[][] getLeaderboardData(Leaderboard leaderboard) {
        Map<String, ArrayList<Integer>> data = leaderboard.getData();
        int size = Math.min(data.size(), 10);

        String[][] values = new String[size][3];
        List<String> usernames = new ArrayList<>(data.keySet());

        String username;
        int score;
        int time;

        for (int i = 0; i < size; i++) {
            username = usernames.get(i);
            score = data.get(username).get(0);
            time = data.get(username).get(1);

            values[i][0] = username;
            values[i][1] = String.valueOf(score);
            values[i][2] = String.valueOf(time);
        }
        return values;

    }

    public void prepareUpdateScreen(GetLeaderboardOutputData getLeaderboardOutputData) {
        getLeaderboardViewModel.firePropertyChanged("leaderboard",
                this.getLeaderboardData(getLeaderboardOutputData.getLeaderboard()));
    }
}
