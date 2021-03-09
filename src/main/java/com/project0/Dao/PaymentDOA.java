package com.project0.Dao;

import com.project0.Util.DansArrayList;
import com.project0.model.Payments;
import com.project0.Util.jdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentDOA {

    public String createPaymentPlan(int userID, int carID){


        return null;
    }

    public Payments viewAllPayments(){

        String sqlQuery = "select * from payments";
        DansArrayList<Payments> paymentList = new DansArrayList<>();

        try(Connection connection = jdbcConnection.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()){
                int userID = rs.getInt(1);
                int carID = rs.getInt(2);
                double payment = rs.getDouble(3);
                double remaining = rs.getDouble(4);
                int month = rs.getInt(5);

                Payments payments = new Payments(userID, carID, payment, remaining, month);
                paymentList.addPayment(payments);
            }

            System.out.println("Payment ID ------------------Payment");
            for(int i = 0; i < paymentList.sizeOfPaymentList(); i++){
                System.out.println(paymentList.getPayment(i).getUserID() + " - "
                        + paymentList.getPayment(i).getPayment());

            }




        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public String viewCalculateMonthlyPayments(){


        return null;
    }


}
