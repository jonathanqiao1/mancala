package us.jonathans.use_case.cancel_match;

public interface CancelMatchInputBoundary {
    /**
     * Executes the cancel match use case.
     * @param cancelMatchInputData the input data
     */
    void execute(CancelMatchInputData cancelMatchInputData);
}
