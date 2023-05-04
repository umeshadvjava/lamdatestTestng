package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testcases.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Path;

import static com.testcases.BaseTest.getScreenShot;
import static com.utilities.CreateDriver.getDriver;
import static com.utilities.ExtentReportConfiguration.getReportObject;


public class Listeners implements ITestListener {

    ExtentReports extentReports = getReportObject();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        System.out.println(" onTestStart"+ Thread.currentThread().getName());
        test.set(extentReports.createTest(result.getMethod().getMethodName()));
    }
    @Override
    public void onTestSuccess(ITestResult result) {
         test.get().log(Status.PASS,result.getMethod().getMethodName());
    }


    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());
        try {
            String path = getScreenShot(result.getMethod().getMethodName().toString(),getDriver());
            System.out.println("Path of the file is "+ path);
            test.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());

        } catch (IOException e) { e.printStackTrace();  } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {

    }
    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
