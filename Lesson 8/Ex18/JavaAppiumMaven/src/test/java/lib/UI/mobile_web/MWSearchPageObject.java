package lib.UI.mobile_web;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        //SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']//..//XCUIElementTypeSearchField";
        //SEARCH_CANCEL_BUTTON = "id:Close";
        //SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_CANCEL_BUTTON = "css:button.mw-ui-icon.mw-ui-icon-mf-close-base20.mw-ui-icon-element.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        //SEARCH_RESULT_BY_TWO_SUBSTRINGS_TPL= "xpath://*[@name='{firstSUBSTRING}']//..//*[@name='{secondSUBSTRING}']//..";
        SEARCH_RESULT_BY_TWO_SUBSTRINGS_TPL= "xpath://*[@data-title='{firstSUBSTRING}']/div[contains(@class, 'wikidata-description')][contains(text(),'{secondSUBSTRING}')]";
    }
    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super (driver);
    }
}
