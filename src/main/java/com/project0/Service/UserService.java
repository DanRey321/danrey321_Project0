package com.project0.Service;

import com.project0.Dao.CarDOA;
import com.project0.Dao.UserDOA;
import com.project0.Util.DansArrayList;
import com.project0.model.User;

import java.sql.SQLException;

public class UserService {

    private UserDOA userDOA;
    private CarDOA carDOA;

    public UserService(){
        this.carDOA = new CarDOA();
        this.userDOA = new UserDOA();
    }

    public UserService(UserDOA userDOA, CarDOA carDOA){
        this.userDOA = userDOA;
        this.carDOA = carDOA;
    }

    public DansArrayList<User> getUsers(){
        //return userDOA.

        return null;
    }

    public User addUser(User user){

        return userDOA.AddUserDAO(user.getRole(), user.getFirstName(),
                user.getLastName(), user.getUsername(), user.getPassword());

    }


    public User deleteUser(String name){

        return userDOA.deleteUserDAO(name);

    }

    public User Login(String username, String password) throws SQLException {

        return userDOA.LoginDOA(username, password);

    }








}
