package com.Module.UCG;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class VIEW_TRANSACTION_DETAILS extends TestBase {

    @Test
    public void VIEW_TRANSACTION_DETAIL() throws IOException, InterruptedException {
        test = extent.createTest("VIEW TRANSACTION DETAILS");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        BrokenLink brokenLink = new BrokenLink(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        driver.findElement(By.xpath(Utility.fetchLocator("Ucgbtn_XPATH"))).click();
        test.log(Status.PASS, "UCG Successfully Opened");

        if (driver.findElements(By.xpath(Utility.fetchLocator("mjj_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Transaction Details was successfully Displayed");
        } else {
            test.log(Status.FAIL, "Transaction Details Failed to load");
        }

        Thread.sleep(5000);
        System.out.println("********************VIEW TRANSACTION DETAILS********************");
        driver.quit();
    }
}
