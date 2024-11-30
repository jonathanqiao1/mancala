package us.jonathans.use_case.post_leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostLeaderboardInteractorTest {

    @Mock
    private PostLeaderboardRepositoryInterface postLeaderboardRepository;
    @Mock
    private PostLeaderboardOutputBoundary postLeaderboardPresenter;
    @InjectMocks
    private PostLeaderboardInteractor postLeaderboardInteractor;
    private PostLeaderboardInputData postLeaderboardInputData;

    @BeforeEach
    void setUp() {
        postLeaderboardInputData = new PostLeaderboardInputData("Lily", "Easy", 20);
    }

    @Test
    void PostLeaderboardInteractor() {
        // Tests that everything is initialized (Nothing is null)
        assertNotNull(postLeaderboardInteractor);
        assertNotNull(postLeaderboardRepository);
        assertNotNull(postLeaderboardPresenter);
    }

    @Test
    void execute() {
        // Call on the actual method
        postLeaderboardInteractor.execute(postLeaderboardInputData);

        // Verify what needs to be called is called and is accurate
        verify(postLeaderboardRepository, times(1)).postLeaderboard(
                postLeaderboardInputData.getUsername(),
                postLeaderboardInputData.getOpponent(),
                postLeaderboardInputData.getScore(),
                postLeaderboardInputData.getTimestamp());

        ArgumentCaptor<PostLeaderboardOutputData> captor = ArgumentCaptor.forClass(PostLeaderboardOutputData.class);
        verify(postLeaderboardPresenter, times(1)).prepareSuccessView(captor.capture());
        PostLeaderboardOutputData outputData = captor.getValue();

        assertFalse(outputData.isCaseFailed());

    }
}