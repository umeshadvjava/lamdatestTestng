package com.testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import com.utilities.Logconfig;

import static com.utilities.CreateDriver.*;
import static com.utilities.Logconfig.Log;

public class BaseTest {

    @BeforeTest
    public void beforeTestm(){
        System.out.println("========BeforeTestm =========="+ Thread.currentThread().getName());
    }
    @AfterTest
    public void afterTestm(){
        System.out.println("============ AfterTestm ============"+ Thread.currentThread().getName());
    }

    @BeforeMethod
    public void setUp(){
        initializeDriver();
    }
    @AfterMethod()
    public void teardown() {
        unloadDriver();
    }

    public static synchronized String getScreenShot(String testCaseName,WebDriver driver) throws IOException, InterruptedException {
        System.out.println("in getScreenShot");
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
        FileUtils.copyFile(scr,file);
        System.out.println("out getScreenShot");
        return  "\\reports\\"+testCaseName+".png";

    }
}
