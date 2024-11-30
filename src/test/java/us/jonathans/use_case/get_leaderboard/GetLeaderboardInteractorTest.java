package us.jonathans.use_case.get_leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import us.jonathans.entity.leaderboard.Leaderboard;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetLeaderboardInteractorTest {
    @Mock
    private GetLeaderboardRepositoryInterface getLeaderboardRepository;

    @Mock
    private GetLeaderboardOutputBoundary getLeaderboardPresenter;

    @InjectMocks
    private GetLeaderboardInteractor interactor;
    private Leaderboard mockLeaderboard;

    @BeforeEach
    void setUp() {
        mockLeaderboard = new Leaderboard();
        mockLeaderboard.add("Bob", "Hard", 15, 1731981570);
    }

    @Test
    void GetLeaderboardInteractor() {
        // Tests that everything is initialized (Nothing is null)
        assertNotNull(interactor);
        assertNotNull(getLeaderboardRepository);
        assertNotNull(getLeaderboardPresenter);
    }

    @Test
    void getLeaderboard() {
        // Mock the repository to return the mock leaderboard
        when(getLeaderboardRepository.getLeaderboard()).thenReturn(mockLeaderboard);

        // Call on the actual method
        Leaderboard leaderboard = interactor.getLeaderboard();

        // Verify that the data being returned is correct
        assertNotNull(leaderboard);
        assertNotNull(leaderboard.getData());
        assertEquals("Hard", leaderboard.getData().get("Bob").get(0));
        assertEquals(15, leaderboard.getData().get("Bob").get(1));
        assertEquals(Long.valueOf(1731981570), leaderboard.getData().get("Bob").get(2));
    }

    @Test
    void execute() {
        // Mock the repository to return the mock leaderboard
        when(getLeaderboardRepository.getLeaderboard()).thenReturn(mockLeaderboard);

        // Call on the actual method
        interactor.execute();

        // Verify what needs to be called is called and is accurate
        verify(getLeaderboardRepository, times(1)).getLeaderboard();
        ArgumentCaptor<GetLeaderboardOutputData> captor = ArgumentCaptor.forClass(GetLeaderboardOutputData.class);
        verify(getLeaderboardPresenter, times(1)).prepareUpdateScreen(captor.capture());
        GetLeaderboardOutputData output = captor.getValue();

        assertEquals(mockLeaderboard, output.getLeaderboard());
    }

    @Test
    void execute_withEmptyLeaderboard() {
        // Mock the repository to return an empty leaderboard
        Leaderboard emptyLeaderboard = new Leaderboard();
        when(getLeaderboardRepository.getLeaderboard()).thenReturn(emptyLeaderboard);

        // Call on the actual method
        interactor.execute();

        // Verify what needs to be called is called and is accurate
        verify(getLeaderboardRepository, times(1)).getLeaderboard();
        ArgumentCaptor<GetLeaderboardOutputData> captor = ArgumentCaptor.forClass(GetLeaderboardOutputData.class);
        verify(getLeaderboardPresenter, times(1)).prepareUpdateScreen(captor.capture());
        GetLeaderboardOutputData capturedOutputData = captor.getValue();

        assertEquals(emptyLeaderboard, capturedOutputData.getLeaderboard());
    }
}