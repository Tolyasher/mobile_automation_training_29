package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI {
    static{
        MY_LISTS_LINK = "id:Saved";
        CLOSE_TO_SYNC_BUTTON ="id:Close";
        //CLOSE_TO_SYNC_BUTTON ="xpath://XCUIElementTypeButton[@name='Close']";
        //XCUIElementTypeButton[@name="Close"]
    }
    public iOSNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
