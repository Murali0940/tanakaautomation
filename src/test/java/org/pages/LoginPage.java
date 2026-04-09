package org.pages;

import org.testng.Assert;
import org.utils.LogUtil;

import com.microsoft.playwright.Page;

public class LoginPage {

    public Page page;
    BasePage basePage;

    public LoginPage(Page page) {
        this.page = page;
        this.basePage = new BasePage(page);
    }

    public void login(String user, String pass) {

        // Wait for username field

        String username = "//input[@placeholder='ユーザー名']";
        String password = "//input[@placeholder='パスワード']";
        String loginBtn = "//button[text()='ログイン']";

        // username
        page.locator(username).waitFor();
        page.locator(username).fill(user);
        LogUtil.info("Entered username");

        // password
        page.locator(password).waitFor();
        page.locator(password).fill(pass);
        LogUtil.info("Entered password");

        // login button
        page.locator(loginBtn).click();
        LogUtil.info("submit button clicked");
        page.waitForTimeout(10000);

        String expectedURL = "https://tanaka-wiki.com/home";
        page.waitForURL(expectedURL);
        Assert.assertEquals(page.url(), expectedURL);
        LogUtil.info("Home page loaded");
    }
}