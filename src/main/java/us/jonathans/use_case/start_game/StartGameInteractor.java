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
        final boolean usePhoneNumber = startGameInputData.usePhoneNumber();
        final String engineId = startGameInputData.engineId();

        if (usePhoneNumber && !isValidPhoneNumber(phoneNumber)) {
            final StartGameOutputData startGameOutputData = new StartGameOutputData(
                    username,
                    phoneNumber,
                    usePhoneNumber,
                    engineId,
                    null,
                    false,
                    "The phone number is invalid."
            );
            startGamePresenter.prepareSuccessView(startGameOutputData);
        } else {
            final User user = new User(username, phoneNumber, usePhoneNumber);
            userDataAccessObject.addUser(user);

            final EngineMatch engineMatch = new EngineMatch(user.getId(), engineId);
            matchDataAccessObject.setCurrentMatch(engineMatch);

            final StartGameOutputData startGameOutputData = new StartGameOutputData(
                    username,
                    phoneNumber,
                    usePhoneNumber,
                    engineId,
                    engineMatch.getGame().getBoard(),
                    true,
                    null
            );
            startGamePresenter.prepareSuccessView(startGameOutputData);
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        String strippedNumber = phoneNumber.replaceAll("[+\\-()\\s]", "");

        if (!strippedNumber.matches("\\d+")) {
            return false;
        }

        int length = strippedNumber.length();
        return length == 10 || length == 11;
    }
}
