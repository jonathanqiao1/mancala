package us.jonathans.use_case.start_game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.data_access.user.UserDataAccessInterface;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.user.User;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StartGameInteractorTest {

    @Mock
    private MatchDataAccessInterface matchDataAccessInterface;

    @Mock
    private UserDataAccessInterface userDataAccessObject;

    @Mock
    private StartGameOutputBoundary startGamePresenter;

    @InjectMocks
    private StartGameInteractor startGameInteractor;

    @Test
    void testInitialize() {
        assertNotNull(startGameInteractor);
        assertNotNull(matchDataAccessInterface);
        assertNotNull(startGamePresenter);
    }

    @Test
    void testSetsCurrentMatch() {
        StartGameInputData startGameInputData = new StartGameInputData(
                null,
                null,
                false,
                null
        );

        startGameInteractor.execute(startGameInputData);
        verify(matchDataAccessInterface).setCurrentMatch(any(EngineMatch.class));
    }

    @Test
    void testSetsUser() {
        StartGameInputData startGameInputData = new StartGameInputData(
                null,
                null,
                false,
                null
        );

        startGameInteractor.execute(startGameInputData);
        verify(userDataAccessObject).addUser(any(User.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "test",
            "not a phone number",
            "abc1234567",
            "abc12345678",
            "abc123456789",
            "2234567891a",
            "32345678912b",
            "111111111",
    })
    void testPhoneNumberValidationOutputDataFailure(String phoneNumber) {
        StartGameInputData startGameInputData = new StartGameInputData(
                null,
                phoneNumber,
                true,
                null
        );

        startGameInteractor.execute(startGameInputData);

        ArgumentCaptor<StartGameOutputData> captor = ArgumentCaptor.forClass(StartGameOutputData.class);
        verify(startGamePresenter, times(1)).prepareSuccessView(captor.capture());
        StartGameOutputData outputData = captor.getValue();

        assertFalse(outputData.successful());
        assertNotNull(outputData.failReason());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+1 (111) 111 1111",
            "+1 (111) 111-1111",
            "(111) 111 1111",
            "+1(111)1111111",
            "+11111111111",
            "11111111111",
            "1111111111",
            "+1 111-111-1111",
            "+1 (234) 567 0000",
    })
    void testPhoneNumberValidationOutputDataSuccess(String phoneNumber) {
        StartGameInputData startGameInputData = new StartGameInputData(
                null,
                phoneNumber,
                true,
                null
        );

        startGameInteractor.execute(startGameInputData);

        ArgumentCaptor<StartGameOutputData> captor = ArgumentCaptor.forClass(StartGameOutputData.class);
        verify(startGamePresenter, times(1)).prepareSuccessView(captor.capture());
        StartGameOutputData outputData = captor.getValue();

        assertTrue(outputData.successful());
        assertNull(outputData.failReason());
    }

    @Test
    void testPhoneNumberValidationOutputDataFailureNull() {
        StartGameInputData startGameInputData = new StartGameInputData(
                null,
                null,
                true,
                null
        );

        startGameInteractor.execute(startGameInputData);

        ArgumentCaptor<StartGameOutputData> captor = ArgumentCaptor.forClass(StartGameOutputData.class);
        verify(startGamePresenter, times(1)).prepareSuccessView(captor.capture());
        StartGameOutputData outputData = captor.getValue();

        assertFalse(outputData.successful());
        assertNotNull(outputData.failReason());
    }

    @Test
    void testExecute() {
        StartGameInputData startGameInputData = new StartGameInputData(
                "Bob",
                null,
                false,
                "minimax_easy"
        );

        startGameInteractor.execute(startGameInputData);

        ArgumentCaptor<StartGameOutputData> captor = ArgumentCaptor.forClass(StartGameOutputData.class);
        verify(startGamePresenter, times(1)).prepareSuccessView(captor.capture());
        StartGameOutputData outputData = captor.getValue();

        assertEquals(outputData.playerUsername(), "Bob");
        assertEquals(outputData.engineId(), "minimax_easy");
        assertFalse(outputData.usePhoneNumber());
        assertNull(outputData.playerPhoneNumber());
        assertTrue(outputData.successful());
        assertNull(outputData.failReason());
    }
}
