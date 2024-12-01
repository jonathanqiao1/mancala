package us.jonathans.app;

import us.jonathans.data_access.leaderboard.LeaderboardRepository;
import us.jonathans.data_access.match.InMemoryMatchDataAccess;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.rule.MancalaSide;
import us.jonathans.interface_adapter.cancel_match.CancelMatchController;
import us.jonathans.interface_adapter.cancel_match.CancelMatchViewModel;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;
import us.jonathans.interface_adapter.notifyuser.NotificationService;
import us.jonathans.interface_adapter.notifyuser.NotifyUserController;
import us.jonathans.interface_adapter.notifyuser.NotifyUserPresenter;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveController;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveViewModel;
import us.jonathans.interface_adapter.post_leaderboard.PostLeaderboardController;
import us.jonathans.interface_adapter.post_leaderboard.PostLeaderboardViewModel;
import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;
import us.jonathans.interface_adapter.make_computer_move.MakeComputerMoveController;
import us.jonathans.interface_adapter.make_computer_move.MakeComputerMoveViewModel;
import us.jonathans.use_case.notify_user.NotifyUserInputBoundary;
import us.jonathans.use_case.notify_user.NotifyUserInteractor;
import us.jonathans.use_case.notify_user.NotifyUserOutputBoundary;
import us.jonathans.view.MainView;
import us.jonathans.view.TwilioNotificationService;

import javax.management.Notification;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App implements KeyListener {
    private final JFrame frame = new JFrame(Config.APP_NAME);

    public App(
            StartGameController startGameController,
            StartGameViewModel startGameViewModel,
            GetLeaderboardController getLeaderboardController,
            GetLeaderboardViewModel getLeaderboardViewModel,
            PostLeaderboardController postLeaderboardController,
            PostLeaderboardViewModel postLeaderboardViewModel,
            MakePlayerMoveViewModel makePlayerMoveViewModel,
            MakePlayerMoveController makePlayerMoveController,
            MakeComputerMoveController makeComputerMoveController,
            MakeComputerMoveViewModel makeComputerMoveViewModel,
            CancelMatchController cancelMatchController,
            CancelMatchViewModel cancelMatchViewModel
    ) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.addKeyListener(this);
        JPanel mainView = new MainView(
                startGameController,
                startGameViewModel,
                getLeaderboardController,
                getLeaderboardViewModel,
                makePlayerMoveViewModel,
                makePlayerMoveController,
                makeComputerMoveController,
                makeComputerMoveViewModel,
                cancelMatchController,
                cancelMatchViewModel
        );
        frame.setContentPane(mainView);
        makeComputerMoveController.startComputerMoveThread();
    }


    public void run() {
        frame.setVisible(true);
        notifyUserUseCase();
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

    public void notifyUserUseCase() {
        LeaderboardRepository repository = new LeaderboardRepository();
        NotificationService notificationService = new TwilioNotificationService(
                System.getenv("ACCOUNT_SID"),
                System.getenv("AUTH_TOKEN"),
                System.getenv("TWILIO_NUMBER")
        );
        NotifyUserOutputBoundary presenter = new NotifyUserPresenter(notificationService);
        NotifyUserInputBoundary interactor = new NotifyUserInteractor(repository, presenter);
        NotifyUserController controller = new NotifyUserController(interactor);

        String phoneNumber = "User Phone Number should go here";
        String username = "User Name should go here";

        controller.notifyUser(phoneNumber, username);
    }
}
