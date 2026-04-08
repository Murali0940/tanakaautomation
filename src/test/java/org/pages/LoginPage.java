package org.pages;

import org.utils.LogUtil;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    BasePage basePage;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String user, String pass) {

        page.locator("//input[@placeholder='ユーザー名']").fill(user);
        LogUtil.info("Entered username");
        page.locator("//input[@placeholder='パスワード']").fill(pass);
        LogUtil.info("Entered password");
        page.locator("//button[text()='ログイン']").click();
        LogUtil.info("submit button clicked");
        basePage.waitForLoaderToDisappear();
    }
}