package lib.UI.mobile_web;


import lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions-watch a#ca-watch.mw-ui-icon-wikimedia-star-base20";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions-watch a#ca-watch.mw-ui-icon-wikimedia-unStar-progressive";
        DESCRIPTION = "id:Indonesian island";
        MY_LIST_LEARNING_PROGRAMMING_LIST = "id:org.wikipedia:id/item_title";

    }
    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
