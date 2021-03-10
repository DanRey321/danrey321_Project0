package com.project0.ui;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;
import com.project0.Dao.CarDOA;
import com.project0.Dao.FinanceDOA;
import com.project0.Dao.PaymentDOA;
import com.project0.Dao.UserDOA;
import com.project0.Service.CarService;
import com.project0.Service.OfferService;
import com.project0.Service.PaymentService;
import com.project0.Service.UserService;
import com.project0.model.Cars;
import com.project0.model.Offers;
import com.project0.model.Payments;
import com.project0.model.User;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Scanner;


@TestClass
public class DisplayMenu extends AbstractMenu {


    private UserService userService;
    private PaymentService paymentService;
    private OfferService offerService;
    private CarService carService;

    public DisplayMenu(){
        this.userService = new UserService();
        this.paymentService = new PaymentService();
        this.offerService = new OfferService();
        this.carService = new CarService();

    }

    public DisplayMenu(UserService userService,PaymentService paymentService, OfferService offerService, CarService carService){
        this.userService = userService;
        this.paymentService = paymentService;
        this.offerService = offerService;
        this.carService = carService;
    }

    UserDOA user = new UserDOA();
    FinanceDOA offers = new FinanceDOA();
    String username = "";

    @Override
    public User Login(Scanner scan){
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
    return null;
    }

    public void EmployeeMenu(Scanner scan, User userEM){

        boolean loop = true;
        CarDOA cars = new CarDOA();
        PaymentDOA paymentDOA = new PaymentDOA();
        FinanceDOA offers = new FinanceDOA();
        int carID;

        do{
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Hello :" + username + "!");
            System.out.println("What would you like to do: ");
            System.out.println("1: Add car");
            System.out.println("2: Remove car");
            System.out.println("3: View offers");
            System.out.println("4: View Payments");
            System.out.println("5: Accept or Decline Offers");
            System.out.println("6: Exit");
            System.out.println(" ");
            System.out.println(" ");

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
                        carService.deleteCar(carID);
                        //cars.removeCarDOA(carID);
                        //loop = false;
                        break;
                    case 3:
                        System.out.println("Offers");
                        offerService.getAllOffers();
                        //offers.ViewOffers();
                        //loop = false;
                        break;
                    case 4:
                        System.out.println("Payments");
                        paymentService.getPayments();
                        //paymentDOA.viewAllPayments();
                        break;
                    case 5:
                        System.out.println("Accept or Decline Offers");
                        offerService.getAllOffers();
                        //offers.ViewOffers();
                        acceptOfferMenu(scan, userEM);
                        break;
                    case 6:
                        System.out.println("Exit");
                        //System.out.println("exit");
                        offers.getOffer(10027);
                        //System.out.println();
                        loop = false;
                        break;
                    default:
                        System.out.println("Wrong choice");


            }
        }while(loop);

    }

    public void CustomerMenu(Scanner scan, User userCM){

        boolean loop = true;
        CarDOA cars = new CarDOA();

        int carID;

        do{
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Hello :" + username + "!");
            System.out.println("What would you like to do: ");
            System.out.println("1: View Cars");
            System.out.println("2: Make an Offer");
            System.out.println("3: My Cars");
            System.out.println("4: Pay Balance");
            System.out.println("5: Exit");
            System.out.println(" ");
            System.out.println(" ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Car Selection");
                    carService.getCars();
                    //cars.getAllCars();
                    //loop = false;
                    break;
                case 2:
                    System.out.println("Offer");
                    makeOfferMenu(scan, userCM);
                    //loop = false;
                    break;
                case 3:
                    System.out.println("My Cars");
                    carService.getOwnedCars(userCM.getUserID());
                    // cars.viewOwnedCars(userCM.getUserID());
                    //loop = false;
                    break;
                case 4:
                    System.out.println("Paying Monthly Balance: ");
                    Payments paymentsView = paymentService.viewPayment(userCM.getUserID());
                    paymentService.paymentUpdate(paymentsView.getUserID(), paymentsView.getCarID(),
                            paymentsView.getMonthsPaid(),paymentsView.getPayment() ,paymentsView.getRemainingBalance());
                    //paymentDOA.paymentUpdate(paymentsView.getUserID(), paymentsView.getCarID(),
                            //paymentsView.getMonthsPaid(),paymentsView.getPayment() ,paymentsView.getRemainingBalance());
                    paymentService.viewPayment(paymentsView.getUserID());
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
        System.out.println(" ");
        System.out.println(" ");
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
        System.out.println(" ");
        System.out.println(" ");

        CarDOA carAdd = new CarDOA();
        carAdd.addCar(ownerID,make,model,year,cost);



        return null;
    }

    public Offers makeOfferMenu(Scanner scan, User userOM){

        //System.out.println("User ID:  ->  " + userOM.getUserID());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Make Offer: ");
        System.out.println("");
        System.out.println("Enter car ID:");
        int carId = scan.nextInt();
        scan.nextLine();
        System.out.println("Make Offer: ");
        double offerAmount = scan.nextDouble();
        scan.nextLine();
        System.out.println(" ");
        System.out.println(" ");


        System.out.println("UserID:  ->  " + userOM.getUserID());
        offerService.makeOffer(userOM.getUserID(), carId, offerAmount );
        //FinanceDOA offer = new FinanceDOA();
        //offer.makeOfferDOA(userOM.getUserID(), carId, offerAmount );


        return null;
    }

    public void acceptOfferMenu(Scanner scan, User userO){
        int offerID;
        Offers offerA;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("[A]ccept or [D]ecline Offer?");
        String AorD = scan.nextLine();
        if(AorD.equals("a") || AorD.equals("A")){
            System.out.println("Enter Offer ID");
            offerID = scan.nextInt();
            scan.nextLine();
            offerA = offers.getOffer(offerID);

            offerService.updateOfferStatus(offerID);
            offerService.updateOwnerService(offerA.getUserID(), offerA.getCarID());
            offerService.deleteOffers(offerA.getCarID());
            offerService.createPlanService(offerA.getUserID(),offerA.getCarID(),offerA.getOffer());

            /*
            offers.updateOfferStatus2(offerID);
            //offers.updateOfferStatus(offerID);
            offers.updateOwner(offerA.getUserID(), offerA.getCarID());
            offers.deleteRemainingOffers(offerA.getCarID());
            offers.createPlan(offerA.getUserID(),offerA.getCarID(),offerA.getOffer());

             */

        }
        else if(AorD.equals("d") || AorD.equals("D")){
            System.out.println("Enter Offer ID");
            offerID = scan.nextInt();
            offerService.declineOffer(offerID);
            //offers.declineOffer(offerID);
        }


    }

    public Payments viewPayment(User UserP){

        //Payments paymentsView = paymentDOA.viewPayment(UserP.getUserID());
        Payments paymentsView = paymentService.viewPayment(UserP.getUserID());

        return paymentsView;


    }

   //@TestMethod(name = "test1",expected = "Daniel")
    public void Testclass(){
        HashMap<Method, MetaTestData> resultmap = null;
        try {
            resultmap = new TestDiscovery().runAndStoreTestInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultmap);
        //System.out.println("Enter UserID");
        //int userID = scan.nextInt();
        //return "Daniel";


    }


}
