package lib.UI.mobile_web;

import lib.UI.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static{
        //MY_LISTS_LINK = "id:Saved";
        MY_LISTS_LINK = "css:a[data-event-name='menu.unStar']";
        CLOSE_TO_SYNC_BUTTON ="id:Close";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
        //CLOSE_TO_SYNC_BUTTON ="xpath://XCUIElementTypeButton[@name='Close']";
        //XCUIElementTypeButton[@name="Close"]
    }
    public MWNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
