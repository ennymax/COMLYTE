package com.Module.OrderHistory;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VIEW_ORDER_HISTORY extends TestBase {
    @Test
    public void VIEW_ORDER_history() throws IOException, InterruptedException {
        test = extent.createTest("VIEW ORDER HISTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("OrderHistorybtn_XPATH"))).click();
        test.log(Status.PASS, "Order history Button fully Functional");

        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnOrderRecordsbtn_XPATH"))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRecord_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order history can be Viewed");

        } else {
            test.log(Status.FAIL, "The Order history cant be viewed");
        }

        System.out.println("********************VIEW ORDER HISTORY TEST IS COMPLETED********************");
        driver.quit();
    }

}
