package org.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "reports/" + testName + ".png";
            FileHandler.copy(src, new File(path));
            return path;

        } catch (Exception e) {
            return null;
        }
    }

}
