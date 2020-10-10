package com.Module.Administration;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DOWNLOAD_User extends TestBase {

    @Test
    public void DOWNLOAD_USER() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");
        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("UserDownload_XPATH"))).click();

        System.out.println("********************DOWNLOAD USER TEST IS COMPLETED********************");
        driver.quit();
    }
}
