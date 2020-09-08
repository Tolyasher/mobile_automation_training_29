package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends  MainPageObject{
    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_RESULT_BY_TWO_SUBSTRINGS_TPL;

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    private static String getResultSearchElementByTwoOptions(String firstSubstring, String secondSubstring)
    {
        String stringAfterFirstReplace = SEARCH_RESULT_BY_TWO_SUBSTRINGS_TPL.replace("{firstSUBSTRING}", firstSubstring);

        return stringAfterFirstReplace.replace("{secondSUBSTRING}", secondSubstring);
    }
    /* TEMPLATES METHODS */

    public void waitForElementByTitleAndDescription(String title, String description)
    {
        String search_result_xpath = getResultSearchElementByTwoOptions(title, description);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title = '" + title + "' and description = '"+description+"'");
    }
    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click init element", 10);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot find search input after clicking search init element");
    }
    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON,"Cannot find search cancel button X",5);
    }
    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"Search cancel button X is still present",5);
    }
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }
    public void typeSearchLine (String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 10);
    }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }
    public void checkNoArticlesPresentWithThisTitle(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementNotPresent(search_result_xpath, "Cannot find search result with substring " + substring, 10);
    }
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring,10);
    }
    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything for search request: ",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }
    public void waitForEmptyResultsLable()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element",15);
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"We supposed not to find any results" );
    }
    public void assertArticleTitleHasText (String substring, String text_to_find)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.assertElementContainsText(
                search_result_xpath,
                text_to_find,
                "Articke title Does not contain word " + text_to_find,
                15
        );

    }

}