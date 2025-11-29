package use_case.save_flight;

//import entity.FlightDetail;
import data_transfer_objects.FlightDetailDataTransferObject;

/**
 * The input data for the Save Flight Use Case.
 */
public class SaveFlightInputData {

    private final FlightDetailDataTransferObject flight;

    public SaveFlightInputData(FlightDetailDataTransferObject flight) {
        this.flight = flight;
    }

    public FlightDetailDataTransferObject getFlightDetail() {
        return flight;
    }

    public String getFlightId() {
        return flight == null ? null : flight.id;
    }
}
