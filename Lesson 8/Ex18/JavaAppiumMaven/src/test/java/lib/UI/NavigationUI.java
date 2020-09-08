package lib.UI;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String
        MY_LISTS_LINK,
        CLOSE_TO_SYNC_BUTTON,
        OPEN_NAVIGATION;
    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
        if (Platform.getInstance().isMW())
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        else{
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(MY_LISTS_LINK, "Cannot find navigation button to My List", 5);
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My List",
                    5
            );
        }
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
