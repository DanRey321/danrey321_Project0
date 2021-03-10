package com.project0.model;

public class Cars {

    private int carID;
    private String make;
    private String model;
    private String year;
    private double cost;

    public Cars(int carID, String make, String model, String year, double cost) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.cost = cost;

    }

    public Cars() {
        this.carID = carID;
        this.cost = 0;

    }

    public Cars(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }


    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Cars{" +
                "carID= " + carID +
                ", make=' " + make + '\'' +
                ", model=' " + model + '\'' +
                ", year=' " + year + '\'' +
                ", cost= " + cost +
                '}';
    }
}
