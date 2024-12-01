package us.jonathans.use_case.cancel_match;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.data_access.user.UserDataAccessInterface;
import us.jonathans.entity.match.EngineMatch;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CancelMatchInteractorTest {

    @Mock
    private MatchDataAccessInterface matchDataAccessInterface;

    @Mock
    private UserDataAccessInterface userDataAccessObject;

    @Mock
    private CancelMatchOutputBoundary cancelMatchPresenter;

    @InjectMocks
    private CancelMatchInteractor cancelMatchInteractor;

    @Test
    void testInitialize() {
        assertNotNull(cancelMatchInteractor);
        assertNotNull(matchDataAccessInterface);
        assertNotNull(cancelMatchPresenter);
    }

    @BeforeEach
    void setUp() {
        matchDataAccessInterface.setCurrentMatch(new EngineMatch(
                UUID.randomUUID(),
                "engine"
        ));
    }

    @Test
    void testUnsetsCurrentMatch() {
        CancelMatchInputData cancelMatchInputData = new CancelMatchInputData();

        cancelMatchInteractor.execute(cancelMatchInputData);
        verify(matchDataAccessInterface).setCurrentMatch(null);
    }


    @Test
    void testExecute() {
        CancelMatchInputData cancelMatchInputData = new CancelMatchInputData();

        cancelMatchInteractor.execute(cancelMatchInputData);

        ArgumentCaptor<CancelMatchOutputData> captor = ArgumentCaptor.forClass(CancelMatchOutputData.class);
        verify(cancelMatchPresenter, times(1)).prepareSuccessView(captor.capture());
        CancelMatchOutputData outputData = captor.getValue();
        assertNotNull(outputData);
    }
}