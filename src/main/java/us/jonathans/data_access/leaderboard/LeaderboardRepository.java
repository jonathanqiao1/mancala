package us.jonathans.data_access.leaderboard;

import org.json.JSONArray;
import org.json.JSONObject;
import us.jonathans.data_access.leaderboard.LeaderboardClient;
import us.jonathans.entity.leaderboard.Leaderboard;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardRepositoryInterface;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardRepositoryInterface;

public class LeaderboardRepository implements GetLeaderboardRepositoryInterface, PostLeaderboardRepositoryInterface {

    LeaderboardClient leaderboardClient = new LeaderboardClient();

    // Gets the leaderboard info from the database and transform it into leaderboard data type
    @Override
    public Leaderboard getLeaderboard(){
        JSONArray arr = LeaderboardClient.getleaderboard();
        Leaderboard leaderboard = new Leaderboard();
        for(int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            String name = obj.getString("name");
            String opponent = obj.getString("opponent");
            int score = obj.getInt("score");
            long timestamp = obj.getLong("timestamp");
            leaderboard.add(name, opponent, score, timestamp);
        }

        return leaderboard;
    }

    // Posts the player's leaderboard info onto the database
    @Override
    public void postLeaderboard(String username, String opponent, int score, long timestamp){
        leaderboardClient.postleaderboard(username, opponent, score, timestamp);
    }
}
