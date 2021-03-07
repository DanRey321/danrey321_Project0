package com.project0.Dao;

import com.project0.Util.CarArrayList;
import com.project0.model.Offers;
import com.project0.model.Cars;
import com.project0.ui.UIutility;

import java.sql.*;



public class FinanceDOA {


    public CarArrayList<Offers> ViewOffers(){

        String sqlQuery = "SELECT * FROM offers";

        CarArrayList<Offers> offerList = new CarArrayList<>();

        try(Connection connection = UIutility.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()) {
                int offerID = rs.getInt(1);
                int userid = rs.getInt(2);
                int carID = rs.getInt(3);
                double offer = rs.getDouble(4);

                Offers offers = new Offers(offerID, userid, carID, offer);
                offerList.addOffer(offers);
                //arsList.add(cars);

            }
            for(int i = 0; i < offerList.sizeOfOfferList(); i++){
                System.out.println(offerList.getOffer(i).getOfferID() + " - " + offerList.getOffer(i).getCarID() + " - "
                        + offerList.getOffer(i).getOffer() );


            }

            return offerList;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return offerList;
    }

    public boolean makeOfferDOA( int userID, int carID, double offer){

        try (Connection connection = UIutility.getConnection()) {
            connection.setAutoCommit(false);

            String sqlQuery = "insert into offers (userID, CarID, Offer)"
                    + "VALUES "
                    + "(?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, userID );
            pstmt.setInt(2, carID);
            pstmt.setDouble(3, offer);


            if (pstmt.executeUpdate() != 1) {
                throw new SQLException("Inserting User failed, no rows were affected");
            }

            int autoId = 0;
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                autoId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Inserting User failed, no ID generated");
            }

            connection.commit();

            //return new Employee(autoId, EmployeeName, role.getId() );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }





}
