package us.jonathans.app;

import us.jonathans.data_access.leaderboard.LeaderboardRepository;
import us.jonathans.data_access.match.InMemoryMatchDataAccess;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.rule.MancalaSide;
import us.jonathans.interface_adapter.cancel_match.CancelMatchController;
import us.jonathans.interface_adapter.cancel_match.CancelMatchViewModel;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardPresenter;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;
import us.jonathans.interface_adapter.notifyuser.NotificationService;
import us.jonathans.interface_adapter.notifyuser.NotifyUserController;
import us.jonathans.interface_adapter.notifyuser.NotifyUserPresenter;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveController;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveViewModel;
import us.jonathans.interface_adapter.post_leaderboard.PostLeaderboardController;
import us.jonathans.interface_adapter.post_leaderboard.PostLeaderboardPresenter;
import us.jonathans.interface_adapter.post_leaderboard.PostLeaderboardViewModel;
import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;
import us.jonathans.interface_adapter.make_computer_move.MakeComputerMoveController;
import us.jonathans.interface_adapter.make_computer_move.MakeComputerMoveViewModel;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardInteractor;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardOutputBoundary;
import us.jonathans.use_case.notify_user.NotifyUserInputBoundary;
import us.jonathans.use_case.notify_user.NotifyUserInputData;
import us.jonathans.use_case.notify_user.NotifyUserInteractor;
import us.jonathans.use_case.notify_user.NotifyUserOutputBoundary;
import us.jonathans.use_case.post_leaderboard.PostLeaderboardInteractor;
import us.jonathans.view.MainView;
import us.jonathans.view.PostLeaderboardView;
import us.jonathans.view.TwilioNotificationService;

import javax.management.Notification;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App implements KeyListener {
    private final JFrame frame = new JFrame(Config.APP_NAME);
    private StartGameViewModel startGameViewModel;
    private GetLeaderboardViewModel getLeaderboardViewModel;
    private PostLeaderboardViewModel postLeaderboardViewModel;
    private MakePlayerMoveViewModel makePlayerMoveViewModel;
    private MakePlayerMoveController makePlayerMoveController;

    public App(
            StartGameController startGameController,
            StartGameViewModel startGameViewModel,
            GetLeaderboardController getLeaderboardController,
            GetLeaderboardViewModel getLeaderboardViewModel,
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

        Thread.startVirtualThread(() -> {
            while (true) {
                EngineMatch engineMatch = InMemoryMatchDataAccess.getInstance().getCurrentMatch();
                if (engineMatch == null) {
                    continue;
                }
                MancalaSide playerToMove = engineMatch.getGame().getCurrentSide();
                if (playerToMove == engineMatch.getEngineSide()) {
                    makeComputerMoveController.execute();
                    System.out.println("Computer moved");
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    public void run() {
        frame.setVisible(true);
        addGetLeaderboardUseCase();
        addGetLeaderboardView();
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

    public void addGetLeaderboardUseCase() {
        LeaderboardRepository repository = new LeaderboardRepository();
        getLeaderboardViewModel = new GetLeaderboardViewModel();
        GetLeaderboardOutputBoundary presenter = new GetLeaderboardPresenter(getLeaderboardViewModel);
        GetLeaderboardInteractor interactor = new GetLeaderboardInteractor(repository, presenter);
        GetLeaderboardController controller = new GetLeaderboardController(interactor);
    }

    public void addGetLeaderboardView(){
//        getLeaderboardView = new GetLeaderboardView(getLeaderboardViewModel);
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



    public void addPostLeaderboardUseCase(){
        LeaderboardRepository repository = new LeaderboardRepository();
        postLeaderboardViewModel = new PostLeaderboardViewModel("postLeaderboard");
        PostLeaderboardPresenter postLeaderboardPresenter = new PostLeaderboardPresenter(postLeaderboardViewModel);
        PostLeaderboardInteractor postLeaderboardInteractor =
                new PostLeaderboardInteractor(repository, postLeaderboardPresenter);
        PostLeaderboardController postLeaderboardController = new PostLeaderboardController(postLeaderboardInteractor);

        // Panel.setPostLeaderboardController(postLeaderboardController)
    }
    public void addPostLeaderboardView() {
        PostLeaderboardView view = new PostLeaderboardView(postLeaderboardViewModel);

        //postLeaderboardController.execute("Bob", "Alice", 22);
    }


}
