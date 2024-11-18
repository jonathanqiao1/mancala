package us.jonathans;

import us.jonathans.DataAccess.LeaderboardRepository;
import us.jonathans.InterfaceAdapters.GetLeaderboardController;
import us.jonathans.InterfaceAdapters.GetLeaderboardPresenter;
import us.jonathans.InterfaceAdapters.GetLeaderboardViewModel;
import us.jonathans.UseCase.GetLeaderboard.GetLeaderboardInteractor;
import us.jonathans.UseCase.GetLeaderboard.GetLeaderboardOutputBoundary;
import us.jonathans.View.GetLeaderboardView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class App implements KeyListener {
    private final JFrame frame = new JFrame(Config.APP_NAME);
    private final JMancalaPanel mancalaPanel = new JMancalaPanel(frame);
    private GetLeaderboardViewModel getLeaderboardViewModel;

    public App() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setContentPane(mancalaPanel);
        frame.addKeyListener(this);
    }


    public void run() {
        frame.setVisible(true);
    }

    public void close() {
        this.frame.dispose();
        System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.close();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void executeGetLeaderboard() throws IOException {
        LeaderboardRepository repository = new LeaderboardRepository();
        getLeaderboardViewModel = new GetLeaderboardViewModel("leaderboard");
        GetLeaderboardOutputBoundary presenter = new GetLeaderboardPresenter(getLeaderboardViewModel);
        GetLeaderboardInteractor interactor = new GetLeaderboardInteractor(repository, presenter);
        GetLeaderboardController controller = new GetLeaderboardController(interactor);
        GetLeaderboardView view = new GetLeaderboardView(getLeaderboardViewModel);

        controller.execute();
        leaderboardView(view);
    }

    public void leaderboardView(GetLeaderboardView view) {
        view.displayLeaderboard();
    }
}
