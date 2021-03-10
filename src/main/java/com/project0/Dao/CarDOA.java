package com.project0.Dao;

import com.project0.Util.DansArrayList;

import com.project0.model.Cars;
import com.project0.Util.jdbcConnection;

import java.sql.*;

public class CarDOA {

    public DansArrayList<Cars> getAllCars(){

        String sqlQuery = "SELECT * FROM cars where ownerid = 100";

        DansArrayList<Cars> carsList = new DansArrayList<>();

        try(Connection connection = jdbcConnection.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()) {
                int carID = rs.getInt(1);
                int ownerID = rs.getInt(2);
                String make = rs.getString(3);
                String model = rs.getString(4);
                String year = rs.getString(5);
                double cost = rs.getDouble(6);
                double balance = rs.getDouble(7);

                Cars cars = new Cars(ownerID,carID, make, model, year, cost);
                carsList.add(cars);
            }
            for(int i = 0; i < carsList.size(); i++){
                //System.out.println(carsList.getCar(i).getMake() + " - " + carsList.getCar(i).getModel());
                System.out.println(carsList.getCar(i).toString());

            }

            return carsList;
            }catch(SQLException e){
                e.printStackTrace();
            }
        return carsList;
    }

    public Cars addCar(int ownerID, String make, String model, String year, double cost){

        String sqlQuery = "insert into cars (OwnerID, Make, Model, Year, cost, Balance)"
                + "values (?, ?, ?, ?, ?, ?)";

        try(Connection connection = jdbcConnection.getConnection()){
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setInt(1, ownerID);
            pstmt.setString(2, make);
            pstmt.setString(3, model);
            pstmt.setString(4, year);
            pstmt.setDouble(5, cost);
            pstmt.setDouble(6, cost);

            if (pstmt.executeUpdate() != 1) {
                throw new SQLException("Inserting Car failed, no rows were affected");
            }
            connection.commit();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Cars removeCarDOA(int carID) {
        try (Connection connection = jdbcConnection.getConnection()) {
            String sqlQuery = "DELETE FROM cars WHERE carid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, carID);

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Deleting failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;

    }

    public DansArrayList<Cars> viewOwnedCars(int ownerID){
        DansArrayList<Cars> carsList = new DansArrayList<>();
        String sqlQuery = "select make, model, year from cars where ownerid = ?";

        try(Connection  connection = jdbcConnection.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setInt(1, ownerID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                String make = rs.getString(1);
                String model = rs.getString(2);
                String year = rs.getString(3);

                Cars cars = new Cars( make, model, year);
                carsList.add(cars);
            }

            for(int i = 0; i < carsList.size(); i++){
                System.out.println(carsList.getCar(i).getMake() + " - " + carsList.getCar(i).getModel()
                        + " - " + carsList.getCar(i).getYear());


            }


        }catch(SQLException e){
            e.printStackTrace();
        }



        return null;
    }



}



