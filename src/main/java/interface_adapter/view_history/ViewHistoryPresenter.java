package interface_adapter.view_history;

import entity.FlightSearchInformation;
import use_case.view_history.ViewHistoryOutputBoundary;
import use_case.view_history.ViewHistoryOutputData;

import java.util.List;

/**
 * The Presenter for the View History Use Case.
 */

public class ViewHistoryPresenter implements ViewHistoryOutputBoundary {

    public ViewHistoryPresenter() {
        // to implement
    }

    @Override
    public void prepareSuccessView(ViewHistoryOutputData viewHistoryOutputData) {
        final List<FlightSearchInformation> searchHistory = viewHistoryOutputData.getSearchHistory();

        if (searchHistory == null) {
            System.out.println("No search history found");
        }

        else {
            for  (FlightSearchInformation search : searchHistory) {
                System.out.println(search);
            }
        }
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // to implement
    }
}
