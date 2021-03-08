package com.project0.model;

public class Payments {
    private int paymentID;
    private int userID;
    private int carID;
    private double payment;

    public Payments() {
    }

    public Payments(int paymentID, int userID, int carID, double payment) {
        this.paymentID = paymentID;
        this.userID = userID;
        this.carID = carID;
        this.payment = payment;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
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

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
