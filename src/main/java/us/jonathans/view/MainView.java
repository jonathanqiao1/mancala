package us.jonathans.view;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;
import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
    private final LayoutManager layout = new GridLayout(1, 2);

    public MainView(
            StartGameController startGameController,
            StartGameViewModel startGameViewModel,
            GetLeaderboardController getLeaderboardController,
            GetLeaderboardViewModel getLeaderboardViewModel
    ) {
        super();
        FlatLaf.setup(new FlatMonokaiProIJTheme());
        setLayout(layout);

        add(new ControlsView(
                startGameController,
                startGameViewModel,
                getLeaderboardController,
                getLeaderboardViewModel
        ));
        add(new GameView(
                startGameViewModel
        ));
    }
}
