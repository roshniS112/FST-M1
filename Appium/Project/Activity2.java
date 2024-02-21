package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;
 String title="Title of new note";

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    void createNewNoteUsingGoogleKeepApp()
    {

        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys(title);
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("notes added for new note");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        String addedTitle= driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        Assert.assertEquals(addedTitle,title);

    }
}
