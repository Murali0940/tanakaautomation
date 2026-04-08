package org.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isUserOnHomePage() {
        page.waitForURL("**/home");
        return page.url().contains("/home");
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public void search_With_One_Input(String oneword) {
        page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']")
                .fill(oneword);
        page.locator("//button[text()='検索']").click();
    }

    public void search_With_Two_Input(String twowords) {
        page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']")
                .fill(twowords);
        page.locator("//button[text()='検索']").click();
    }

}