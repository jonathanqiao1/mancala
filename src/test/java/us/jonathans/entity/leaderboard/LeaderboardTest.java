package us.jonathans.entity.leaderboard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    // Tests both add and getData
    @Test
    void add() {
        Leaderboard leaderboard = new Leaderboard();
        String username = "Bob";
        String opponent = "Alice";
        int score = 32;
        long timestamp = 1731981570;
        leaderboard.add(username, opponent, score, timestamp);

        Map<String, ArrayList<Object>> data = leaderboard.getData();
        assert (data.containsKey(username));
        assertEquals("Alice", data.get(username).get(0));
        assertEquals(32, data.get(username).get(1));
        assertEquals(Long.valueOf(1731981570), data.get(username).get(2));
    }

    @Test
    void sort() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.add("Lily", "Adam", 28, 1731982658);
        leaderboard.add("Bob", "Alice", 32, 1731981570);
        leaderboard.add("Matt", "Liam", 31, 1731982658);

        LinkedHashMap<String, ArrayList<Object>> actual = (LinkedHashMap<String, ArrayList<Object>>) leaderboard.sort();
        LinkedHashMap<String, ArrayList<Object>> expected = new LinkedHashMap<>();
        ArrayList<Object> arrylst;

        arrylst = new ArrayList<>();
        arrylst.add("Alice");
        arrylst.add(32);
        arrylst.add((long)1731981570);
        expected.put("Bob", arrylst);

        arrylst = new ArrayList<>();
        arrylst.add("Liam");
        arrylst.add(31);
        arrylst.add((long)1731982658);
        expected.put("Matt", arrylst);

        arrylst = new ArrayList<>();
        arrylst.add("Adam");
        arrylst.add(28);
        arrylst.add((long)1731982658);
        expected.put("Lily", arrylst);

        assertDeepEquals(expected, actual);
    }

    // Helper method to check if the contents of the HashMap is equal
    private void assertDeepEquals(LinkedHashMap<String, ArrayList<Object>> expected, LinkedHashMap<String, ArrayList<Object>> actual) {
        for (String key : expected.keySet()) {
            ArrayList<Object> expectedValue = expected.get(key);
            ArrayList<Object> actualValue = actual.get(key);

           assertArrayEquals(expectedValue.toArray(), actualValue.toArray());
        }
    }
}