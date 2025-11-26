package interface_adapter.viewing_history;

import entity.FlightSearchInformation;

import java.util.List;

/**
 * The state for the Viewing History View Model.
 */

public class ViewingHistoryState {

    private List<FlightSearchInformation> searchHistory;
    private FlightSearchInformation selectedEntry;
    private String errorMessage;

    public List<FlightSearchInformation> getSearchHistory() {
        return searchHistory;
    }

    public FlightSearchInformation getSelectedEntry() {
        return selectedEntry;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSearchHistory(List<FlightSearchInformation> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public void setSelectedEntry(FlightSearchInformation selectedEntry) {
        this.selectedEntry = selectedEntry;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
