package lib.UI;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String
    MY_LISTS_LINK,
    CLOSE_TO_SYNC_BUTTON;
    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
    public void clickMyLists()
    {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find navigation button to My List",
                5
        );
    }
    public void clickCloseSync()
    {
        this.waitForElementAndClick(
                CLOSE_TO_SYNC_BUTTON,
                "Cannot find Close to sync button",
                5
        );
    }


}
