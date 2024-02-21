package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;
    // Desired Capabilities
    @BeforeClass
    public void setUp() throws MalformedURLException {
    UiAutomator2Options options = new UiAutomator2Options();
options.setPlatformName("android");
options.setAutomationName("UiAutomator2");
options.setAppPackage("com.android.chrome");
options.setAppActivity("com.google.android.apps.chrome.Main");
// Server Address
    URL serverURL = new URL("http://localhost:4723/wd/hub");
// Driver Initialization
    driver = new AndroidDriver(serverURL, options);
}
@Test
    void OpenUrlAndFectchTheDetailsInChrome()
{

    // Open the browser with the URL
    driver.get("https://www.training-support.net/");
// Locate heading on page and print it
    String pageTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
    System.out.println("Heading: " + pageTitle);


    String txtAboutUs =driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).click();
    System.out.println(txtAboutUs);
}
}
