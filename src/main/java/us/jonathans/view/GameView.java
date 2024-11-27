package us.jonathans.view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private final static String viewName = "Game";

    public GameView() {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout());
        add(new JMancalaPanel(this));
    }
}
