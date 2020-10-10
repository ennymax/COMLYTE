package com.Module.DashBoard;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
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

public class OrderFufilment extends TestBase {

    @Test
    public void ORDER_FUFILLMENT() throws IOException, InterruptedException {
        test = extent.createTest("ORDER FUFILMENT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //DashBoard
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Dashboard_XPATH"))).click();
        test.log(Status.PASS, "Dashboard button fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Dispalybtn_XPATH"))).click();
        test.log(Status.PASS, "Display button Clicked");

        //Total Order
        driver.findElement(By.xpath(Utility.fetchLocator("TotalOrder_XPATH"))).click();
        WebElement eee = driver.findElement(By.xpath(Utility.fetchLocator("TotalOrder_XPATH")));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("TotalOrder_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(500);
        //Paid Order
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("PaidOrder_XPATH"))).click();
        WebElement element123 = driver.findElement(By.xpath(Utility.fetchLocator("PaidOrder_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element123);

        //Unpaid Order
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("UnpaidOrder_XPATH"))).click();
        WebElement element12 = driver.findElement(By.xpath(Utility.fetchLocator("UnpaidOrder_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element12);

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("TotalOrder_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

        System.out.println("********************Order fulfillment Test is Completed********************");
        driver.quit();
    }
}

