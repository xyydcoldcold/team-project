package interface_adapter.save_flight;

import use_case.save_flight.SaveFlightInputBoundary;
import use_case.save_flight.SaveFlightInputData;
//import entity.FlightDetail;
import data_transfer_objects.FlightDetailDataTransferObject;

public class SaveFlightController {
    private final SaveFlightInputBoundary saveFlightinteractor;

    public SaveFlightController(SaveFlightInputBoundary interactor) {
        this.saveFlightinteractor = interactor;
    }

    public void handleSaveButton(FlightDetailDataTransferObject detail) {
        // This method is called from the Swing action listener, pass the FlightDetail
        saveFlightinteractor.execute(new SaveFlightInputData(detail));
    }
}
