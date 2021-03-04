package com.project0.ui;
import com.project0.Dao.EmployeeDOA;
import com.project0.Dao.UserDOA;

import java.sql.SQLException;
import java.util.Scanner;



public class DisplayMenu extends AbstractMenu {

    @Override
    public boolean Login(Scanner scan){
        System.out.println("Login Menu");
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();

        UserDOA user = new UserDOA();
        try {
            return user.LoginDOA(username, password);
        }catch(SQLException e ){
            e.printStackTrace();
        }
    return false;
    }




    public void MainPage(){
        System.out.println("How can we help?");
        System.out.println("1: Look for cars");
        System.out.println("2: Make an offer");
        System.out.println("3: Employee Login");
    }

    public void ShowRoomPage(){
        System.out.println("Welcome to the Showroom!!");
        System.out.println("1: Display available cars ");
        System.out.println("Return to main Menu");
    }

    public void UserPage(){
        System.out.println("Sign/Signup");
        System.out.println("1: Sign In");
        System.out.println("2: Sign Up");
        System.out.println("3: Delete user");
        System.out.println("Return to main Menu");
    }

}
