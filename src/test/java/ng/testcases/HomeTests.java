package ng.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTests extends TestBase{

    @BeforeClass
    public void beforeClass(){
        System.out.println("=====HomeTests- BeforeClass=======");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("=====HomeTests- AfterClass=======");
    }

    @Test(groups = {"regression"} ,priority = 1)
    public void homeTest1(){
        System.out.println("======HomeTests- homeTest1=========");
        Assert.assertTrue(true);
    }

    @Test(priority = 1,groups = {"functional"})
    public void homeTest2(){
        System.out.println("======HomeTests- homeTest2=========");
        Assert.assertTrue(true);
    }

    @Test(priority = 2, groups = {"regression"})
    public void homeTest3(){
        System.out.println("======HomeTests- homeTest3=========");
        Assert.assertTrue(true);
    }

    @Test
    public void homeTest4(){
        System.out.println("======HomeTests- homeTest4=========");
        Assert.assertTrue(true);
    }
}
