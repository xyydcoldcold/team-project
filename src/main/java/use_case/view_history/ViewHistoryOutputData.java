package use_case.view_history;

import entity.FlightSearchInformation;

import java.util.List;

/**
 * Output Data for the View History Use Case.
 */

public class ViewHistoryOutputData {

    private final List<FlightSearchInformation> searchHistory;

    public ViewHistoryOutputData(List<FlightSearchInformation> searchHistory) {
        this.searchHistory = searchHistory;

    }

    public List<FlightSearchInformation> getSearchHistory() {
        return searchHistory;
    }
}
