package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Iframe {

    WebDriver driver;

    public Iframe(WebDriver driver) {

        this.driver = driver;
    }

    public void IframeFinder() {

        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println("No. of Iframes on this Web Page are: " + numberOfTags);
    }
}