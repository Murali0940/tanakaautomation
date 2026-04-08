package org.tests;

import org.base.BaseClass;
import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(org.listeners.TestListener.class)
public class LoginTest extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void init() {
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @Test(priority = 1)
    public void tanakaLogin() {

        loginPage.login("admin", "admin");

        Assert.assertTrue(homePage.isUserOnHomePage(),
                "User not redirected to Home page");

        System.out.println("Login successful");
    }

    @Test(priority = 2)
    public void searchOneInput() {
        homePage.search_With_One_Input("test");
    }
}