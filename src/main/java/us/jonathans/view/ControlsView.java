package us.jonathans.view;

import us.jonathans.interface_adapter.cancel_match.CancelMatchController;
import us.jonathans.interface_adapter.cancel_match.CancelMatchViewModel;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;
import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;

import javax.swing.*;
import java.awt.*;

public class ControlsView extends JPanel {
    private final static String viewName = "Controls";

    public ControlsView(
            StartGameController startGameController,
            StartGameViewModel startGameViewModel,
            GetLeaderboardController getLeaderboardController,
            GetLeaderboardViewModel getLeaderboardViewModel,
            CancelMatchController cancelMatchController,
            CancelMatchViewModel cancelMatchViewModel
    ) {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout(2, 1));

        add(new CreateMatchView(
                startGameController,
                startGameViewModel,
                cancelMatchController,
                cancelMatchViewModel
        ));
        add(new LeaderboardView(
                getLeaderboardController,
                getLeaderboardViewModel
        ));
    }
}
