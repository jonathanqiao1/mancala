package us.jonathans.data_access.game;

import us.jonathans.entity.rule.MancalaGame;

public class MockGameDataAccess implements GameDataAccessInterface{

    @Override
    public MancalaGame getCurrentGame() {
        return new MancalaGame(Float.toString(System.currentTimeMillis()));
    }
}
