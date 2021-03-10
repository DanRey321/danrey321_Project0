package com.project0.Service;

import com.project0.Dao.CarDOA;
import com.project0.Dao.UserDOA;
import com.project0.Util.DansArrayList;
import com.project0.model.Cars;

public class CarService {
    private CarDOA carDOA;
    private UserDOA userDOA;

    public CarService() {
        this.carDOA = new CarDOA();
        this.userDOA = new UserDOA();
    }

    public CarService(CarDOA carDOA, UserDOA userDOA) {
        this.carDOA = carDOA;
        this.userDOA = userDOA;
    }

    public DansArrayList<Cars> getCars(){
        //carDOA.
        return carDOA.getAllCars();
    }

    public Cars addCar(Cars cars){

        return carDOA.addCar(cars.getUserID(),cars.getMake(),
                cars.getModel(), cars.getYear(), cars.getCost());


    }

    public Cars deleteCar(int carID){

        return carDOA.removeCarDOA(carID);
    }

    public DansArrayList<Cars> getOwnedCars(int ownerID){

        return carDOA.viewOwnedCars(ownerID);
    }


}
