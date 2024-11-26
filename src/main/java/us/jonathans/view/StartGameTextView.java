package us.jonathans.view;

import us.jonathans.interface_adapter.start_game.StartGameViewModel;

public class StartGameTextView {
    private StartGameViewModel model;

    public StartGameTextView() {}

    public void updateAndPresent(StartGameViewModel model) {
        this.model = model;
        System.out.println(this.model.getStartGameAnnouncement());
    }
}
