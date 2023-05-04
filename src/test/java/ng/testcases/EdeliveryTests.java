package ng.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EdeliveryTests extends TestBase {

    @BeforeClass
    public void beforeClass(){
        System.out.println("=====EdeliveryTests- BeforeClass=======");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("=====EdeliveryTests- AfterClass=======");
    }

    @Test(groups = {"regression"} ,priority = 1)
    public void edeliveryTest1(){
        System.out.println("======EdeliveryTests- edeliveryTest1=========");
        Assert.assertTrue(true);
    }
    @Test(groups = {"functional"} , priority = 2)
    public void edeliveryTest2(){
        System.out.println("======EdeliveryTests- edeliveryTest2=========");
        Assert.assertTrue(true);
    }
}
