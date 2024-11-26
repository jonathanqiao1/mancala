package us.jonathans.data_access;

import us.jonathans.entity.MancalaGame;

public class MockGameDataAccess implements GameDataAccessInterface{

    @Override
    public MancalaGame getCurrentGame() {
        return new MancalaGame(Float.toString(System.currentTimeMillis()));
    }
}
