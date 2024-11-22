package us.jonathans.unit;

import org.junit.jupiter.api.Test;
import us.jonathans.entities.Leaderboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeaderboardSortTest {

    @Test
    void testSort() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.add("Bob", "Alice", 32, 1731981570);
        leaderboard.add("Matt", "Liam", 31, 1731982658);
        leaderboard.add("Lily", "Adam", 28, 1731982658);

        Map<String, ArrayList<Object>> actual = leaderboard.sort();
        Map<String, ArrayList<Object>> expected = new HashMap<>();
        ArrayList<Object> arrylst = new ArrayList<>();
        arrylst.add("Adam");
        arrylst.add(28);
        arrylst.add(1731982658);
        expected.put("Lily", arrylst);

        arrylst = new ArrayList<>();
        arrylst.add("Liam");
        arrylst.add(31);
        arrylst.add(1731982658);
        expected.put("Matt", arrylst);

        arrylst = new ArrayList<>();
        arrylst.add("Alice");
        arrylst.add(32);
        arrylst.add(1731981570);
        expected.put("Bob", arrylst);

        assert actual.equals(expected);
    }
}
