package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;

public class Activity3 {

    AndroidDriver driver;
    WebDriverWait wait;
    String title="Title of new note";

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    void addTasksInToDoList()
    {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
    driver.get("https://v1.training-support.net/selenium");
    driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        ArrayList<String> al= new ArrayList<String>();
        al.add("Add tasks to list");
        al.add("Get number of tasks");
        al.add("Clear the list");


            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        for(int i=0; i< al.size(); i++) {
            driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys(al.get(i));
            driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")).click();

        }
int size= driver.findElements(AppiumBy.id("//*[id='tasksList']/android.view.View")).size();
System.out.println(size);
    }

}
