package data_transfer_objects;

import java.util.List;

public class FlightDetailDataTransferObject {

    public final String id;
    public final int numberOfBookableSeats;
    public final PriceDTO price;
    public final String fareOption;
    public final List<SegmentDTO> segments;

    public FlightDetailDataTransferObject(
            String id,
            int numberOfBookableSeats,
            PriceDTO price,
            String fareOption,
            List<SegmentDTO> segments
    ) {
        this.id = id;
        this.numberOfBookableSeats = numberOfBookableSeats;
        this.price = price;
        this.fareOption = fareOption;
        this.segments = segments;
    }

    /* -------------------- SUB-DTOs -------------------- */

    public static class PriceDTO {
        public final double total;
        public final String currency;

        public PriceDTO(double total, String currency) {
            this.total = total;
            this.currency = currency;
        }
    }

    public static class SegmentDTO {

        public final String departureAirport;
        public final String departureTime;
        public final String departureTerminal;

        public final String arrivalAirport;
        public final String arrivalTime;
        public final String arrivalTerminal;

        public final String carrierCode;
        public final String flightNumber;
        public final String aircraft;
        public final String duration;

        public final String cabinClass;
        public final BaggageDTO baggage;
        public final List<AmenityDTO> amenities;

        public SegmentDTO(String departureAirport, String departureTime, String departureTerminal,
                          String arrivalAirport, String arrivalTime, String arrivalTerminal,
                          String carrierCode, String flightNumber, String aircraft,
                          String duration, String cabinClass,
                          BaggageDTO baggage, List<AmenityDTO> amenities) {

            this.departureAirport = departureAirport;
            this.departureTime = departureTime;
            this.departureTerminal = departureTerminal;

            this.arrivalAirport = arrivalAirport;
            this.arrivalTime = arrivalTime;
            this.arrivalTerminal = arrivalTerminal;

            this.carrierCode = carrierCode;
            this.flightNumber = flightNumber;
            this.aircraft = aircraft;
            this.duration = duration;

            this.cabinClass = cabinClass;
            this.baggage = baggage;
            this.amenities = amenities;
        }
    }

    public static class BaggageDTO {
        public final int checkedBags;
        public final int cabinBags;

        public BaggageDTO(int checkedBags, int cabinBags) {
            this.checkedBags = checkedBags;
            this.cabinBags = cabinBags;
        }
    }

    public static class AmenityDTO {
        public final String description;
        public final String amenityType;
        public final boolean isChargeable;

        public AmenityDTO(String description, String amenityType, boolean isChargeable) {
            this.description = description;
            this.amenityType = amenityType;
            this.isChargeable = isChargeable;
        }
    }
}
