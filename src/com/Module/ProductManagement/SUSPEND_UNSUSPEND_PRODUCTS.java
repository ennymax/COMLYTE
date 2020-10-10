package com.Module.ProductManagement;

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

public class SUSPEND_UNSUSPEND_PRODUCTS extends TestBase {

    @Test
    public void SUSPEND_PRODUCT() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND PRODUCT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Product Management button fully functional");

        //Click On Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Productbtn_XPATH"))).click();
        test.log(Status.PASS, "Product button fully Functional");

        Thread.sleep(2000);
        WebElement ti111 = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH")));
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].scrollIntoView();", ti111);
        ti111.click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Suspendbtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("Assertsusp_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product suspended")) {
            test.log(Status.PASS, "Product suspended successfully");
        } else {
            test.log(Status.FAIL, "suspension Failed");
        }

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("Suspendbtn_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg = driver.findElement(By.xpath(Utility.fetchLocator("AssertUnsus_XPATH")));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Product unsuspended")) {
            test.log(Status.PASS, "Product Unsuspended successfully");
        } else {
            test.log(Status.FAIL, "Unsuspension Failed");
        }

        System.out.println("********************SUSPEND PRODUCT TEST IS COMPLETED********************");
        driver.quit();
    }
}
