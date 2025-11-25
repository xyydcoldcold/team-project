package entity;

import api_access.AmadeusRawObject;

/**
 * Entity representing the Flight Search Information
 */

public class FlightSearchInformation {

    private final String from;
    private final String to;
    private final int day;
    private final String month;
    private final int year;
    private final String dateOfSearch;
    private final String timeOfSearch;

    public FlightSearchInformation(String from, String to, int day, String month, int year, String date, String time) {
        this.from = from;
        this.to = to;
        this.day = day;
        this.month = month;
        this.year = year;
        this.dateOfSearch = date;
        this.timeOfSearch = time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDateOfSearch() {return dateOfSearch;}

    public String getTimeOfSearch() {return timeOfSearch;}

    @Override
    public String toString() {
        return "FlightSearchInformation{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", day=" + day +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", dateOfSearch='" + dateOfSearch + '\'' +
                ", timeOfSearch='" + timeOfSearch + '\'' +
                '}';
    }
}
