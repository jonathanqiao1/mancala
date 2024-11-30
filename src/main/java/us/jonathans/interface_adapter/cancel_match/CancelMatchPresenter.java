package us.jonathans.interface_adapter.cancel_match;

import us.jonathans.use_case.cancel_match.CancelMatchOutputBoundary;
import us.jonathans.use_case.cancel_match.CancelMatchOutputData;

public class CancelMatchPresenter implements CancelMatchOutputBoundary {
    private final CancelMatchViewModel cancelMatchViewModel;

    public CancelMatchPresenter(CancelMatchViewModel cancelMatchViewModel) {
        this.cancelMatchViewModel = cancelMatchViewModel;
    }


    @Override
    public void prepareSuccessView(CancelMatchOutputData cancelMatchOutputData) {
        cancelMatchViewModel.setState(
                new CancelMatchState()
        );
        cancelMatchViewModel.firePropertyChanged();
    }
}
