package data_access;

import entity.FlightSearchInformation;
import use_case.view_history.ViewHistoryDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In-memory implementation of the DAO for storing user search history. This implementation does
 * NOT persist data between runs of the program. Primary use of this class if for testing.
 */

public class InMemorySearchHistoryDAO implements ViewHistoryDataAccessInterface {

    private final Map<String, List<FlightSearchInformation>> usersFlightSearchInfo = new HashMap<>();

    /**
     * Save a user's search information to memory.
     * @param username the username of the user.
     * @param flightSearchInformation the information entered by the user.
     */

    public void save(String username, FlightSearchInformation flightSearchInformation) {

        if (usersFlightSearchInfo.containsKey(username)) {
            usersFlightSearchInfo.get(username).add(flightSearchInformation);
        }

        else {
            final List<FlightSearchInformation> list = new ArrayList<>();
            list.add(flightSearchInformation);
            usersFlightSearchInfo.put(username, list);
        }
    }

    @Override
    public List<FlightSearchInformation> getSearchHistory(String username) {
        return usersFlightSearchInfo.get(username);
    }
}
