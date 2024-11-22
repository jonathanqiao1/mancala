package us.jonathans;

import us.jonathans.data_access.LeaderboardRepository;
import us.jonathans.interface_adapters.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapters.get_leaderboard.GetLeaderboardPresenter;
import us.jonathans.interface_adapters.get_leaderboard.GetLeaderboardViewModel;
import us.jonathans.interface_adapters.post_leaderboard.PostLeaderboardController;
import us.jonathans.interface_adapters.post_leaderboard.PostLeaderboardPresenter;
import us.jonathans.interface_adapters.post_leaderboard.PostLeaderboardViewModel;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardInteractor;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardOutputBoundary;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardInteractor;
import us.jonathans.view.GetLeaderboardView;
import us.jonathans.view.PostLeaderboardView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

    public void executeGetLeaderboard() {
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

    public void executePostLeaderboard() {
        LeaderboardRepository repository = new LeaderboardRepository();
        PostLeaderboardViewModel postLeaderboardViewModel = new PostLeaderboardViewModel("postLeaderboard");
        PostLeaderboardPresenter postLeaderboardPresenter = new PostLeaderboardPresenter(postLeaderboardViewModel);
        PostLeaderboardInteractor postLeaderboardInteractor =
                new PostLeaderboardInteractor(repository, postLeaderboardPresenter);
        PostLeaderboardController postLeaderboardController = new PostLeaderboardController(postLeaderboardInteractor);
        PostLeaderboardView view = new PostLeaderboardView(postLeaderboardViewModel);

        postLeaderboardController.execute("Bob", "Alice", 22);
        //Place holder and for testing until actual data is provided
    }
}
