package ng.utilities;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    ExtentReports reports = ExtentReportConfiguration.getReportObject();
    ExtentTest test;
    @Override
    public void onStart(ITestContext context) {
        System.out.println("==onStart== > "+ context.getCurrentXmlTest().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("==onFinish== > "+ context.getCurrentXmlTest().getName());
        reports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test=reports.createTest(result.getMethod().getMethodName());
        System.out.println("==onTestStart== > "+ result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("==onTestSuccess== > "+ result.getMethod().getMethodName());
        test.log(Status.PASS,result.getMethod().getMethodName()+ " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("==onTestFailure== > "+ result.getMethod().getMethodName());
        test.log(Status.FAIL,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("==onTestSkipped== > "+ result.getMethod().getMethodName());
    }
}
