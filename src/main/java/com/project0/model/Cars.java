package com.project0.model;

public class Cars {

    private int carID;
    private String make;
    private String model;
    private int year;
    private double cost;
    //private double balance;

    public Cars(int carID, String make, String model, int year, double cost) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.cost = cost;
        //this.balance = balance;
    }

    public Cars() {
        this.carID = carID;
        //this.balance = 0;
        this.cost = 0;

    }

    public Cars(String model) {
        this.model = model;
    }

    public Cars(int year) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }





}
