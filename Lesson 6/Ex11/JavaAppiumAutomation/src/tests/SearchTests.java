package tests;

import lib.UI.SearchPageObject;
import lib.CoreTestCase;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearch() //throws InterruptedException
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "fsdrgsdfgsdfg";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLable();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testCheckIfSomeArticlesFoundAndThenCanceled()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForSearchResult("Island of Indonesia");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.checkNoArticlesPresentWithThisTitle("Object-oriented programming language");
        SearchPageObject.checkNoArticlesPresentWithThisTitle("Island of Indonesia");
    }

    @Test
    public void testCheckIfAllSearchResultsHaveRequiredText()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.assertArticleTitleHasText("Java", "Java");
        SearchPageObject.assertArticleTitleHasText("Java (programming language)", "Java");
        SearchPageObject.assertArticleTitleHasText("JavaScript", "Java");
        SearchPageObject.assertArticleTitleHasText("Java (software platform)", "Java");
    }
    @Test
    public void testCheckIfSomeArticlesFoundByTitleAndDescription()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForElementByTitleAndDescription("Java","Island of Indonesia");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)","Object-oriented programming language");
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript","Programming language");
        //SearchPageObject.waitForElementByTitleAndDescription("Java (software platform)","Set of several computer software products and specifications");
    }
}
