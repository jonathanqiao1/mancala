package us.jonathans.use_case.make_computer_move;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.jonathans.data_access.engine.EngineManager;
import us.jonathans.data_access.match.MatchDataAccessInterface;
import us.jonathans.entity.engine.Engine;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.entity.rule.*;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MakeComputerMoveInteractorTest {
    private MatchDataAccessInterface matchDataAccess;
    private MakeComputerMoveOutputBoundary presenter;
    private Engine engine;
    private MancalaRuleSet mancalaRuleSet;
    private MancalaBoard mancalaBoard;
    private MakeComputerMoveInteractor interactor;

    @BeforeEach
    void setup() {

        // Create mocks
        matchDataAccess = mock(MatchDataAccessInterface.class);
        presenter = mock(MakeComputerMoveOutputBoundary.class);
        engine = mock(Engine.class);
        mancalaRuleSet = mock(MancalaRuleSet.class);
        mancalaBoard = mock(MancalaBoard.class);

        interactor = new MakeComputerMoveInteractor(matchDataAccess, presenter);

        EngineManager engineManagerMock = mock(EngineManager.class);
        when(engineManagerMock.getEngine(anyString(), any(MancalaRuleSet.class))).thenReturn(engine);

        // Mock EngineMatch
        EngineMatch match = mock(EngineMatch.class);
        when(matchDataAccess.getCurrentMatch()).thenReturn(match);

        // Set up the engineId to avoid null
        when(match.getEngineId()).thenReturn("minimax_easy");

        // Mock the game and its dependencies
        Game game = mock(Game.class);
        when(match.getGame()).thenReturn(game);
        when(game.getBoard()).thenReturn(mancalaBoard);
        when(game.getRuleSet()).thenReturn(mancalaRuleSet);
        when(game.getCurrentSide()).thenReturn(MancalaSide.PLAYER1);
    }

    @Test
    void testExecuteMakesValidComputerMove() {

        // Adjust the mock to return MancalaHole.A for this specific test case
        when(mancalaRuleSet.getLegalMoves(eq(mancalaBoard), eq(MancalaSide.PLAYER1)))
                .thenReturn(Set.of(MancalaHole.A));
        when(engine.findBestMove(eq(mancalaBoard), eq(MancalaSide.PLAYER1)))
                .thenReturn(MancalaHole.A);

        // Act
        interactor.execute(new MakeComputerMoveInputData());

        // Assert
        verify(mancalaRuleSet, times(1))
                .makeMove(eq(mancalaBoard), eq(MancalaSide.PLAYER1), eq(MancalaHole.A));
        verify(presenter, times(1)).prepareSuccessView(any(MakeComputerMoveOutputData.class));

        // Verify the best move was used to update the game
        verify(mancalaRuleSet).makeMove(mancalaBoard, MancalaSide.PLAYER1, MancalaHole.A);

        // Verify the presenter was called with the updated board
        verify(presenter).prepareSuccessView(any(MakeComputerMoveOutputData.class));
    }

    @Test
    void testExecuteHandlesNullBestMove() {
        // Adjust the mock to return null for this specific test case
        when(engine.findBestMove(eq(mancalaBoard), eq(MancalaSide.PLAYER1))).thenReturn(null);

        // Act & Assert
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> interactor.execute(new MakeComputerMoveInputData()),
                "Expected execute to throw, but it didn't"
        );

        // Verify the exception message
        assertEquals("No valid move was determined by the AI.", exception.getMessage());

        // Verify makeMove is not called
        verify(mancalaRuleSet, never()).makeMove(any(MancalaBoard.class), eq(MancalaSide.PLAYER1), any(MancalaHole.class));

        // Verify presenter is not called, since the interactor fails early
        verify(presenter, never()).prepareSuccessView(any(MakeComputerMoveOutputData.class));
    }
}
