package com.skytracks.skytracks.models;

public class Flight {

    int  cost;
    String flightNumber, destination, departure, flightTime, planeType, status;

    public Flight(String flightNumber, String destination, String departure, String flightTime, int cost, String planeType, String status){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.flightTime = flightTime;
        this.cost = cost;
        this.planeType = planeType;
        this.status = status;

    }

    public String getDestination(){
        return destination;
    }
    public String getDeparture(){
        return departure;
    }
    public String getFlightTime(){
        return flightTime;
    }
    public String getPlaneType(){
        return planeType;
    }
    public String getStatus(){
       return status;
    }

    public int getCost() {
        return cost;
    }

    public String getFlightNumber(){
        return flightNumber;
    }

}
