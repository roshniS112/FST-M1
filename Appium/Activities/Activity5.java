package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // var serverURL=new URI("http://localhost:4723/wd/hub"). toURL() ;

        // Driver Initialization
        //AppiumDriver, if you dunno its ios or android //server url and desired capabilities should be present accordingly
        //iosDriver for ios
        driver = new AndroidDriver(serverURL, options);
        //  WebDriverWait wait= new WebDriverWait(driver, Durations.ofSafeNanos(60));
    }

    // Test method
    @Test
     void testMessages()
    {
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/start_chat_fab")).click();


    }

}