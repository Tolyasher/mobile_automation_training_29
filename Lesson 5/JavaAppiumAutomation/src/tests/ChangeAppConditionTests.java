package tests;

import lib.UI.ArticlePageOblect;
import lib.UI.SearchPageObject;
import lib.CoreTestCase;
import org.junit.Test;
public class ChangeAppConditionTests extends CoreTestCase
{
    @Test
    public void testChangeScreenOrientationOnSearchResult()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageOblect ArticlePageOblect = new ArticlePageOblect(driver);
        String title_before_rotation = ArticlePageOblect.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageOblect.getArticleTitle();

        assertEquals(
                "Title of the article has been changed after rotation",
                title_before_rotation,
                title_after_rotation
        );
        this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageOblect.getArticleTitle();

        assertEquals(
                "Title of the article has been changed after rotation",
                title_after_rotation,
                title_after_second_rotation
        );
    }

    @Test
    public void testCheckSearchArticleInBackground()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(2000);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
}
