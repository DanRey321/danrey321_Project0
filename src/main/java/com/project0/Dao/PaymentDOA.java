package com.project0.Dao;

import com.project0.Util.DansArrayList;
import com.project0.model.Offers;
import com.project0.model.Payments;
import com.project0.Util.jdbcConnection;

import java.sql.*;

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

    public Payments paymentUpdate(int userId, int carID, int months, double payment, double balance){

        int newMonth = months + 1;
        double newBalance = balance - payment;

        String sqlQuery = "update payments set monthsPaid = ?, remainingbalance = ?" +
                "where userid = ? and carid = ?";

        try(Connection connection = jdbcConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,newMonth);
            statement.setDouble(2, newBalance);
            statement.setInt(3, userId);
            statement.setInt(4,carID);



            if (statement.executeUpdate() < 1) {
                throw new SQLException("Insert Failed, no rows were affected");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Payments viewPayment(int userID){

        String sqlQuery = "select * from payments where userid = ?";

        try(Connection connection = jdbcConnection.getConnection()){

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, userID);
            //statement.setInt(1, carid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //int oID = rs.getInt(1);
                int carID = rs.getInt(2);
                double payment = rs.getDouble(3);
                double remainingBalance = rs.getDouble(4);
                int monthsPaid = rs.getInt(5);


                Payments payments = new Payments(userID, carID, payment, remainingBalance, monthsPaid);
                return payments;


            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }


}
