package use_case.view_history;

import entity.FlightSearchInformation;

import java.util.List;

/**
 * DAO interface for the View History Use Case.
 */

public interface ViewHistoryDataAccessInterface {

    /**
     * Get the search history for a given user.
     * @param username the username retrieve the search history for
     */

    List<FlightSearchInformation> getSearchHistory(String username);
}
