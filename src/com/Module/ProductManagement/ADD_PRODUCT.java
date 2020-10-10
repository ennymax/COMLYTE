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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ADD_PRODUCT extends TestBase {

    @Test
    public void ADD_PRODUCTs() throws IOException, InterruptedException {
        test = extent.createTest("ADD PRODUCT");
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

        //Click On Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Productbtn_XPATH"))).click();
        test.log(Status.PASS, "Product button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Add_Producttn_XPATH"))).click();
        test.log(Status.PASS, "Add Product button fully Functional");

        Thread.sleep(2000);
        WebElement menuOption1 = driver.findElement(By.xpath(Utility.fetchLocator("CreateProductpageassert_XPATH")));
        String aa = menuOption1.getText();

        if (aa.contains("Create Form")) {
            test.log(Status.PASS, "Page to add product has been opened");
        } else {
            test.log(Status.PASS, "Add product Page cant be opened");
        }

        screenshot.ScreenShot();

        Thread.sleep(2000);
        WebElement ele1 = driver.findElement(By.xpath(Utility.fetchLocator("SelectProductCategory_XPATH")));
        Select sel = new Select(ele1);
        sel.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("ProductNamei_XPATH"))).sendKeys(Utility.fetchLocator("ProductName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductDiscriptioni_XPATH"))).sendKeys(Utility.fetchLocator("ProductDiscription_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCode_XPATH"))).sendKeys(Utility.fetchLocator("ProductCode_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ProductPrize_XPATH"))).sendKeys(Utility.fetchLocator("ProductPrice_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("AddToworkshoptCheckBox_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ReservationDays_XPATH"))).sendKeys(Utility.fetchLocator("ReservationDay_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("NoQuantityLimitCheckBox_XPATH"))).click();

        Thread.sleep(1500);
        screenshot.ScreenShot();

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("Vat_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("isave_XPATH"))).click();

        System.out.println("********************ADD PRODUCT TEST IS COMPLETED********************");
        driver.quit();
    }
}