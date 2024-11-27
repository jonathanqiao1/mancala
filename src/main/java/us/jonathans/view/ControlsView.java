package us.jonathans.view;

import javax.swing.*;
import java.awt.*;

public class ControlsView extends JPanel {
    private final static String viewName = "Controls";

    public ControlsView() {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout(2, 1));

        add(new CreateMatchView());
        add(new LeaderboardView());
    }
}
