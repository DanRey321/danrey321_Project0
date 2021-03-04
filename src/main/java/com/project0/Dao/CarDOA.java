package com.project0.Dao;

import com.project0.Util.CarArrayList;

import com.project0.model.Cars;
import com.project0.ui.UIutility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}



