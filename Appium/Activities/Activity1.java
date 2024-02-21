package activities;
import dev.failsafe.internal.util.Durations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;



public class Activity1 {

        // Driver Declaration
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
        public void multiplyTest() {
            // Perform the calculation
            driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
            driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
            driver.findElement(AppiumBy.id("calc_keypad_btn_08")).click();
            driver.findElement(AppiumBy.accessibilityId("Calculation")).click();

            // Find the result
            String res[]= driver.findElement(AppiumBy.id("calc_edt_formula")).getText().split(" ");
            String result=res[0];
            // Assertion
            Assert.assertEquals(result, "40");
        }


        // Tear down method
        @AfterClass
        public void tearDown() {
            // Close the app
            driver.quit();
        }
    }

