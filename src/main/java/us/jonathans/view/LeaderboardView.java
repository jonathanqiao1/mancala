package us.jonathans.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeaderboardView extends JPanel {
    private final static String viewName = "Leaderboard";

    public LeaderboardView() {
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout());

        String[] columnNames = {"Rank", "Username", "Opponent", "Score", "Time"};
        JTable leaderboardTable = new JTable();

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{
                new Object[]{1, "Bob", "Alice", 34, "November 15, 2024"}
        }, columnNames) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        leaderboardTable.setModel(tableModel);
        JScrollPane scrollPane = new  JScrollPane(leaderboardTable);

        add(scrollPane);
    }
}
