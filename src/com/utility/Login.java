package com.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)//switches only if alert is displayed
        {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void LoginFreeTrial() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("FreeTrialShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("FreeTrialEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("FreeTrialPassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void Login() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginActiveAccount() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("ActShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("ActEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UpPassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginExpiredAccount() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("Cshopname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Cemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Cpassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginUpgrade() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("TestShopName_XPATH"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("TestEmail_XPATH"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UpPassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginTestAccount() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("Shopname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Email_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Password_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginTestAccountSetUp() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("Ashop_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Aemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Apassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }
}
