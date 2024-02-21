package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {


    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity(".Calculator");
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
    public void addTest() {
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_09")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String res[]= driver.findElement(AppiumBy.id("calc_edt_formula")).getText().split(" ");
        String result=res[0];
        // Assertion
        Assert.assertEquals(result, "14");
    }
    @Test
    public void SubtractTest() {
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"0\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String res[]= driver.findElement(AppiumBy.id("calc_edt_formula")).getText().split(" ");
        String result=res[0];
        // Assertion
        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiplyTest() {
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"0\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"0\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String res[]= driver.findElement(AppiumBy.id("calc_edt_formula")).getText().split(" ");
        String result=res[0];
        // Assertion
        Assert.assertEquals(result, "500");
    }

    @Test
    public void DivideTest() {
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"0\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String res[]= driver.findElement(AppiumBy.id("calc_edt_formula")).getText().split(" ");
        String result=res[0];
        // Assertion
        Assert.assertEquals(result, "25");
    }
}
