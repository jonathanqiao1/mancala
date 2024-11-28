package us.jonathans.view;

import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveController;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveViewModel;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private final static String viewName = "Game";

    public GameView(StartGameViewModel startGameViewModel, MakePlayerMoveViewModel makePlayerMoveViewModel, MakePlayerMoveController makePlayerMoveController) {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout());
        add(new JMancalaPanel(this, startGameViewModel, makePlayerMoveViewModel, makePlayerMoveController));
    }
}
