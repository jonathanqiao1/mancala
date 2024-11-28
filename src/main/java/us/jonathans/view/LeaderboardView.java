package us.jonathans.view;

import us.jonathans.app.Config;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LeaderboardView extends JPanel implements PropertyChangeListener {
    private final static String viewName = "Leaderboard";
    private static final String[] tableColumnNames = {
            "Rank", "Username", "Opponent", "Score", "Time"
    };
    private String[][] tableRows = new String[][]{};
    private final JTable leaderboardTable = new JTable();

    public LeaderboardView(
            GetLeaderboardController getLeaderboardController,
            GetLeaderboardViewModel getLeaderboardViewModel
    ) {
        getLeaderboardViewModel.addPropertyChangeListener(this);
        setBorder(BorderFactory.createTitledBorder(viewName));
        setLayout(new GridLayout());

        leaderboardTable.setModel(buildTableModel());
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        add(scrollPane);

        Thread.startVirtualThread(() -> {
            while (true) {
                getLeaderboardController.execute();
                try {
                    Thread.sleep(Config.LEADERBOARD_GET_INTERVAL_MS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private TableModel buildTableModel() {
        return new DefaultTableModel(tableRows, tableColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if ("leaderboard".equals(evt.getPropertyName())) {
            tableRows = (String[][]) evt.getNewValue();
            leaderboardTable.setModel(buildTableModel());
        }
    }
}
