package use_case.view_history;

/**
 * Input Boundary for the View History use case.
 */

public interface ViewHistoryInputBoundary {

    /**
     * Executes the View History use case. After this executes,
     * the user will be taken to a new view where they can see
     * their entire search history.
     */

    void execute(ViewHistoryInputData viewHistoryInputData);
}
