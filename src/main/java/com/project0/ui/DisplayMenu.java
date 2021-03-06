package com.project0.ui;
import com.project0.Dao.CarDOA;
import com.project0.Dao.UserDOA;
import com.project0.model.Cars;

import java.sql.SQLException;
import java.util.Scanner;



public class DisplayMenu extends AbstractMenu {

    UserDOA user = new UserDOA();
    String username = "";

    @Override
    public boolean Login(Scanner scan){
        System.out.println("Login Menu");
        System.out.println("Username: ");
        username = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();


        try {
            return user.LoginDOA(username, password);
        }catch(SQLException e ){
            e.printStackTrace();
        }
    return false;
    }

    public void EmployeeMenu(Scanner scan){

        boolean loop = true;
        CarDOA cars = new CarDOA();
        int carID;

        do{
        System.out.println("Hello :" + username + "!");
        System.out.println("What would you like to do: ");
        System.out.println("1: Add car");
        System.out.println("2: Remove car");
        System.out.println("3: View offers");
        System.out.println("4: View Payments");
        System.out.println("5: Exit");

        int choice = scan.nextInt();
        scan.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Add");
                    addCarMenu(scan);
                    //loop = false;
                    break;
                case 2:
                    System.out.println("Remove");
                    carID = scan.nextInt();
                    scan.nextLine();
                    cars.removeCarDOA(carID);
                    //loop = false;
                    break;
                case 3:
                    System.out.println("Offers");
                    //loop = false;
                    break;
                case 4:
                    System.out.println("Payments");
                    //loop = false;
                    break;
                case 5:
                    System.out.println("exit");
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong choice");


            }
        }while(loop);

    }

    public Cars addCarMenu(Scanner scan){
        System.out.println("Enter Car Info: ");
        System.out.println("OwnerID: ");
        int ownerID = scan.nextInt();
        scan.nextLine();
        System.out.println("Make: ");
        String make = scan.nextLine();
        System.out.println("Model: ");
        String model = scan.nextLine();
        System.out.println("Year");
        String year = scan.nextLine();
        System.out.println("Cost");
        double cost = scan.nextDouble();
        scan.nextLine();

        CarDOA carAdd = new CarDOA();
        carAdd.addCar(ownerID,make,model,year,cost);



        return null;
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
