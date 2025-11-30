package interface_adapter.flight_detail;

//import entity.FlightDetail;
import data_transfer_objects.FlightDetailDataTransferObject;
import use_case.flight_detail.FlightDetailOutputData;

import java.util.List;

public class FlightDetailState {

    private FlightDetailDataTransferObject flightDetail;
    private String errorMessage = null;

    public FlightDetailState(FlightDetailState state) {
        this.flightDetail = state.flightDetail;
        this.errorMessage = state.errorMessage;
    }

    public FlightDetailState(){}

    public FlightDetailDataTransferObject getFlightDetail() { return flightDetail;}
    public void setFlightDetail(FlightDetailDataTransferObject flightDetail) { this.flightDetail = flightDetail; }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

}

