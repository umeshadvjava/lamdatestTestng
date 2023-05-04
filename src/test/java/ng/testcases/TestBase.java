package ng.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("====beforeSuite=====");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("====AfterSuite=====");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("====beforeTest=====");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("====afterTest=====");
    }


}
