package com.project0.Dao;

import com.project0.Util.CarArrayList;
import com.project0.model.Offers;
import com.project0.model.Cars;
import com.project0.ui.UIutility;

import java.sql.*;



public class FinanceDOA {

    /*
    public SimpleArrayList<Offers> ViewOffers(){

        String sqlQuery = "SELECT * FROM cars";

        SimpleArrayList<Offers> offerList = new SimpleArrayList<>();

        try(Connection connection = UIutility.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()) {
                int offerID = rs.getInt(1);
                int userid = rs.getInt(2);
                int carID = rs.getInt(3);
                double offer = rs.getDouble(4);



                //Cars cars = new Cars(carID, make, model, year, cost);
                T t = new T(offerID, userid, carID, offer);
                offerList.add(t);
            }
            for(int i = 0; i < offerList.size(); i++){
                System.out.println(offerList.get(i).getMake() + " - " + offerList.get(i).getModel());


            }

            return offerList;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return offerList;
    }

     */



}
