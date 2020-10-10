package com.Module.CustomerManagment;

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

public class Suspend_Unsuspend_Customer extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_CUSTOMER() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND CUSTOMER");
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

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        WebElement ti11z = driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH")));
        JavascriptExecutor jsez = (JavascriptExecutor) driver;
        jsez.executeScript("arguments[0].scrollIntoView();", ti11z);
        ti11z.click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("SuspendCustomerBTN_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("y_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("User suspended")) {
            test.log(Status.PASS, "Customer Suspended Successfully");
        } else {
            test.log(Status.FAIL, "Customer Suspension failed");
        }

        Thread.sleep(2000);
        WebElement elementl = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor jsl = (JavascriptExecutor) driver;
        jsl.executeScript("arguments[0].click();", elementl);

        Thread.sleep(2000);
        WebElement elementqll = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendCustomer_XPATH")));
        JavascriptExecutor jsqll = (JavascriptExecutor) driver;
        jsqll.executeScript("arguments[0].click();", elementqll);

        Thread.sleep(2000);
        WebElement msg11l = driver.findElement(By.xpath(Utility.fetchLocator("Y1_XPATH")));
        String text11l = msg11l.getText();
        if (msg11l.isEnabled() && text11l.contains("User unsuspended")) {
            test.log(Status.PASS, "Customer Unsuspended Successfully");
        } else {
            test.log(Status.FAIL, "Customer Unsuspension failed");
        }

        System.out.println("********************SUSPEND UNSUSPEND CUSTOMER IS COMPLETED********************");
        driver.quit();
    }
}
