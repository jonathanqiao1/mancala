package us.jonathans.view;

import us.jonathans.interface_adapter.cancel_match.CancelMatchViewModel;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private final static String viewName = "Game";

    public GameView(
            StartGameViewModel startGameViewModel,
            CancelMatchViewModel cancelMatchViewModel
    ) {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout());
        add(new JMancalaPanel(this, startGameViewModel, cancelMatchViewModel));
    }
}
