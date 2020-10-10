package com.Module.SettingUpWorkShop;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
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

public class SUSPEND_UNSUSPEND_TAX extends TestBase {
    @Test
    public void SUSPEND_TAX() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND TAX");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxBtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("sUSPENDTax_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Tax suspended")) {
            test.log(Status.PASS, "Tax suspended");
        } else {
            test.log(Status.FAIL, "Tax cannot be suspended");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement elementz = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendTax_XPATH")));
        JavascriptExecutor jsz = (JavascriptExecutor) driver;
        jsz.executeScript("arguments[0].click();", elementz);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg11f = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11f = msg11f.getText();
        if (msg11f.isEnabled() && text11f.contains("Tax unsuspended")) {
            test.log(Status.PASS, "Tax Unsuspendsion Successful");
        } else {
            test.log(Status.FAIL, "Tax Unsuspension Failed");
        }

        Thread.sleep(2000);
        System.out.println("********************SUSPEND TAX TEST IS COMPLETED********************");
        driver.quit();
    }
}
