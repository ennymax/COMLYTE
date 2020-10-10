package com.Module.DashBoard;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Variance_Report_Dashboard extends TestBase {

    @Test
    public void VARIANCE_REPORT() throws IOException, InterruptedException {
        test = extent.createTest("VARIANCE REPORT DASHBOARD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //Variance
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Variance_XPATH"))).click();
        test.log(Status.PASS, "Variance button fully functionl");

        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Vdisplaybtn_XPATH"))).click();

        WebElement menuOption = driver.findElement(By.xpath(Utility.fetchLocator("VarianceGraph_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuOption);

        //Region in Pacentage
        Thread.sleep(2000);
        WebElement menuOption1 = driver.findElement(By.xpath(Utility.fetchLocator("RVariancePercentage_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuOption1);

        System.out.println("********************View DashBoard Test is Completed********************");
        driver.quit();
    }
}

