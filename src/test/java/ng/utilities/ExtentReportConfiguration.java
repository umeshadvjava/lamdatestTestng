package ng.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.sql.Time;

public class ExtentReportConfiguration {
    static String path = System.getProperty("user.dir")+ "\\reports\\index.html";

    public static ExtentReports getReportObject() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web automation Report");
        reporter.config().setDocumentTitle("Test Results");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
