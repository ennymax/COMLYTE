package com.utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenShot extends TestBase {
    WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }


    public void ScreenShot() throws IOException, InterruptedException {
        Thread.sleep(1000);
        String extentReportImageqm11 = System.getProperty("user.dir") + "\\ScreenShot\\ScreenShot" + System.currentTimeMillis() + ".png";
        File srcam11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the screenshot to desired location using copyFile method
            FileUtils.copyFile(srcam11, new File(extentReportImageqm11));
            test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
        } catch (IOException e) {
            System.out.println("Error in the captureAndDisplayScreenShot method: " + e.getMessage());
        }
    }

    public void ScreenShotFullPage() throws IOException, InterruptedException {
        Thread.sleep(1000);
        String extentReportImageqm11 = System.getProperty("user.dir") + "\\ScreenShot\\ScreenShot" + System.currentTimeMillis() + ".png";
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File(extentReportImageqm11));
        test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
    }


    public void ScreenShotWebElement() throws IOException, InterruptedException {
        Thread.sleep(1000);
        String extentReportImageqm11 = System.getProperty("user.dir") + "\\ScreenShot\\ScreenShot" + System.currentTimeMillis() + ".png";
        WebElement logo = driver.findElement(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullScreen = ImageIO.read(screenshot);
        Point location = logo.getLocation();
        int width = logo.getSize().getWidth();
        int height = logo.getSize().getHeight();

        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
        ImageIO.write(logoImage, "png", screenshot);
        FileUtils.copyFile(screenshot, new File(extentReportImageqm11));
        test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
    }
}