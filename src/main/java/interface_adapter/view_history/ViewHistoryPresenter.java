package interface_adapter.view_history;

import entity.FlightSearchInformation;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.viewing_history.ViewingHistoryState;
import interface_adapter.viewing_history.ViewingHistoryViewModel;
import use_case.view_history.ViewHistoryOutputBoundary;
import use_case.view_history.ViewHistoryOutputData;

import java.util.List;

/**
 * The Presenter for the View History Use Case.
 */

public class ViewHistoryPresenter implements ViewHistoryOutputBoundary {

    private final ViewingHistoryViewModel viewingHistoryViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public ViewHistoryPresenter(ViewingHistoryViewModel viewingHistoryViewModel, LoggedInViewModel loggedInViewModel,
                                ViewManagerModel viewManagerModel) {

        this.viewingHistoryViewModel = viewingHistoryViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ViewHistoryOutputData viewHistoryOutputData) {
        final List<FlightSearchInformation> searchHistory = viewHistoryOutputData.getSearchHistory();

        // Notify the view (Viewing History View) that we are switching to
        final ViewingHistoryState viewingHistoryState = viewingHistoryViewModel.getState();
        viewingHistoryState.setSearchHistory(searchHistory);
        viewingHistoryViewModel.firePropertyChange("initialize success view");

        // Switch to the view
        viewManagerModel.setState(viewingHistoryViewModel.getViewName());
        viewManagerModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setError(errorMessage);
        loggedInViewModel.firePropertyChange("error");
    }
}
