package org.pages;

import org.testng.Assert;
import org.utils.LogUtil;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchFunction {

    private Page page;
    Locator search;
    Locator andSearch;
    Locator orSearch;

    public SearchFunction(Page page) {
        this.page = page;
    }

    public boolean isUserOnHomePage() {
        page.waitForURL("**/home");
        return page.url().contains("/home");
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public void searchWithTitle(String oneword) {
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }

        Locator contentSearch = page.locator("#content-search");
        if (contentSearch.isChecked()) {
            contentSearch.uncheck();
        }

        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill(oneword);
        LogUtil.info("one word entered");
        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);
    }

    public void searchWithContent(String content) {
        Locator titleSearch = page.locator("#title-search");
        if (titleSearch.isChecked()) {
            titleSearch.uncheck();
        }

        search = page.locator("#content-search");
        if (!search.isChecked()) {
            search.check();
        }
        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill(content);
        LogUtil.info("two words entered");

        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);
    }

    public void searchWithTitleAndContent(String titleandContent) {
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }

        Locator contentSearch = page.locator("#content-search");
        if (!contentSearch.isChecked()) {
            contentSearch.check();
        }
        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill(titleandContent);
        LogUtil.info("keyword entered");

        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);
    }

    // public void search_With_TitleandContent_Using_AND_Operation(String
    // titlecontent) {

    // search = page.locator("#content-search");
    // if (!search.isChecked()) {
    // search.check();
    // }
    // search = page.locator("//input[@id='home-search-input' or
    // @placeholder='Wiki内を検索']");
    // search.clear();
    // search.fill(titlecontent);
    // LogUtil.info("two words entered");

    // page.locator("//button[text()='検索']").click();
    // LogUtil.info("search button clicked");
    // LogUtil.info("Keyword highlighted/visible successfully.");
    // page.waitForTimeout(15000);
    // }

    // public void search_With_TitleandContent_Using_OR_Operation(String
    // titlecontent) {
    // andSearch = page.locator("#and-search");
    // if (andSearch.isChecked()) {
    // andSearch.uncheck();
    // }

    // orSearch = page.locator("#or-search");
    // if (!orSearch.isChecked()) {
    // orSearch.check();
    // }
    // search = page.locator("//input[@id='home-search-input' or
    // @placeholder='Wiki内を検索']");
    // search.clear();
    // search.fill(titlecontent);
    // LogUtil.info("two words entered");

    // page.locator("//button[text()='検索']").click();
    // LogUtil.info("search button clicked");
    // LogUtil.info("Keyword highlighted/visible successfully.");
    // page.waitForTimeout(15000);
    // }

}