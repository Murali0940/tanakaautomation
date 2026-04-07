package org.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isUserOnHomePage() {
        wait.until(ExpectedConditions.urlContains("/home"));
        return driver.getCurrentUrl().contains("/home");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
