package use_case.make_player_move;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import us.jonathans.data_access.engine.EngineManager;
import us.jonathans.data_access.match.InMemoryMatchDataAccess;
import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.data_access.user.InMemoryUserDataAccess;
import us.jonathans.data_access.user.UserDataAccessInterface;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.rule.*;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMovePresenter;
import us.jonathans.interface_adapter.make_player_move.MakePlayerMoveViewModel;
import us.jonathans.interface_adapter.start_game.StartGamePresenter;
import us.jonathans.interface_adapter.start_game.StartGameViewModel;
import us.jonathans.use_case.make_computer_move.MakeComputerMoveInteractor;
import us.jonathans.use_case.make_player_move.MakePlayerMoveInputData;
import us.jonathans.use_case.make_player_move.MakePlayerMoveInteractor;
import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputBoundary;
import us.jonathans.use_case.make_player_move.MakePlayerMoveOutputData;
import us.jonathans.use_case.start_game.StartGameInputData;
import us.jonathans.use_case.start_game.StartGameInteractor;
import us.jonathans.use_case.start_game.StartGameOutputBoundary;
import us.jonathans.use_case.start_game.StartGameOutputData;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class MakePlayerMoveInteractorTest {

    @Mock
    private MatchDataAccessInterface matchDataAccessObject;

    @Mock
    private MancalaBoard mancalaBoard;

    @Mock
    private MancalaRuleSet mancalaRuleSet;

    @Mock
    private EngineMatch match;

    @Mock
    private StartGameOutputBoundary startGamePresenter;

    @Mock
    private UserDataAccessInterface userDataAccessObject;

    @Mock
    private MakePlayerMovePresenter makePlayerMovePresenter;

    @InjectMocks
    private StartGameInteractor startGameInteractor;

    @InjectMocks
    private MakePlayerMoveInteractor makePlayerMoveInteractor;

    @BeforeEach
    void setUp() {
        matchDataAccessObject = InMemoryMatchDataAccess.getInstance();
        userDataAccessObject = InMemoryUserDataAccess.getInstance();
        makePlayerMovePresenter = new MakePlayerMovePresenter(new MakePlayerMoveViewModel());

        makePlayerMoveInteractor = new MakePlayerMoveInteractor(matchDataAccessObject, makePlayerMovePresenter);

        StartGameInputData startGameInputData = new StartGameInputData(
                "Bob",
                null,
                false,
                "minimax_easy"
        );
        startGameInteractor = new StartGameInteractor(matchDataAccessObject, userDataAccessObject, new StartGamePresenter(new StartGameViewModel()));
        startGameInteractor.execute(startGameInputData);
    }

    @Test
    void testInitialize() {
        assertNotNull(makePlayerMoveInteractor);
        assertNotNull(matchDataAccessObject);
        assertNotNull(makePlayerMovePresenter);
    }

    @Test
    void executeMove() {
        MakePlayerMoveInputData inputData = new MakePlayerMoveInputData(
                new MancalaMove(MancalaSide.PLAYER1, MancalaHole.A)
        );

        makePlayerMoveInteractor.execute(inputData);

        ArgumentCaptor<MakePlayerMoveOutputData> captor = ArgumentCaptor.forClass(MakePlayerMoveOutputData.class);
        verify(makePlayerMovePresenter, times(1)).presentUpdatedBoard(captor.capture());
        MakePlayerMoveOutputData outputData = captor.getValue();

        assertEquals(outputData.board(), matchDataAccessObject.getCurrentMatch().getGame().getBoard());
        assertTrue(outputData.success());
    }
}