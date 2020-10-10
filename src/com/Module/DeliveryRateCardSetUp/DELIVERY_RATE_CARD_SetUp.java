package com.Module.DeliveryRateCardSetUp;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DELIVERY_RATE_CARD_SetUp extends TestBase {

    @Test
    public void DELIVERY_RATE_CARD_SETUP() throws IOException, InterruptedException {
        test = extent.createTest("DELIVERY RATE CARD SETUP");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");


        //COM
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("DeliveryRatebtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("DelAdd_XPATH"))).click();

        Thread.sleep(1000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("marchantLocation_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("SelectCountry_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(3);

        Thread.sleep(1000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("MarchantState_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByIndex(25);

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("MarchantLGA_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(10);

        driver.findElement(By.xpath(Utility.fetchLocator("MiniDeliveryCharge_XPATH"))).sendKeys(Utility.fetchLocator("MiniDeliveryRate_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PercentDeliveryRate_XPATH"))).sendKeys(Utility.fetchLocator("PercentageDeliveryCharge_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("FreeDeliveryPrice_XPATH"))).sendKeys(Utility.fetchLocator("FreeeDeliveryPrice_TEXT"));

        Thread.sleep(900);
        driver.findElement(By.xpath(Utility.fetchLocator("DeliverySavebtn_XPATH"))).click();

        System.out.println("********************DELIVERY RATE CARD SETUP TEST IS COMPLETED********************");
        driver.quit();
    }
}
