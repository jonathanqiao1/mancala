package us.jonathans.view;

import us.jonathans.interface_adapter.post_leaderboard.PostLeaderboardViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PostLeaderboardView implements PropertyChangeListener {
    private final PostLeaderboardViewModel postLeaderboardViewModel;

    public PostLeaderboardView(PostLeaderboardViewModel postLeaderboardViewModel) {
        this.postLeaderboardViewModel = postLeaderboardViewModel;
        this.postLeaderboardViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("postLeaderboard".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(null, "Leaderboard updated successfully!");
        }
    }
}
