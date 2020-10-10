package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Report\\FULL_REPORT_CICODLYTE" + System.currentTimeMillis() + ".html");
        htmlReporter.config().setDocumentTitle("Automation Test Results");
        htmlReporter.config().setReportName("Tester's Name: Eniola Iyaomolere");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);

        extent.setSystemInfo("Hostname","LocalHost");
        extent.setSystemInfo("TesterName","Eniola Iyaomolere");
        extent.setSystemInfo("OS","Window10");
        extent.setSystemInfo("Browser","Chrome and Firefox");

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + " The Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + " The Test Case Passed", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(MarkupHelper.createLabel(result.getName() + " The Test Case Skipped", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
        extent.flush();
        System.out.println("********************All Test Execution is Completed********************");
    }

}
