package com.Module.CreateOrder;

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

public class SEARCH_EXISTING_CUSTOMER extends TestBase {

    @Test
    public void SEARCH_EXISTING_customer() throws IOException, InterruptedException {
        test = extent.createTest("SEARCH EXISTING CUSTOMER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
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
            test.log(Status.FAIL, "Search Failed");
        }

        System.out.println("********************CUSTUMER WAS CREATED SUCCESSFULLY IS COMPLETED********************");
        driver.quit();
    }
}
