package interface_adapter.flight_detail;

import entity.FlightDetail;
import use_case.flight_detail.FlightDetailOutputData;

import java.util.List;

public class FlightDetailState {

    private FlightDetail flightDetail;
    private String errorMessage = null;

    public FlightDetailState(FlightDetailState state) {
        this.flightDetail = state.flightDetail;
        this.errorMessage = state.errorMessage;
    }

    public FlightDetailState(){}

    public FlightDetail getFlightDetail() { return flightDetail;}
    public void setFlightDetail(FlightDetail flightDetail) { this.flightDetail = flightDetail; }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

}

