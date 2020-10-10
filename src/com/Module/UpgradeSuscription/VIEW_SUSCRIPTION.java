package com.Module.UpgradeSuscription;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VIEW_SUSCRIPTION extends TestBase {

    @Test
    public void VIEW_SUSCRIPTION() throws Exception {
        test = extent.createTest("VIEW SUBSCRIPTION");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        VideoRecorder.startRecording("TestingVideoRecording");

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("sdsd_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SuscriptionBTN_XPATH")))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("SuscriptionPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Subscription Page was displayed");
        } else {
            test.log(Status.FAIL, "Subscription Page was not displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBillAmount_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Bill Amount Captured");
        } else {
            test.log(Status.FAIL, "Bill Amount Not captured");
        }

        Thread.sleep(3000);
        screenShot.ScreenShot();

        VideoRecorder.stopRecording();

        System.out.println("********************View Suscription Test is Completed********************");
        driver.quit();
    }
}
