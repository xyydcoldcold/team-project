package use_case.view_history;

import entity.FlightSearchInformation;

import java.util.List;

/**
 * The View History Interactor.
 */

public class ViewHistoryInteractor implements ViewHistoryInputBoundary{

    private final ViewHistoryDataAccessInterface viewHistoryDataAccessObject;
    private final ViewHistoryOutputBoundary viewHistoryPresenter;

    public ViewHistoryInteractor(ViewHistoryDataAccessInterface viewHistoryDataAccessInterface,
                                 ViewHistoryOutputBoundary viewHistoryOutputBoundary) {

        this.viewHistoryDataAccessObject = viewHistoryDataAccessInterface;
        this.viewHistoryPresenter = viewHistoryOutputBoundary;
    }

    @Override
    public void execute(ViewHistoryInputData viewHistoryInputData) {

        // Call the Data Access Object to get the user's search history
        String username = viewHistoryInputData.getUsername();
        final List<FlightSearchInformation> searchHistory = viewHistoryDataAccessObject.getSearchHistory(username);

        // If user has a search history, package the data and prepare success view
        if (searchHistory != null) {
            final ViewHistoryOutputData viewHistoryOutputData = new ViewHistoryOutputData(searchHistory);
            viewHistoryPresenter.prepareSuccessView(viewHistoryOutputData);
        }

        // If not, prepare fail view
        else {
            viewHistoryPresenter.prepareFailView("Hmm...it appears you do not have any search history yet." +
                    "\nSearch for a flight and try clicking this button again!");
        }

    }
}
