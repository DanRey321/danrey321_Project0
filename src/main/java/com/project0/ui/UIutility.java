package com.project0.ui;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import org.postgresql.Driver;


public class UIutility {

    public static Connection getConnection() throws SQLException{

        String url = "jdbc:postgresql://samplecar.csuhfolohico.us-west-1.rds.amazonaws.com:5432/postgres";
        String username = "danrey321";
        String password = "password";

        Connection connection = null;
        //Class.forName("org.postgresql.Driver");
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(url,username, password);


        return connection;
    }



    public  boolean yOrN(Scanner scan, String message){
        String answer = "";
        do{
            System.out.println(message + " y/n");
            answer = scan.nextLine();
            if(answer.equals("y")){
                return true;
            } else if(answer.equals("n")){
                return false;
            }
        } while(true);
    }

}
