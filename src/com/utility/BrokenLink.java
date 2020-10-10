package com.utility;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLink extends TestBase {

    WebDriver driver;

    public BrokenLink(WebDriver driver) {

        this.driver = driver;
    }

    public void BrokenLink() throws InterruptedException, IOException {

        Thread.sleep(5000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links are " + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLink(url);
        }
    }


    public void verifyLink(String urlLink) throws IOException {
        try {
            URL link = new URL(urlLink);
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            if (httpConn.getResponseCode() == 200) {
                test.log(Status.PASS, urlLink + ":::: is a Valid link ::::" + httpConn.getResponseMessage());
                System.out.println(urlLink + ":::: is a Valid link ::::" + httpConn.getResponseMessage());
            }
            if ((httpConn.getResponseCode() == 101) ) {

            }
            if ((httpConn.getResponseCode() == 201) ) {

            }
            if ((httpConn.getResponseCode() == 204) ) {

            }
            if ((httpConn.getResponseCode() == 301) ) {

            }
            if ((httpConn.getResponseCode() == 302) ) {

            }
            if ((httpConn.getResponseCode() == 307) ) {

            }
            if ((httpConn.getResponseCode() == 400) ) {

            }
            if ((httpConn.getResponseCode() == 401) ) {

            }
            if ((httpConn.getResponseCode() == 403) ) {

            }
            if ((httpConn.getResponseCode() == 404) ) {
                test.log(Status.FAIL, urlLink + ":::: is a Broken link ::::" + httpConn.getResponseMessage());
                System.out.println(urlLink + ":::: is a Broken link ::::" + httpConn.getResponseMessage());
            }
            if ((httpConn.getResponseCode() == 408) ) {

            }
            if ((httpConn.getResponseCode() == 414) ) {

            }
            if ((httpConn.getResponseCode() == 500) ) {

            }
            if ((httpConn.getResponseCode() == 502) ) {

            }
            if ((httpConn.getResponseCode() == 503) ) {

            }
            if ((httpConn.getResponseCode() == 504) ) {

            }

        } catch (StaleElementReferenceException e) {
        } catch (Exception e) {
        }
    }
}
