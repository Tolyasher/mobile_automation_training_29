package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.UI.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome()
    {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMW() ) {
            return;
        }
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForNewWaysToExploreText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForAddOrEditPreferredLangText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForLearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();

    }
}
