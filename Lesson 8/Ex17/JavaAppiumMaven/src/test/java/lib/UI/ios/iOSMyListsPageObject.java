package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        SWIPE_DELETE_BUTTON = "id:swipe action delete";
        //ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        //SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
    }
    public iOSMyListsPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
