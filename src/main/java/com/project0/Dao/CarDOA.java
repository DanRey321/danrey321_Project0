package com.project0.Dao;

import com.project0.Util.CarArrayList;

import com.project0.model.Cars;
import com.project0.ui.UIutility;

import java.sql.*;

public class CarDOA {

    public CarArrayList<Cars> getAllCars(){

        String sqlQuery = "SELECT * FROM cars";

        CarArrayList<Cars> carsList = new CarArrayList<>();

        try(Connection connection = UIutility.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()) {
               int carID = rs.getInt(1);
                String make = rs.getString(2);
                String model = rs.getString(3);
                int year = rs.getInt(4);
                double cost = rs.getDouble(5);

                Cars cars = new Cars(carID, make, model, year, cost);
                carsList.add(cars);
            }
            for(int i = 0; i < carsList.size(); i++){
                System.out.println(carsList.get(i).getMake() + " - " + carsList.get(i).getModel());


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

        try(Connection connection = UIutility.getConnection()){
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

    public boolean removeCarDOA(int carID) {
        try (Connection connection = UIutility.getConnection()) {
            String sqlQuery = "DELETE FROM cars WHERE carid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, carID);

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Deleting failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

}



