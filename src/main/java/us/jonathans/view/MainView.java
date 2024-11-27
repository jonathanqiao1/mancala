package us.jonathans.view;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
    private final LayoutManager layout = new GridLayout(1, 2);

    public MainView() {
        super();
        FlatLaf.setup(new FlatMonokaiProIJTheme());
        setLayout(layout);

        add(new ControlsView());
        add(new GameView());
    }
}
