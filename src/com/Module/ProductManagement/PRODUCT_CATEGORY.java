package com.Module.ProductManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PRODUCT_CATEGORY extends TestBase {

    @Test
    public void PRODUCT_category() throws IOException, InterruptedException {
        test = extent.createTest("PRODUCT CATEGORY");
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
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Product Management button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("productCategory_XPATH"))).click();
        test.log(Status.PASS, "Product Category button fully functional");

        if (driver.findElements(By.xpath(Utility.fetchLocator("ProductCategoryConfirm_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product Category Page is opened");
        } else {
            test.log(Status.FAIL, "Product Category Page is not accessible");
        }

        //Add Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProductbtn_XPATH"))).click();
        test.log(Status.PASS, "Add Product button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductName_XPATH"))).sendKeys(Utility.fetchLocator("ProductName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductDiscription_XPATH"))).sendKeys(Utility.fetchLocator("ProductDiscription_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("savvbtn_XPATH"))).click();

        System.out.println("********************PRODUCT CATEGORY TEST IS COMPLETED*******************");
        driver.quit();
    }
}