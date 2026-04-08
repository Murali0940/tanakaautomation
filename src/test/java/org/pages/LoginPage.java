package org.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String user, String pass) {
        page.locator("//input[@placeholder='ユーザー名']").fill(user);
        page.locator("//input[@placeholder='パスワード']").fill(pass);
        page.locator("//button[text()='ログイン']").click();
    }
}