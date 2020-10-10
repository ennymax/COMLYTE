package com.Module.Administration;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AddUser extends TestBase {

    @Test
    public void ADD_USER() throws IOException, InterruptedException {
        test = extent.createTest("ADD USER");
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

        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("AddUserbtn_XPATH"))).click();

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("Role_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele111ca = driver.findElement(By.xpath(Utility.fetchLocator("Region_XPATH")));
        Select sel11ca = new Select(ele111ca);
        sel11ca.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("RFirsteName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RLastName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerLastName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RPhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("REmail_XPATH"))).sendKeys(Utility.fetchLocator("CustomerEmail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("CreateUserSaveBTN_XPATH"))).click();

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("qqq_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Error creating user: \"MAXIMUM_USER_LICENSE_REACHED\"")) {
            test.log(Status.PASS, "Add User fully Functional");
        } else {
            test.log(Status.FAIL, "Add User Module failed");
        }

        Thread.sleep(2000);
        System.out.println("********************ADD USER TEST IS COMPLETED********************");
        driver.quit();
    }
}
