package com.project0.Service;

import com.project0.Dao.CarDOA;
import com.project0.Dao.PaymentDOA;
import com.project0.Dao.UserDOA;
import com.project0.Util.DansArrayList;
import com.project0.model.Cars;
import com.project0.model.Payments;

public class PaymentService {

    private PaymentDOA paymentDOA;
    private UserDOA userDOA;

    public PaymentService() {
        this.paymentDOA = new PaymentDOA();
        this.userDOA = new UserDOA();
    }

    public PaymentService(PaymentDOA paymentDOA, UserDOA userDOA) {
        this.paymentDOA = paymentDOA;
        this.userDOA = userDOA;
    }

    public DansArrayList<Payments> getPayments(){
       // paymentDOA.viewPayment();
        //paymentDOA.createPaymentPlan();
       // paymentDOA.paymentUpdate();

        return paymentDOA.viewAllPayments();
    }

    public Payments viewPayment(int userID){
        return paymentDOA.viewPayment(userID);
    }

    public Payments createPlan(){
        return null;
    }

    public Payments paymentUpdate(int userID, int carID, int months, double payment, double balance){
        return paymentDOA.paymentUpdate(userID, carID, months, payment,balance);
    }



}


