package us.jonathans.use_case.cancel_match;

import us.jonathans.data_access.match.MatchDataAccessInterface;

public class CancelMatchInteractor implements CancelMatchInputBoundary {
    private final MatchDataAccessInterface matchDataAccessObject;
    private final CancelMatchOutputBoundary startGamePresenter;

    public CancelMatchInteractor(MatchDataAccessInterface matchDataAccessInterface,
                                 CancelMatchOutputBoundary cancelMatchOutputBoundary) {
        this.matchDataAccessObject = matchDataAccessInterface;
        this.startGamePresenter = cancelMatchOutputBoundary;
    }

    @Override
    public void execute(CancelMatchInputData cancelMatchInputData) {
        matchDataAccessObject.setCurrentMatch(null);
        startGamePresenter.prepareSuccessView(
                new CancelMatchOutputData()
        );
    }
}
