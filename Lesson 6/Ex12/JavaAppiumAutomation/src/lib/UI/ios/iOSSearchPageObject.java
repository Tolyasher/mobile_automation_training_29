package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']";
        //SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']//..//XCUIElementTypeSearchField";
        //SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath:XCUIElementTypeOther";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_RESULT_BY_TWO_SUBSTRINGS_TPL= "xpath://*[@name='{firstSUBSTRING}']//..//*[@name='{secondSUBSTRING}']//..";
    }
    public iOSSearchPageObject (AppiumDriver driver)
    {
        super (driver);
    }
}
