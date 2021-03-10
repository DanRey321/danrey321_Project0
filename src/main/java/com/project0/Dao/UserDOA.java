package com.project0.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.project0.model.User;
import com.project0.Util.jdbcConnection;

@TestClass
public class UserDOA {

    public User deleteUserDAO(String Name){
        try(Connection connection = jdbcConnection.getConnection()){
            String sqlQuery = "DELETE FROM users WHERE UserName = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1,Name);
            if(statement.executeUpdate() < 1) {
                throw new SQLException("Deleting Failed, no rows affected");
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public User AddUserDAO(int role, String firstName, String lastName, String username, String password){

        try (Connection connection = jdbcConnection.getConnection()) {
            connection.setAutoCommit(false);

            String sqlQuery = "INSERT INTO users (roleID, FName, LName, UserName, password) "
                    + "VALUES "
                    + "(?, ?, ?, ? ,? )";

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, role );
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, username);
            pstmt.setString(5, password);

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

        return null;
    }

    public User LoginDOA(String username, String password) throws SQLException{
        Connection connection = jdbcConnection.getConnection();
        String sqlQuery = "SELECT password, roleid, userid FROM users where username = ?";

        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1,username);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String databasePassword = rs.getString(1);
            int roleID = rs.getInt(2);
            int userid = rs.getInt(3);

            User user = new User(userid, roleID, databasePassword, username);


            if(databasePassword.equals(password)){
                if(roleID == 1){
                    return user; //Returns Employee
                } else if(roleID > 1){
                    return user; //Returns Customer
                }
            }else{
                System.out.println("Not a user");

            }
        }
        return null;

    }


    @TestMethod(name = "test1",expected = "Daniel")
    public String testUserName(){

        String sqlQuery = "Select fname from users where userid = 100";
        String name = null;

        try(Connection connection = jdbcConnection.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            //pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                name = rs.getString(1);
            }



        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println(name);
        return name;
    }



}
