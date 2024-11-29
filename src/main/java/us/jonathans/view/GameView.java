package us.jonathans.view;

import us.jonathans.interface_adapter.start_game.StartGameViewModel;
import us.jonathans.interface_adapter.make_computer_move.MakeComputerMoveController;
import us.jonathans.interface_adapter.make_computer_move.MakeComputerMoveViewModel;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private final static String viewName = "Game";

    public GameView(StartGameViewModel startGameViewModel,
                    MakeComputerMoveController makeComputerMoveController,
                    MakeComputerMoveViewModel makeComputerMoveViewModel) {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout());
        add(new JMancalaPanel(this, startGameViewModel, makeComputerMoveController, makeComputerMoveViewModel));

    }
}
