package com.Module.SettingUpWorkShop;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class THEME_AND_CONFIG extends TestBase {
    @Test
    public void THEME_CONFIG() throws IOException, InterruptedException {
        test = extent.createTest("THEME AND CONFIG");
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

        screenshot.ScreenShot();

        driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH"))).click();

        screenshot.ScreenShot();

        driver.findElement(By.xpath(Utility.fetchLocator("themeandconfigbtn_XPATH"))).click();

        screenshot.ScreenShot();

        driver.findElement(By.xpath(Utility.fetchLocator("UpdateTheme_XPATH"))).click();
        test.log(Status.PASS, "Theme Update page was Displayed successfully");

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("StoreLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ThemeSaveBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("assertThemeUpdate_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Theme was saved Successfully");
        } else {
            test.log(Status.FAIL, "Theme cant be updated");
        }

        screenshot.ScreenShot();

        brokenLink.BrokenLink();

        System.out.println("********************THEME AND CONFIG TEST IS COMPLETED********************");
        driver.quit();
    }
}