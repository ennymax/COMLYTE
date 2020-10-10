package com.Module.SettingUpWorkShop;

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

public class CREATE_PRODUCT_CATEGORY extends TestBase {
    @Test
    public void CREATE_PRODUCT_CATEGORy() throws IOException, InterruptedException {
        test = extent.createTest("CREATE PRODUCT CATEGORY");
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
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        screenshot.ScreenShot();

        //product Management
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Product Management button fully functional");

        screenshot.ScreenShot();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("productCategory_XPATH"))).click();
        test.log(Status.PASS, "Product Category button fully functional");

        //Add Product
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProductbtn_XPATH"))).click();
        test.log(Status.PASS, "Add Product button fully functional");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductName_XPATH"))).sendKeys(Utility.fetchLocator("ProductName2_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductDiscription_XPATH"))).sendKeys(Utility.fetchLocator("NewDiscription2_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCheckBox_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("savvbtn_XPATH"))).click();

        screenshot.ScreenShot();

        System.out.println("********************CREATE PRODUCT CATEGORY TEST WAS SUCCESSFULLY COMPLETED********************");
        driver.quit();
    }
}
