package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.ArticlePageObject;

    public class iOSArticlePageObject extends ArticlePageObject {
        static {
            TITLE = "id:Java (programming language)";
            DESCRIPTION = "id:Indonesian island";
            FOOTER_ELEMENT = "id:View article in browser";
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
            MY_LIST_LEARNING_PROGRAMMING_LIST = "id:org.wikipedia:id/item_title";
            CLOSE_ARTICLE_BUTTON = "id:Back";
        }
        public iOSArticlePageObject(AppiumDriver driver)
        {
            super(driver);
        }

    }

