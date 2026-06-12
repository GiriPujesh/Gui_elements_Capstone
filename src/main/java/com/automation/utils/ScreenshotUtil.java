package com.automation.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String screenshotName) {

        String destination =
                System.getProperty("user.dir")
                + "/screenshots/"
                + screenshotName
                + ".png";

        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(
                    src,
                    new File(destination));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return destination;
    }
}