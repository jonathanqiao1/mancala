package us.jonathans;

import javax.swing.*;

public class App {
    private final JFrame frame = new JFrame(Config.APP_NAME);

    public App() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(
                new JMancalaPanel()
        );
    }

    public void run() {
        frame.pack();
        frame.setVisible(true);
    }
}
