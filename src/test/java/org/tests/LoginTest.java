package org.tests;

import org.base.BaseClass;
import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

@Listeners(org.listeners.TestListener.class)
public class LoginTest extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;
    ExtentTest test;

    @BeforeMethod
    public void init() {
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @Test(priority = 1)
    public void tanakaLogin() {

        loginPage.login("admin", "admin");
        test.info("Entered username and password");

        Assert.assertTrue(homePage.isUserOnHomePage(),
                "User not redirected to Home page");

        System.out.println("Login successful");
        test.info("Login successful");
    }

    @Test(priority = 2)
    public void searchOneInput() {
        homePage.search_With_One_Input("test");
    }

    @Test(priority = 3)
    public void searchTwoInput() {
        homePage.search_With_Two_Input("test,article");
    }

}