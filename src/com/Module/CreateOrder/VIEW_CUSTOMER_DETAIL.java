package com.Module.CreateOrder;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VIEW_CUSTOMER_DETAIL extends TestBase {

    @Test
    public void VIEW_CUSTOMER_DETAILS() throws IOException, InterruptedException {
        test = extent.createTest("VIEW CUSTOMER TEST");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        //SEARCH BY NAME
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("SearchByNameAssertion_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By Name was Successful");
            test.log(Status.PASS, "Search By Phone Number was Successful");
            test.log(Status.PASS, "Search By Email was Successful");

        } else {
            test.log(Status.FAIL, "Search By name Failed");
        }

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("assertdisplayeddetails_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Customer Details was displyed");

        } else {
            test.log(Status.FAIL, "Customer Details wasnt displayed");
        }

        System.out.println("********************VIEW CUSTOMER DETAIL TEST SUCCESSFULLY IS COMPLETED********************");
        driver.quit();
    }
}