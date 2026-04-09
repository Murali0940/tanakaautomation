package org.base;

import com.microsoft.playwright.*;

import org.testng.annotations.*;

public class BaseClass {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    @BeforeSuite
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false) // Jenkins ready
        );

        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://tanaka-wiki.com/");

        org.pages.LoginPage loginPage = new org.pages.LoginPage(page);
        loginPage.login("admin", "admin");
    }

    @AfterSuite
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}