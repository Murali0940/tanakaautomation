package org.pages;

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
        LogUtil.info("*****search with title*****");
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }

        LogUtil.info("title checkbox checked");

        Locator contentSearch = page.locator("#content-search");
        if (contentSearch.isChecked()) {
            contentSearch.uncheck();
        }
        LogUtil.info("content search checkbox unchecked");

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
        LogUtil.info("*****search with content*****");
        Locator titleSearch = page.locator("#title-search");
        if (titleSearch.isChecked()) {
            titleSearch.uncheck();
        }
        LogUtil.info("title search checkbox unchecked");

        search = page.locator("#content-search");
        if (!search.isChecked()) {
            search.check();
        }
        LogUtil.info("content search checkbox checked");
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
        LogUtil.info("*****search with title and content*****");
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }
        LogUtil.info("title search checkbox checked");

        Locator contentSearch = page.locator("#content-search");
        if (!contentSearch.isChecked()) {
            contentSearch.check();
        }
        LogUtil.info("content search checkbox checked");
        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill(titleandContent);
        LogUtil.info("keyword entered");

        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);
    }

    public void searchWithTitleAndContentUsingANDOperation(String string) {
        LogUtil.info("*****search with title and content using AND operation*****");
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }
        LogUtil.info("title search checkbox checked");

        Locator contentSearch = page.locator("#content-search");
        if (!contentSearch.isChecked()) {
            contentSearch.check();
        }

        LogUtil.info("content search checkbox checked");

        andSearch = page.locator("#and-search");
        if (!andSearch.isChecked()) {
            andSearch.check();
        }
        LogUtil.info("AND search checkbox checked");

        orSearch = page.locator("#or-search");
        if (orSearch.isChecked()) {
            orSearch.uncheck();
        }
        LogUtil.info("OR search checkbox unchecked");

        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill("and,operation");
        LogUtil.info("keyword entered");

        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);
    }

    public void searchWithTitleAndContentUsingOROperation(String string) {
        LogUtil.info("*****search with title and content using OR operation*****");
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }
        LogUtil.info("title search checkbox checked");

        Locator contentSearch = page.locator("#content-search");
        if (!contentSearch.isChecked()) {
            contentSearch.check();
        }
        LogUtil.info("content search checkbox checked");

        orSearch = page.locator("#or-search");
        if (!orSearch.isChecked()) {
            orSearch.check();
        }
        LogUtil.info("OR search checkbox checked");

        andSearch = page.locator("#and-search");
        if (andSearch.isChecked()) {
            andSearch.uncheck();
        }
        LogUtil.info("AND search checkbox unchecked");

        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill("or,operation");
        LogUtil.info("keyword entered");

        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);
    }

    public void searchWithinCategoryUsingTitle(String text) {
        LogUtil.info("*****search within category using title*****");

        page.locator("#searchin-category").click();
        LogUtil.info("search in category checkbox checked");

        LogUtil.info("Selecting Category");
        Locator item = page.locator("li").filter(new Locator.FilterOptions().setHasText("9999"));
        item.click();
        LogUtil.info("Category selected");
        Locator titleSearch = page.locator("#title-search");
        if (!titleSearch.isChecked()) {
            titleSearch.check();
        }
        LogUtil.info("title search checkbox checked");

        Locator contentSearch = page.locator("#content-search");
        if (contentSearch.isChecked()) {
            contentSearch.uncheck();
        }
        LogUtil.info("content search checkbox unchecked");

        orSearch = page.locator("#or-search");
        if (!orSearch.isChecked()) {
            orSearch.check();
        }
        LogUtil.info("OR search checkbox checked");

        andSearch = page.locator("#and-search");
        if (andSearch.isChecked()) {
            andSearch.uncheck();
        }
        LogUtil.info("AND search checkbox unchecked");

        search = page.locator("//input[@id='home-search-input' or @placeholder='Wiki内を検索']");
        search.clear();
        search.fill(text);
        LogUtil.info("keyword entered");

        page.locator("//button[text()='検索']").click();
        LogUtil.info("search button clicked");
        LogUtil.info("Keyword highlighted/visible successfully.");
        page.waitForTimeout(15000);

    }

}