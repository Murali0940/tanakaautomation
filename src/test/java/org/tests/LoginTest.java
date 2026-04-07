package org.tests;

import org.base.BaseClass;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.listeners.TestListener.class)
public class LoginTest extends BaseClass {

    @Test
    public void tanakaLogin() {

        // Page Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Perform Login
        loginPage.login("admin", "admin");

        // Validate Navigation
        boolean isHome = homePage.isUserOnHomePage();

        String actualUrl = homePage.getCurrentUrl();
        System.out.println("Redirected URL: " + actualUrl);

        Assert.assertTrue(isHome, "User not redirected to Home page");
    }

}
