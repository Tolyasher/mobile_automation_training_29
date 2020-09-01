package lib.UI;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

import java.util.concurrent.TimeUnit;

abstract public class MyListsPageObject extends MainPageObject{
    protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL,
    SWIPE_DELETE_BUTTON;

    /* TEMPLATES METHODS */
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    /* TEMPLATES METHODS */

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void openFolderByName (String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name "+ name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent( article_xpath,   "Cannot find saved article by title " + article_title,15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent( article_xpath,   "Saved article still present with title " + article_title,15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title) + "//..";
        System.out.println(article_xpath);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article "
        );
        if (Platform.getInstance().isIOS()){
            this.waitForElementAndClick(SWIPE_DELETE_BUTTON, "Cannot find swipe action delete button " + article_title,10);
            //this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article by title" + article_title);
        }
        this.waitForArticleToDisappearByTitle(article_title);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void clickByArticleWithSubstringFromMyLists(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementAndClick(article_xpath, "Cannot find saved article by title" + article_title,10);
    }

}
