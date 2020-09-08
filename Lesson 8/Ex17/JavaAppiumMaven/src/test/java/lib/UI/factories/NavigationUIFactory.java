package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.ArticlePageObject;
import lib.UI.NavigationUI;
import lib.UI.android.AndroidArticlePageObject;
import lib.UI.android.AndroidNavigationUI;
import lib.UI.ios.iOSArticlePageObject;
import lib.UI.ios.iOSNavigationUI;
import lib.UI.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {
    public static NavigationUI get (RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else if ((Platform.getInstance().isIOS())){
            return new iOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }

    }
}
