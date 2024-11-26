package us.jonathans;

import us.jonathans.data_access.MockGameDataAccess;
import us.jonathans.interface_adapter.start_game.StartGameController;
import us.jonathans.interface_adapter.start_game.StartGamePresenter;
import us.jonathans.use_case.start_game.StartGameInteractor;

public class StartGame {
    public static void main(String[] args) {
        StartGameController startGameController = new StartGameController(
                new StartGameInteractor(
                        new MockGameDataAccess(),
                        new StartGamePresenter()
                )
        );

        startGameController.execute("Ivan Chepelev", "1234253542", "minmaxEngine");
    }
}
