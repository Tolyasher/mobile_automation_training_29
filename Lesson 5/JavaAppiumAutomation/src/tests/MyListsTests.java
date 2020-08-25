package tests;

import lib.UI.ArticlePageOblect;
import lib.UI.MyListsPageObject;
import lib.UI.NavigationUI;
import lib.UI.SearchPageObject;
import lib.CoreTestCase;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testSaveMyFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageOblect ArticlePageOblect = new ArticlePageOblect(driver);
        ArticlePageOblect.waitForTitleElement();
        String article_title = ArticlePageOblect.getArticleTitle();
        String name_of_folder = "Learning programming";
        System.out.println(article_title);
        System.out.println(name_of_folder);
        ArticlePageOblect.addArticleToMyList(name_of_folder);
        ArticlePageOblect.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticlesToMyList()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageOblect ArticlePageOblect = new ArticlePageOblect(driver);
        ArticlePageOblect.waitForTitleElement();
        String first_article_title = ArticlePageOblect.getArticleTitle();
        String name_of_folder = "Learning programming";
        System.out.println(first_article_title);
        System.out.println(name_of_folder);
        ArticlePageOblect.addArticleToMyList(name_of_folder);
        ArticlePageOblect.closeArticle();

        //Second article to the list
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Island of Indonesia");
        ArticlePageOblect.waitForTitleElement();
        ArticlePageOblect.addArticleToMyListWithExistingFolder(name_of_folder);
        ArticlePageOblect.closeArticle();

        //Work with My List
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(first_article_title);
        MyListsPageObject.clickByArticleWithSubstringFromMyLists("Java");
        ArticlePageOblect.waitForTitleElement();
        String title_of_Article = ArticlePageOblect.getArticleTitle();

        assertEquals(
                "Title of the article is not 'Java'",
                title_of_Article,
                "Java"
        );
    }
}
