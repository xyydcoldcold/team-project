package entity;

import java.util.List;

public class FlightDetail {

    /** Offer ID from Amadeus */
    public final String id;

    /** How many seats are bookable */
    public final int numberOfBookableSeats;

    /** Total price information */
    public final Price price;   // includes total, currency

    /** Fare option (e.g. STANDARD, BASIC, etc.) */
    public final String fareOption;

    /** All segments in this (one-way) journey */
    public final List<SegmentDetail> segments;

    /** Constructor */
    public FlightDetail(String id,
                        int numberOfBookableSeats,
                        Price price,
                        String fareOption,
                        List<SegmentDetail> segments) {
        this.id = id;
        this.numberOfBookableSeats = numberOfBookableSeats;
        this.price = price;
        this.fareOption = fareOption;
        this.segments = segments;
    }

    /* -------------------- SUB ENTITIES -------------------- */

    /**
     * Price entity (you already have something similar but we simplify)
     */
    public static class Price {
        public final double total;
        public final String currency;

        public Price(double total, String currency) {
            this.total = total;
            this.currency = currency;
        }
    }

    /**
     * Segment detail including baggage and amenities
     */
    public static class SegmentDetail {

        // Basic flight info
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

        // Fare-related info
        public final String cabinClass;     // ECONOMY
        public final Baggage baggage;       // checked + cabin
        public final List<Amenity> amenities; // list of 5 items

        public SegmentDetail(String depAirport, String depTime, String depTerminal,
                             String arrAirport, String arrTime, String arrTerminal,
                             String carrierCode, String flightNumber, String aircraft,
                             String duration, String cabinClass,
                             Baggage baggage, List<Amenity> amenities) {

            this.departureAirport = depAirport;
            this.departureTime = depTime;
            this.departureTerminal = depTerminal;

            this.arrivalAirport = arrAirport;
            this.arrivalTime = arrTime;
            this.arrivalTerminal = arrTerminal;

            this.carrierCode = carrierCode;
            this.flightNumber = flightNumber;
            this.aircraft = aircraft;
            this.duration = duration;

            this.cabinClass = cabinClass;
            this.baggage = baggage;
            this.amenities = amenities;
        }
    }

    /**
     * Baggage info (checked + cabin)
     */
    public static class Baggage {
        public final int checkedBags;
        public final int cabinBags;

        public Baggage(int checkedBags, int cabinBags) {
            this.checkedBags = checkedBags;
            this.cabinBags = cabinBags;
        }
    }

    /**
     * Amenity info
     */
    public static class Amenity {
        public final String description;      // e.g. "SECOND BAG"
        public final String amenityType;      // BAGGAGE / PRE_RESERVED_SEAT / etc.
        public final boolean isChargeable;    // true/false

        public Amenity(String description, String amenityType, boolean isChargeable) {
            this.description = description;
            this.amenityType = amenityType;
            this.isChargeable = isChargeable;
        }
    }
}


