package us.jonathans.data_access;

import us.jonathans.entities.Leaderboard;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardRepositoryInterface;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardRepositoryInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeaderboardRepository implements GetLeaderboardRepositoryInterface, PostLeaderboardRepositoryInterface {
    private File file = new File("database.txt");

    public LeaderboardRepository() throws IOException {
        // For testing purposes until Richard finishes the database
        FileWriter writer = new FileWriter(file);
        writer.write("Mina,30,100\n");
        writer.write("Richard,25,30\n");
        writer.write("Ivan,35,30\n");
        writer.close();
    }

    @Override
    public Leaderboard getLeaderboard() {
        // For testing purposes until Richard finishes the database
        Leaderboard leaderboard = new Leaderboard();
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] result = data.split(",");
            leaderboard.add(result[0], Integer.parseInt(result[1]), Integer.parseInt(result[2]));
        }
        reader.close();
        return leaderboard;
    }

    @Override
    public void postLeaderboard(Leaderboard leaderboard) {

    }
}
