package us.jonathans.use_case.start_game;

import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.data_access.user.UserDataAccessInterface;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.user.User;

public class StartGameInteractor implements StartGameInputBoundary {
    private final MatchDataAccessInterface matchDataAccessObject;
    private final UserDataAccessInterface userDataAccessObject;
    private final StartGameOutputBoundary startGamePresenter;

    public StartGameInteractor(MatchDataAccessInterface matchDataAccessInterface,
                               UserDataAccessInterface userDataAccessObject,
                               StartGameOutputBoundary startGameOutputBoundary) {
        this.matchDataAccessObject = matchDataAccessInterface;
        this.userDataAccessObject = userDataAccessObject;
        this.startGamePresenter = startGameOutputBoundary;
    }

    @Override
    public void execute(StartGameInputData startGameInputData) {
        final String username = startGameInputData.playerUsername();
        final String phoneNumber = startGameInputData.playerPhoneNumber();
        final String engineId = startGameInputData.engineId();

        final User user = new User(username, phoneNumber);
        userDataAccessObject.addUser(user);

        final EngineMatch engineMatch = new EngineMatch(user.getId(), engineId);
        matchDataAccessObject.setCurrentMatch(engineMatch);

        final StartGameOutputData startGameOutputData = new StartGameOutputData(
                username,
                phoneNumber,
                engineId,
                engineMatch.getGame().getBoard()
        );
        startGamePresenter.prepareSuccessView(startGameOutputData);
    }
}
