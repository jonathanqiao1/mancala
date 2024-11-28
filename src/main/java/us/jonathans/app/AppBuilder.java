package us.jonathans.app;

import us.jonathans.data_access.leaderboard.LeaderboardRepository;
import us.jonathans.data_access.match.InMemoryMatchDataAccess;
import us.jonathans.data_access.user.InMemoryUserDataAccess;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardController;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardPresenter;
import us.jonathans.interface_adapter.get_leaderboard.GetLeaderboardViewModel;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveController;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMovePresenter;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveViewModel;
import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGamePresenter;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;
import us.jonathans.use_case.get_leaderboard.GetLeaderboardInteractor;
import us.jonathans.use_case.make_player_move.MakePlayerMoveInteractor;
import us.jonathans.use_case.start_game.StartGameInteractor;

public class AppBuilder {
    private StartGameViewModel startGameViewModel;
    private StartGameController startGameController;
    private GetLeaderboardViewModel getLeaderboardViewModel;
    private GetLeaderboardController getLeaderboardController;
    private MakePlayerMoveViewModel makePlayerMoveViewModel;
    private MakePlayerMoveController makePlayerMoveController;

    public AppBuilder addStartGameUseCase() {
        startGameViewModel = new StartGameViewModel();
        startGameController = new StartGameController(
                    new StartGameInteractor(
                            InMemoryMatchDataAccess.getInstance(),
                            InMemoryUserDataAccess.getInstance(),
                            new StartGamePresenter(startGameViewModel)
                    )
            );
            return this;
    }

    public AppBuilder addLeaderboardUseCase() {
        getLeaderboardViewModel = new GetLeaderboardViewModel();
        getLeaderboardController = new GetLeaderboardController(
                new GetLeaderboardInteractor(
                        new LeaderboardRepository(),
                        new GetLeaderboardPresenter(getLeaderboardViewModel)
                )
        );
        return this;
    }

    public AppBuilder addMakePlayerMoveUseCase() {
        makePlayerMoveViewModel = new MakePlayerMoveViewModel();
        makePlayerMoveController = new MakePlayerMoveController(
                new MakePlayerMoveInteractor(
                        InMemoryMatchDataAccess.getInstance(),
                        new MakePlayerMovePresenter(makePlayerMoveViewModel)
                )
        );
        return this;
    }

    public App build() {
        return new App(
                startGameController,
                startGameViewModel,
                getLeaderboardController,
                getLeaderboardViewModel,
                makePlayerMoveViewModel,
                makePlayerMoveController
        );
    }
}
