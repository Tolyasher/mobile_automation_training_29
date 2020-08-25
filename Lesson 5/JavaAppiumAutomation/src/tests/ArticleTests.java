package tests;

import lib.UI.ArticlePageOblect;
import lib.UI.SearchPageObject;
import lib.CoreTestCase;
import org.junit.Test;
public class ArticleTests extends CoreTestCase
{
    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageOblect ArticlePageOblect = new ArticlePageOblect(driver);
        ArticlePageOblect.waitForTitleElement();
        String article_title = ArticlePageOblect.getArticleTitle();
        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }
    @Test
    public void testSwipeArticle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageOblect ArticlePageOblect = new ArticlePageOblect(driver);
        ArticlePageOblect.waitForTitleElement();
        ArticlePageOblect.swipeToFooter();
    }
}
