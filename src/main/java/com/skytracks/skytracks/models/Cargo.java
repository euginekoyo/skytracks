package com.skytracks.skytracks.models;
public class Cargo {
    private String cargoID;
    private String flightNumber;
    private String nature;
    private double weight;

    // Constructor
    public Cargo(String cargoID, String flightNumber, String nature, double weight) {
        this.cargoID = cargoID;
        this.flightNumber = flightNumber;
        this.nature = nature;
        this.weight = weight;
    }

    // Getters
    public String getCargoID() {
        return cargoID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getNature() {
        return nature;
    }

    public double getWeight() {
        return weight;
    }

    // Setters
    public void setCargoID(String cargoID) {
        this.cargoID = cargoID;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
