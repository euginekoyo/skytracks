package com.skytracks.skytracks.models;

public class Route {
    private String flightNumber;
    private String destination;
    private String origin;
    private String duration;
    private String aircraftType;
    private String pilot;

    // Constructor
    public Route(String flightNumber, String destination, String origin, String duration, String aircraftType, String pilot) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
        this.duration = duration;
        this.aircraftType = aircraftType;
        this.pilot = pilot;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDuration() {
        return duration;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getPilot() {
        return pilot;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }
}
