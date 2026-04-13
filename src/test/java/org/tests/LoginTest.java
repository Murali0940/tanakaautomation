package org.tests;

import org.base.BaseClass;
import org.pages.*;
import org.testng.annotations.*;

@Listeners(org.listeners.TestListener.class)
public class LoginTest extends BaseClass {

    SearchFunction homePage;

    @BeforeMethod
    public void init() {
        homePage = new SearchFunction(page);
    }

    @Test(priority = 1)
    public void search_With_Title() {
        homePage.searchWithTitle("Test2article");
    }

    @Test(priority = 2)
    public void search_With_Content() {
        homePage.searchWithContent("purpose");
    }

    @Test(priority = 3)
    public void search_With_Title_And_Content() {
        homePage.searchWithTitleAndContent("test,purpose");
    }

    @Test(priority = 4)
    public void search_With_Title_And_Content_Using_AND_Operation() {
        homePage.searchWithTitleAndContentUsingANDOperation("test,article");
    }

    @Test(priority = 5)
    public void search_With_Title_And_Content_Using_OR_Operation() {
        homePage.searchWithTitleAndContentUsingOROperation("test,purpose");
    }

    @Test(priority = 6)
    public void search_Within_Category_Using_Title() {
        homePage.searchWithinCategoryUsingTitle("test");
    }

    @Test(priority = 7)
    public void search_Within_Category_Using_Content() {
        homePage.searchWithinCategoryUsingContent("purpose");
    }

}