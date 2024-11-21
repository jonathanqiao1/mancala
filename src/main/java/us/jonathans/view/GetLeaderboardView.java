package us.jonathans.view;

import us.jonathans.Config;
import us.jonathans.interface_adapters.GetLeaderboardViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetLeaderboardView extends JPanel implements PropertyChangeListener{
    private final GetLeaderboardViewModel getLeaderboardViewModel;
    private final JFrame leaderboardFrame = new JFrame(Config.LEADERBOARD_FRAME_NAME);
    private String[][] newValues = null;

    public GetLeaderboardView(GetLeaderboardViewModel getLeaderboardViewModel) {
        this.getLeaderboardViewModel = getLeaderboardViewModel;
        this.getLeaderboardViewModel.addPropertyChangeListener(this);
    }

    public void displayLeaderboard(){
        String[][] values = newValues;
        String[] columnNames = {"Rank", "Username", "Opponent", "Score", "Time"};
        JTable leaderboardTable = new JTable(values, columnNames);
        leaderboardTable.setBounds(30, 40, 1000, 400);
        JScrollPane scrollPane = new  JScrollPane(leaderboardTable);
        leaderboardFrame.add(scrollPane);
        leaderboardFrame.setSize(1000, 300);
        leaderboardFrame.setVisible(true);
        leaderboardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if ("leaderboard".equals(evt.getPropertyName())) {
            newValues = (String[][]) evt.getNewValue();
        }
    }
}
