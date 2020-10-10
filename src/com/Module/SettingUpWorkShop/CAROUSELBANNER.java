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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CAROUSELBANNER extends TestBase {
    @Test
    public void CAROUSEL_BANNER() throws IOException, InterruptedException {
        test = extent.createTest("CAROUSEL BANNER");
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

        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("CarouselBanner_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("AddCoruselBanner_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("Caption_XPATH"))).sendKeys(Utility.fetchLocator("Caption_TEXT"));

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("DisplayLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("OrderOfAppearance_XPATH"))).sendKeys(Utility.fetchLocator("OrderOfPreference_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ActiUERL_XPATH"))).sendKeys(Utility.fetchLocator("ActionUrl_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("CarouselSaveBtn_XPATH"))).click();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();

        System.out.println("********************CAROUSEL BANNER TEST IS COMPLETED********************");
        driver.quit();
    }
}
