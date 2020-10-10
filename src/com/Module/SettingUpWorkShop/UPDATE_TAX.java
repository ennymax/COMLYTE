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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UPDATE_TAX extends TestBase {

    @Test
    public void UPDATE_TAx() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE TAX");
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

        driver.findElement(By.xpath(Utility.fetchLocator("TaxBtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("TaxActionbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("TaxUdatebtn_XPATH"))).click();
        test.log(Status.PASS, "Tax Update Button fully Functional");

        driver.findElement(By.xpath(Utility.fetchLocator("TaxName_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("TaxName_XPATH"))).sendKeys(Utility.fetchLocator("TaxName_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("TaxValue_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("TaxValue_XPATH"))).sendKeys(Utility.fetchLocator("TaxValue_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("TaxSavebtn_XPATH"))).click();


        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertUpdateTax_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Tax was Updated Successfully");

        } else {
            test.log(Status.FAIL, "Tax Wasn't Updated");
        }

        System.out.println("********************UPDATE TAX TEST IS COMPLETED********************");
        driver.quit();
    }
}
