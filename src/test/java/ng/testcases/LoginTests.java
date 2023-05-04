package ng.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeClass(enabled = false)
    public void beforeClass(){
        System.out.println("=====BeforeClass=======");
    }

    @AfterClass(enabled = false)
    public void afterClass(){
        System.out.println("=====AfterClass=======");
    }

    @Test(priority = 1)
    public void loginTest1(){
        System.out.println("======loginTest1=========");
        Assert.assertTrue(true);
    }

    @Test(groups = {"functional"})
    public void loginTest2(){
        System.out.println("======loginTest2=========");
        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void loginTest3(){
        System.out.println("======loginTest2=========");
        Assert.assertTrue(true);
    }

    @Test
    public void loginTest4(){
        System.out.println("======loginTest2=========");
        Assert.assertTrue(true);
    }
}
