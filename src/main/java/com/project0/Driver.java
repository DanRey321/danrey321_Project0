package com.project0;

import com.project0.Dao.CarDOA;
import com.project0.Dao.UserDOA;
import com.project0.ui.DisplayMenu;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        System.out.println("Welcome!!!!");
        Scanner scan = new Scanner(System.in);
        boolean menuLoop = true;
        int choice;
        boolean isUser = false;
        DisplayMenu menu = new DisplayMenu();

        do{
            System.out.println("Select an option: ");
            System.out.println("1: Log In");
            System.out.println("2: Sign up");
            System.out.println("3: Exit");

            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Logging in");
                    menuLoop = false;
                    isUser = menu.Login(scan);
                    break;
                case 2:
                    System.out.println("Signing up");
                    menuLoop = false;
                    break;
                case 3:
                    System.out.println("Come again");
                    menuLoop = false;
                    break;
                default:
                    System.out.println("Wrong input");
            }

        }while(menuLoop);

        System.out.println("User sign in: " + isUser);

        CarDOA allCars = new CarDOA();
        allCars.getAllCars();










    /*

        System.out.println("Adding user Test");
        System.out.println("Add user ID: ");
        int userid = scan.nextInt();
        System.out.println("Add role: ");
        int role = scan.nextInt();
        System.out.println("First Name: ");
        String fName = scan.nextLine();
        System.out.println("Last Name: ");
        String lName = scan.nextLine();
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password; ");
        String password = scan.nextLine();

        UserDOA exampleUser = new UserDOA();
        exampleUser.AddUserDAO(userid,role,fName,lName,username,password);
        //exampleUser.AddUserDAO(103,1,"Victor","Reyes","vic123", "pass");
        System.out.println("Check");
        /*

        System.out.println("Delete User with Username: ");
        String name = scan.nextLine();
        System.out.println(name);

        UserDOA exampleUser = new UserDOA();
        exampleUser.deleteUserDAO(name);

         */
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
