package us.jonathans.interface_adapter.start_game;

import us.jonathans.interface_adapter.common.ViewModel;
import us.jonathans.use_case.start_game.StartGameOutputData;

public class StartGameViewModel extends ViewModel<StartGameState> {
    public StartGameViewModel() {
        super("start_game");
    }
}
