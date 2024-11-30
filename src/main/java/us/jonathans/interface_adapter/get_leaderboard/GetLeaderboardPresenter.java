package us.jonathans.interface_adapter.get_leaderboard;

import us.jonathans.entity.leaderboard.Leaderboard;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardOutputBoundary;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardOutputData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GetLeaderboardPresenter implements GetLeaderboardOutputBoundary {
    GetLeaderboardViewModel getLeaderboardViewModel;

    public GetLeaderboardPresenter(GetLeaderboardViewModel getLeaderboardViewModel) {
        this.getLeaderboardViewModel = getLeaderboardViewModel;
    }

    @Override
    public String[][] getLeaderboardData(Leaderboard leaderboard) {
        Map<String, ArrayList<Object>> data = leaderboard.getData();
        int size = Math.min(data.size(), 10);

        String[][] values = new String[size][5];
        List<String> usernames = new ArrayList<>(data.keySet());

        String username;
        String opponent;
        int score;
        long time;
        int rank = 1;

        for (int i = 0; i < size; i++) {
            username = usernames.get(i);
            opponent = data.get(username).get(0).toString();
            score = (Integer) data.get(username).get(1);
            time = (long) data.get(username).get(2);

            Timestamp stamp = new Timestamp(time * 1000);
            Date date = new Date(stamp.getTime());

            values[i][0] = String.valueOf(rank);
            values[i][1] = username;
            values[i][2] = opponent;
            values[i][3] = String.valueOf(score);
            values[i][4] = date.toString();
            rank++;
        }
        return values;

    }

    public void prepareUpdateScreen(GetLeaderboardOutputData getLeaderboardOutputData) {
        getLeaderboardViewModel.firePropertyChanged("leaderboard",
                this.getLeaderboardData(getLeaderboardOutputData.getLeaderboard()));
    }
}
