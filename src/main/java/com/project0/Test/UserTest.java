package com.project0.Test;
import com.project0.Dao.CarDOA;
import com.project0.Dao.PaymentDOA;
import com.project0.Dao.UserDOA;
import com.project0.Service.UserService;
import com.project0.model.Cars;
import com.project0.model.Payments;
import com.project0.model.User;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserTest {

    private User user;
    private UserDOA userDOA = new UserDOA();
    private Payments payments;
    private PaymentDOA paymentDOA;
    private Cars cars;
    private CarDOA carDOA;
    private static final Logger logger = LogManager.getLogger(UserTest.class);



    @Test
    public void test(){

        User user = new User(100, 1, "danrey321", "passwords");
        Assert.assertEquals("String Test: ", "danreey321", user.getUsername() );
    }


    @Test
    public void test1(){
        User user = new User(100, 1, "danrey321", "passwords");
        Assert.assertEquals("String Test: ", "danrey321", user.getUsername() );
    }

    @Test
    public void test2(){
        User user = new User(100, 1, "danrey321", "passwordsla");
        Assert.assertSame( userDOA.testUserName1(), user);
    }

    @Test
    public void test3(){
        //System.out.println(userDOA.testUserName1().toString());
        User user = new User(100, 1, "danrey321", "password");
        Assert.assertSame( userDOA.testUserName1(), user);
    }

    @Test
    public void test4(){
        //UserDOA userDOA1 = new UserDOA();
        //UserService userService = new UserService();

    }

}
