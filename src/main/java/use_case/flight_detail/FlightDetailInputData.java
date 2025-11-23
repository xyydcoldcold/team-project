package use_case.flight_detail;

import entity.Flight;

public class FlightDetailInputData {

    private final Flight flight;

    public FlightDetailInputData(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }
}

