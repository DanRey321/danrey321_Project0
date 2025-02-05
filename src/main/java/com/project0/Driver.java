package com.project0;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.project0.Test.UserTest;
import com.project0.model.User;
import com.project0.ui.DisplayMenu;
import com.project0.ui.signUpMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Driver {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        System.out.println("Welcome!!!!");
        Scanner scan = new Scanner(System.in);
        boolean menuLoop = true;
        int choice;
        User isUser = new User();
        DisplayMenu menu = new DisplayMenu();
        signUpMenu smenu = new signUpMenu();

        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");


        do{
            System.out.println("Select an option: ");
            System.out.println("1: Log In");
            System.out.println("2: Sign up");
            System.out.println("3: Run Test");
            System.out.println("4: Exit");

            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Logging in");
                    menuLoop = false;
                    isUser = menu.Login(scan);
                    if(isUser.getRole() == 1) {
                        System.out.println("You are sign in as an Employee ");
                        menu.EmployeeMenu(scan, isUser);
                    }
                    else if(isUser.getRole() >= 2){
                        System.out.println("You are sign in as a Customer");
                        menu.CustomerMenu(scan, isUser);
                    }else{
                        System.out.println("Not a user! ");
                    }
                    break;
                case 2:
                    System.out.println("Signing up");
                    smenu.signUp(scan);
                    //menuLoop = false;
                    break;
                case 3:
                    System.out.println("Test");
                    Result test = JUnitCore.runClasses(UserTest.class);
                    for (Failure failure : test.getFailures()) {
                        System.out.println(failure.toString());
                    }
                    //menu.Testclass();
                    menuLoop = false;
                    break;
                case 4:
                    System.out.println("Exit");
                    menuLoop = false;
                    break;
                default:
                    System.out.println("Wrong input");
            }

        }while(menuLoop);




        //CarDOA allCars = new CarDOA();
        //allCars.getAllCars();











/*
        System.out.println("Adding user Test");
        System.out.println("Add role: ");
        int role = scan.nextInt();
        scan.nextLine();
        System.out.println("First Name: ");
        String fName = scan.nextLine();
        System.out.println("Last Name: ");
        String lName = scan.nextLine();
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password; ");
        String password = scan.nextLine();

        System.out.println(role + " " +  fName + " " +  lName  + " " + username + " " + password);

        UserDOA exampleUser = new UserDOA();
        //exampleUser.AddUserDAO(role,fName,lName,username,password);
        //exampleUser.AddUserDAO(103,1,"Victor","Reyes","vic123", "pass");
        System.out.println("Check");
*/

       // System.out.println("Delete User with Username: ");
       // String name = scan.nextLine();
       // System.out.println(name);

        //UserDOA exampleUser1 = new UserDOA();
       //exampleUser1.deleteUserDAO(name);


        /*
        do{
            System.out.println("How can we help?");
            System.out.println("1: Look for cars");
            System.out.println("2: Make an offer");
            System.out.println("3: Employee Login");

            int answer = scan.nextInt();
            switch(answer){
                case 1:
                    System.out.println("Car Menu");
                    menuLoop = false;
                    break;
                case 2:
                    System.out.println("Offer Menu");
                    menuLoop = false;
                    break;
                case 3:
                    System.out.println("Login Menu");
                    menuLoop = false;
                    break;
                default:
                    System.out.println("Wrong input...");
            }

        }while(menuLoop);

        */

    }
}
