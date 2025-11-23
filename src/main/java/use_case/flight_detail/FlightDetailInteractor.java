package use_case.flight_detail;

import entity.Flight;
import entity.FlightDetail;

public class FlightDetailInteractor implements FlightDetailInputBoundary {

    private final FlightDetailDataAccessInterface flightDetailDataAccessObject;
    private final FlightDetailOutputBoundary flightDetailPresenter;

    public FlightDetailInteractor(FlightDetailDataAccessInterface flightDetailDataAccessObject,
                                  FlightDetailOutputBoundary flightDetailPresenter) {
        this.flightDetailDataAccessObject = flightDetailDataAccessObject;
        this.flightDetailPresenter = flightDetailPresenter;
    }

    @Override
    public void execute(FlightDetailInputData inputData) {
        System.out.println("[DEBUG] FlightDetailInteractor reached.");


        try {

            Flight flight = inputData.getFlight();

            if (flight == null) {
                flightDetailPresenter.prepareFailView("Error: Flight is null.");
                return;
            }

            // --- Call API or data source to get the full flight detail ---
            FlightDetail detail = flightDetailDataAccessObject.fetchDetail(flight);

            if (detail == null) {
                flightDetailPresenter.prepareFailView("Could not retrieve flight details.");
                return;
            }

            FlightDetailOutputData outputData = new FlightDetailOutputData(detail);
            flightDetailPresenter.prepareSuccessView(outputData);

        } catch (Exception e) {
            flightDetailPresenter.prepareFailView("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
