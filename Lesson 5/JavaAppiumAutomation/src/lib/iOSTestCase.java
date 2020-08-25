package lib;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class iOSTestCase extends TestCase {
    //protected AppiumDriver driver;
    protected AppiumDriver driver;
    private static  String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName","iPhone Xs Max");
        capabilities.setCapability("platformVersion","13.6");
        capabilities.setCapability("app","/Users/asherstobitov/Desktop/JavaAppiumAutomation/apks/Wikipedia.app");
        driver = new IOSDriver( new URL(AppiumURL), capabilities);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.rotateScreenPortrait();
    }
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }
    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void backgroundApp(int milliSeconds)
    {
        driver.runAppInBackground(Duration.ofMillis(milliSeconds));
    }

}
