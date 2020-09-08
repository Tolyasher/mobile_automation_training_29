package tests;

import lib.Platform;
import lib.UI.*;
import lib.CoreTestCase;
import lib.UI.factories.ArticlePageObjectFactory;
import lib.UI.factories.MyListsPageObjectFactory;
import lib.UI.factories.NavigationUIFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String login = "Tolyasher";
    private static final String password = "Predator170";

    @Test
    public void testSaveMyFirstArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();

        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else{
            ArticlePageObject.addArticleToMySaved();
        }
        Thread.sleep(5000);

        if (Platform.getInstance().isMW()){

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Thread.sleep(5000);
            Auth.enterLoginData(login, password);
            Thread.sleep(5000);
            Auth.submitForm();
            Thread.sleep(5000);
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login.", article_title, ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticleToMySaved();
        }
        Thread.sleep(5000);

        ArticlePageObject.closeArticle();

        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCancelSearch();
        }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        Thread.sleep(5000);

        NavigationUI.clickMyLists();

        Thread.sleep(5000);

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
    public void testSaveTwoArticlesToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();

        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else{
            ArticlePageObject.addArticleToMySaved();
        }

        Thread.sleep(5000);

        if (Platform.getInstance().isMW()){

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Thread.sleep(5000);
            Auth.enterLoginData(login, password);
            Thread.sleep(5000);
            Auth.submitForm();
            Thread.sleep(5000);
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login.", first_article_title, ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticleToMySaved();
        }
        Thread.sleep(5000);

        ArticlePageObject.closeArticle();

        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCancelSearch();
        }

        Thread.sleep(5000);

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
        Thread.sleep(10000);


        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        Thread.sleep(5000);

        NavigationUI.clickMyLists();

        Thread.sleep(5000);

        if (Platform.getInstance().isIOS()) {
            NavigationUI.clickCloseSync();
            NavigationUI.clickCloseSync();
        }

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        System.out.println("I am here 2");
        Thread.sleep(5000);
        MyListsPageObject.swipeByArticleToDelete(first_article_title);

        System.out.println("I am here 3");
        Thread.sleep(5000);

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
