package interface_adapter.view_history;

import use_case.view_history.ViewHistoryInputBoundary;
import use_case.view_history.ViewHistoryInputData;

/**
 * Controller for the View History Use Case.
 */

public class ViewHistoryController {

    private final ViewHistoryInputBoundary viewHistoryInteractor;

    public ViewHistoryController(ViewHistoryInputBoundary viewHistoryInteractor) {
        this.viewHistoryInteractor = viewHistoryInteractor;
    }

    /**
     * Executes the View History Use Case.
     */

    public void execute(String username) {
        final ViewHistoryInputData viewHistoryInputData = new ViewHistoryInputData(username);
        this.viewHistoryInteractor.execute(viewHistoryInputData);
    }
}
