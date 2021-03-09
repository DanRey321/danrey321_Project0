package com.project0.ui;

import com.project0.Dao.UserDOA;
import com.project0.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class signUpMenu {
    UserDOA addUser = new UserDOA();


    public User signUp(Scanner scan){

        System.out.println("Enter First Name: ");
        String fName = scan.nextLine();
        System.out.println("Enter Last Name: ");
        String lName = scan.nextLine();
        System.out.println("Enter Username: ");
        String Username = scan.nextLine();
        System.out.println("Enter Password: ");
        String password = scan.nextLine();

        addUser.AddUserDAO(2, fName, lName, Username, password);

        //User user = new User();
        //return user;


        return null;
    }
}
