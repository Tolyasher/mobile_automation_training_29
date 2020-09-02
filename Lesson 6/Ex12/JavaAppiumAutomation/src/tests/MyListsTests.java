package tests;

import lib.Platform;
import lib.UI.ArticlePageObject;
import lib.UI.MyListsPageObject;
import lib.UI.NavigationUI;
import lib.UI.SearchPageObject;
import lib.CoreTestCase;
import lib.UI.factories.ArticlePageObjectFactory;
import lib.UI.factories.MyListsPageObjectFactory;
import lib.UI.factories.NavigationUIFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveMyFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();

        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else{
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCancelSearch();
        }



        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();
        if (Platform.getInstance().isIOS()) {
            NavigationUI.clickCloseSync();
            NavigationUI.clickCloseSync();
        }
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticlesToMyList()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();

        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else{
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();

        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCancelSearch();
        }

        //Second article to the list
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.clickByArticleWithSubstring("Island of Indonesia");
        } else {
            SearchPageObject.clickByArticleWithSubstring("Indonesian island");
        }


        ArticlePageObject.waitForTitleElement();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyListWithExistingFolder(name_of_folder);
        }else{
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();

        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCancelSearch();
        }

        //Work with My List
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        if (Platform.getInstance().isIOS()) {
            NavigationUI.clickCloseSync();
            NavigationUI.clickCloseSync();
        }

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }

        MyListsPageObject.swipeByArticleToDelete(first_article_title);


        if(Platform.getInstance().isIOS()){
            ArticlePageObject.waitForDescriptionElement(); // New method
        } else {
            MyListsPageObject.clickByArticleWithSubstringFromMyLists("Java");
            ArticlePageObject.waitForTitleElement();
            String title_of_second_Article = ArticlePageObject.getArticleTitle();
            assertEquals("Title of the article is not 'Java'",
                title_of_second_Article,
                "Java"
            );
        }
    }
}
