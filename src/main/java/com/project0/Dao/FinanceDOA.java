package com.project0.Dao;

import com.project0.Util.DansArrayList;
import com.project0.model.Offers;
import com.project0.Util.jdbcConnection;
import com.project0.model.Payments;

import java.sql.*;



public class FinanceDOA {


    public DansArrayList<Offers> ViewOffers(){

        String sqlQuery = "SELECT * FROM offers";

        DansArrayList<Offers> offerList = new DansArrayList<>();

        try(Connection connection = jdbcConnection.getConnection()){
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

        try (Connection connection = jdbcConnection.getConnection()) {
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




    public Offers declineOffer(int offerID){

        String sqlQuery = "delete from offers where offerid = ?";


        try(Connection connection = jdbcConnection.getConnection()){

            PreparedStatement stmt = connection.prepareStatement(sqlQuery);

            stmt.setInt(1, offerID );

            if(stmt.executeUpdate() < 1){
                throw new SQLException("Deleting Offer failed");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateOwner(int ownerID, int carID){
        System.out.println(ownerID + "Owner and car " + carID);
        String sqlQuery = "update cars set ownerid = ?"
                + "where carid = ? ";

        try(Connection connection = jdbcConnection.getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement pstmt= connection.prepareStatement(sqlQuery);

            pstmt.setInt(1, ownerID);
            pstmt.setInt(2, carID);

            if (pstmt.executeUpdate() != 1) {
                throw new SQLException("Update Owner failed, no rows were affected");
            }

            connection.commit();

        }catch(SQLException e){
            e.printStackTrace();
        }



    }

    public Offers updateOfferStatus(int offerID){
        String sqlQuery = "update offers set status = 'Accepted'" +
                "where offerid = ? ";

        try(Connection connection = jdbcConnection.getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);

            pstmt.setInt(1, offerID);

            if (pstmt.executeUpdate() != 1) {
                throw new SQLException("Update Status failed, no rows were affected");
            }

            connection.commit();

        }catch(SQLException e){
            e.printStackTrace();
        }


        return null;
    }

    public Offers deleteRemainingOffers(int carID){

        System.out.println(carID);
        String sqlQuery = "delete from offers where carid = ? and status = 'Pending'";

        try(Connection connection = jdbcConnection.getConnection()){
            //connection.setAutoCommit(false);

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);

            pstmt.setInt(1, carID);

            if (pstmt.executeUpdate() < 1) {
                throw new SQLException("Deleting Other Offers failed, no rows were affected");
            }

            //connection.commit();

        }catch(SQLException e){
            e.printStackTrace();
        }


        return null;
    }


    public Offers getOffer(int offerID){
        String sqlQuery = "select * from offers where offerid = ? ";


        try (Connection connection = jdbcConnection.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, offerID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int oID = rs.getInt(1);
                int userID = rs.getInt(2);
                int carID = rs.getInt(3);
                double offerAmount = rs.getDouble(4);

                System.out.println(oID);
                System.out.println(userID);

                Offers offer = new Offers(oID, userID, carID, offerAmount);
                return offer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Payments createPlan(int ownerID, int carID, double Balance){


        double payment;
        int monthsPaid = 1;

        payment = Balance / 12;

        System.out.println(ownerID + " " + carID + payment + " " + (Balance - payment) + " " + monthsPaid);

        String sqlQuery = "insert into payments (userid, carid, payment, remainingBalance, monthsPaid ) " +
                "values (?, ?, ?, ?, ?)";

        try(Connection connection = jdbcConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,ownerID);
            statement.setInt(2, carID);
            statement.setDouble(3, payment);
            statement.setDouble(4, (Balance - payment));
            statement.setInt(5, monthsPaid);

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Insert Failed, no rows were affected");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }









}
