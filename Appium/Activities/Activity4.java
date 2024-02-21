package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4

{
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
   public  void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.dialer");
        options.setAppActivity(".DialtactsActivity");
        options.noReset();
        URL serverURL= new URL("http://localhost:4723/wd/hub");
        driver= new AndroidDriver(serverURL,options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Test
    void testContacts()
    {
        int size =driver.findElements(AppiumBy.id("com.samsung.android.app.contacts:id/contact_list_item_main")).size();
        System.out.println(size);
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.app.contacts:id/arrowButton")));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/arrowButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.app.contacts:id/firstEdit")));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/firstEdit")).sendKeys("Aaditya");
//        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")).sendKeys("AutomateName");


        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward()"));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/lastEdit")).sendKeys("Varma");
//        driver.findElement(AppiumBy.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText']")).sendKeys("999148292");
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/titleText")).sendKeys("1234567890");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Save\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
        // Assertion
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");





    }
}
