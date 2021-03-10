package com.project0.model;

public class Payments {
   private int userID;
   private int carID;
   private double payment;
   private double remainingBalance;
   private int monthsPaid;

    public Payments(int userID, int carID, double payment, double remainingBalance, int monthsPaid) {
        this.userID = userID;
        this.carID = carID;
        this.payment = payment;
        this.remainingBalance = remainingBalance;
        this.monthsPaid = monthsPaid;
    }

    public Payments() {
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

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public int getMonthsPaid() {
        return monthsPaid;
    }

    public void setMonthsPaid(int monthsPaid) {
        this.monthsPaid = monthsPaid;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "userID=" + userID +
                ", carID=" + carID +
                ", payment=" + payment +
                ", remainingBalance=" + remainingBalance +
                ", monthsPaid=" + monthsPaid +
                '}';
    }
}
