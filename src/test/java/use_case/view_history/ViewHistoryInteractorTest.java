package use_case.view_history;

import data_access.InMemorySearchHistoryDAO;
import entity.FlightSearchInformation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for the View History Interactor
 */

class ViewHistoryInteractorTest {

    @Test
    void successTest() {
        InMemorySearchHistoryDAO searchHistoryRepository = new InMemorySearchHistoryDAO();
        ViewHistoryInputData inputData = new ViewHistoryInputData("nightfury");

        // for the success test, we need to add some search history for a user (nightfury)

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String date = LocalDate.now().format(dateFormatter);
        String time = LocalTime.now().format(timeFormatter);
        FlightSearchInformation search = new FlightSearchInformation("Port Of Spain", "Toronto", 6, "January", 2026, date, time);
        searchHistoryRepository.save("nightfury", search);

        // create a success presenter to test if the interactor functioned as expected
        ViewHistoryOutputBoundary successPresenter = new ViewHistoryOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewHistoryOutputData outputData) {
                // we need to verify that the interactor packaged the relevant data correctly
                ViewHistoryOutputDataItem outputItem = outputData.getSearchHistory().get(0);
                assertEquals(date,  outputItem.getDate());
                assertEquals(time,  outputItem.getTime());
                assertEquals("Port Of Spain", outputItem.getFrom());
                assertEquals("Toronto", outputItem.getTo());
                assertEquals("6", outputItem.getDay());
                assertEquals("January", outputItem.getMonth());
                assertEquals("2026", outputItem.getYear());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                // this should never be reached since the test case should pass
                fail("Use case failure is unexpected.");
            }
        };

        ViewHistoryInputBoundary interactor = new ViewHistoryInteractor(searchHistoryRepository, successPresenter);
        interactor.execute(inputData);

    }

    @Test
    void failureTest() {
        // for the failure test, there is no search history for the user (nightfury)
        InMemorySearchHistoryDAO searchHistoryRepository = new InMemorySearchHistoryDAO();
        ViewHistoryInputData inputData = new ViewHistoryInputData("nightfury");

        // create a failure presenter to test if the interactor functioned as expected
        ViewHistoryOutputBoundary failurePresenter = new ViewHistoryOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewHistoryOutputData outputData) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                String expectedMessage = "Hmm...it appears you do not have any search history yet."
                                            + "\nSearch for a flight and try clicking this button again!";
                assertEquals(expectedMessage, errorMessage);
            }
        };

        ViewHistoryInputBoundary interactor = new ViewHistoryInteractor(searchHistoryRepository, failurePresenter);
        interactor.execute(inputData);

    }
}
