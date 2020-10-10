package com.Module.SettingUpWorkShop;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
import com.utility.RavePay;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class BUY_NOW extends TestBase {

    @Test
    public void BUY_NOW() throws IOException, InterruptedException {
        test = extent.createTest("BUY NOW");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://gidistores.cicodsaasstaging.com/webshop/");

        RavePay ravepay = new RavePay(driver);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("aa_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", element1);

        //Click on beverages
        driver.findElement(By.xpath(Utility.fetchLocator("Beverages_XPATH"))).click();

        //Search by productName
        driver.findElement(By.xpath(Utility.fetchLocator("aa_XPATH"))).sendKeys(Utility.fetchLocator("Creal_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("searchBtn_XPATH"))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("milo_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By ProductName was successfull");

        } else {
            test.log(Status.FAIL, "Search by ProductName failed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MiloAddtoCartbtn_XPATH"))).click();
        test.log(Status.PASS, "Product was successfully add to cart");

        driver.findElement(By.xpath(Utility.fetchLocator("cartbtn_XPATH"))).click();
        test.log(Status.PASS, "Cert Button was successfully Clicked");

        driver.findElement(By.xpath(Utility.fetchLocator("Pname_XPATH"))).sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PphoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PEmailAddress_XPATH"))).sendKeys(Utility.fetchLocator("CustomerEmail_TEXT"));


        driver.findElement(By.xpath(Utility.fetchLocator("Pdelivery_XPATH"))).click();


        Thread.sleep(500);
        WebElement ele112 = driver.findElement(By.xpath(Utility.fetchLocator("PCountry_XPATH")));
        Select sel12 = new Select(ele112);
        sel12.selectByIndex(1);

        Thread.sleep(500);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("PState_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(500);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("PArea_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(9);

        driver.findElement(By.xpath(Utility.fetchLocator("DeliveryAddress_XPATH"))).sendKeys(Utility.fetchLocator("DeliveryAddress_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("mm_XPATH")));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Ppayonline_XPATH")));
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", element);

        screenshot.ScreenShot();

        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("Payment_XPATH")));
        JavascriptExecutor jsee = ((JavascriptExecutor) driver);
        jsee.executeScript("arguments[0].click();", element11);

        ravepay.RavePayWorkShop();

        Thread.sleep(2000);
        screenshot.ScreenShot();

        System.out.println("*******************BUY NOW TEST IS COMPLETED********************");
        driver.quit();
    }
}