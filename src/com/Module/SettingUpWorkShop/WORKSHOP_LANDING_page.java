package com.Module.SettingUpWorkShop;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
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

public class WORKSHOP_LANDING_page extends TestBase {

    @Test
    public void WORKSHOP_LANDING_PAGE() throws IOException, InterruptedException {
        test = extent.createTest("WORKSHOP LANDING PAGE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://gidistores.cicodsaasstaging.com/webshop/");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);

        brokenLink.BrokenLink();

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("aa_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", element1);

        //Click on beverages
        driver.findElement(By.xpath(Utility.fetchLocator("Beverages_XPATH"))).click();

        screenshot.ScreenShot();

        //Search by productName
        driver.findElement(By.xpath(Utility.fetchLocator("aa_XPATH"))).sendKeys(Utility.fetchLocator("Creal_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("searchBtn_XPATH"))).click();

        screenshot.ScreenShot();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("milo_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By ProductName was successful");

        } else {
            test.log(Status.FAIL, "Search by ProductName failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("milo_XPATH"))).click();
        test.log(Status.PASS, "Product was successfully displayed");

        brokenLink.BrokenLink();

        driver.navigate().back();

        //Search By ProductCode
        driver.findElement(By.xpath(Utility.fetchLocator("aa_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("aa_XPATH"))).sendKeys(Utility.fetchLocator("productCode_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("searchBtn_XPATH"))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("milo_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By ProductCode was successfull");

        } else {
            test.log(Status.FAIL, "Search by ProductCode failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("milo_XPATH"))).click();
        test.log(Status.PASS, "Product was successfully displayed");

        screenshot.ScreenShot();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("StoreName_XPATH")));
        JavascriptExecutor js11 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", element11);
        js1.executeScript("arguments[0].click;", element11);

        System.out.println("********************WORKSHOP LANDING PAGE TEST IS COMPLETED********************");
        driver.quit();
    }
}