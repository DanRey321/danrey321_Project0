package com.project0.model;

public class Offers {

    private int offerID;
    private int userID;
    private int carID;
    private double offer;
    private String status;

    public Offers() {
    }

    public Offers(int offerID, int userID, int carID, double offer, String status) {
        this.offerID = offerID;
        this.userID = userID;
        this.carID = carID;
        this.offer = offer;
        this.status = status;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "     offerID= " + offerID +
                ",   userID= " + userID +
                ",   carID= " + carID +
                ",   offer= " + offer +
                ",   status= " + status;
    }
}
