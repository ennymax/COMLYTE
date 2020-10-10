package com.Module.UpgradeSuscription;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Upgrade_Suscription_Of_Active_Account extends TestBase {

    @Test
    public void UPGRADE_SUBSCRIPTION() throws IOException, InterruptedException {

        test = extent.createTest("UPGRADE SUBSCRIPTION");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        RavePay ravePay = new RavePay(driver);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);


        login.LoginUpgrade();
        test.log(Status.PASS, "Login Was Successful");

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("j_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("SuscriptionBTN_XPATH")));
        JavascriptExecutor js11 = (JavascriptExecutor) driver;
        js11.executeScript("arguments[0].click();", element11);

        Thread.sleep(2000);
        WebElement element111s = driver.findElement(By.xpath(Utility.fetchLocator("UpgradeBundle_XPATH")));
        JavascriptExecutor js111s = (JavascriptExecutor) driver;
        js111s.executeScript("arguments[0].click();", element111s);

        Thread.sleep(2000);
        WebElement element111 = driver.findElement(By.xpath(Utility.fetchLocator("UpgradeBundleBTN_XPATH")));
        JavascriptExecutor js111 = (JavascriptExecutor) driver;
        js111.executeScript("arguments[0].click();", element111);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("PayNowUpgrade_XPATH")))).click();

        ravePay.RavePay1();
        screenShot.ScreenShot();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("Assssss_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Enter your 4-digit card pin to authorize this payment")) {
            test.log(Status.PASS, "Flutter wave Page fully Functional");
        } else {
            test.log(Status.FAIL, "Flutter wave page not Functional");
        }

        Thread.sleep(4000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************Upgrade Subscription  Test is Completed********************");
        driver.quit();
    }
}
