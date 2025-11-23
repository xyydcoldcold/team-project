package use_case.flight_detail;

import entity.FlightDetail;

public class FlightDetailOutputData {
    private final FlightDetail flightDetail;
    public FlightDetailOutputData(FlightDetail flightDetail) {
        this.flightDetail = flightDetail;
    }

    public FlightDetail getFlightDetail() {
        return flightDetail;
    }
}

