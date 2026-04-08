package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void openUrl(String url) {
        page.navigate(url);
    }

    public String getTitle() {
        return page.title();
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public void waitForLoaderToDisappear() {
        page.locator("//div[@class='spinner']")
                .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

}
