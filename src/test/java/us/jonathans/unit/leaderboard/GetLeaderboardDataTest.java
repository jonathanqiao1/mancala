package us.jonathans.unit.leaderboard;

import org.testng.annotations.Test;
import us.jonathans.entity.leaderboard.Leaderboard;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardPresenter;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;

import java.util.Arrays;

public class GetLeaderboardDataTest {

    @Test
    public void testPresenterGetLeaderboardData() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.add("Bob", "Alice", 32, 1731981570);
        leaderboard.add("Matt", "Liam", 31, 1731982658);

        GetLeaderboardViewModel viewModel = new GetLeaderboardViewModel();
        GetLeaderboardPresenter presenter = new GetLeaderboardPresenter(viewModel);

        String[][] actual = presenter.getLeaderboardData(leaderboard);
        String[][] expected = {{"1", "Matt", "Liam", "31", "Mon Nov 18 21:17:38 EST 2024"},
                {"2", "Bob", "Alice", "32", "Mon Nov 18 20:59:30 EST 2024"}};

        assert Arrays.deepEquals(actual, expected);
    }
}
