package com.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project0.model.User;
import com.project0.ui.UIutility;


public class UserDOA {

    public boolean deleteUserDAO(String Name){
        try(Connection connection = UIutility.getConnection()){
            String sqlQuery = "DELETE FROM Users WHERE UserName = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1,Name);
            if(statement.executeUpdate() < 1) {
                throw new SQLException("Deleting Failed, no rows affected");
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean AddUserDAO(int userID, int role, String firstName, String lastName, String username, String password){

        try (Connection connection = UIutility.getConnection()) {
            connection.setAutoCommit(false);

            String sqlQuery = "INSERT INTO users "
                    + "VALUES "
                    + "(?, ?, ?, ? ,? ,?)";

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, userID);
            pstmt.setInt(2, role );
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, username);
            pstmt.setString(6, password);

            if (pstmt.executeUpdate() != 1) {
                throw new SQLException("Inserting Employee failed, no rows were affected");
            }

            int autoId = 0;
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                autoId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Inserting Employee failed, no ID generated");
            }

            connection.commit();

            //return new Employee(autoId, EmployeeName, role.getId() );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean LoginDOA(String username, String password) throws SQLException{
        Connection connection = UIutility.getConnection();
        String sqlQuery = "SELECT password FROM users where username = ?";

        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1,username);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String databasePassword = rs.getString(1);
            if(databasePassword.equals(password)){
                return true;
            }
        }
        return false;

    }



}
