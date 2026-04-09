package org.tests;

import org.base.BaseClass;
import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import org.utils.LogUtil;

@Listeners(org.listeners.TestListener.class)
public class LoginTest extends BaseClass {

    LoginPage loginPage;
    SearchFunction homePage;

    @BeforeMethod
    public void init() {
        loginPage = new LoginPage(page);
        homePage = new SearchFunction(page);
    }

    @Test(priority = 1)
    public void tanakaLogin() {

        loginPage.login("admin", "admin");
        LogUtil.info("Entered username and password");

        Assert.assertTrue(homePage.isUserOnHomePage(),
                "User not redirected to Home page");

        System.out.println("Login successful");
        LogUtil.info("Login successful");
    }

    @Test(priority = 2)
    public void search_With_Title() {
        homePage.searchWithTitle("Test2article");
    }

    @Test(priority = 3)
    public void search_With_Content() {
        homePage.searchWithContent("purpose");
    }

    @Test(priority = 4)
    public void search_With_Title_And_Content() {
        homePage.searchWithTitleAndContent("test,purpose");
    }

    // @Test(priority = 3)
    // public void searchFunction_With_AND_Operation() {
    // homePage.search_With_TitleandContent_Using_AND_Operation("test,article");
    // }

    // @Test(priority = 4)
    // public void searchFunction_With_OR_Operation() {
    // homePage.search_With_TitleandContent_Using_OR_Operation("test,purpose");
    // }

}