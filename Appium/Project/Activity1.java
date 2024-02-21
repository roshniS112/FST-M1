package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity1 {

AndroidDriver driver;
WebDriverWait wait;
String task1="Complete Activity with Google Tasks";
String task2="Complete Activity with Google Keep";
String task3="Complete the second Activity Google Keep";
@BeforeClass
    public void setup() throws MalformedURLException {
    //Desired capabilities
    UiAutomator2Options options= new UiAutomator2Options();
    options.setPlatformName("android");
    options.setAutomationName("UiAutomator2");
    options.setAppPackage("com.google.android.apps.tasks");
    options.setAppActivity(".ui.TaskListsActivity");
    options.noReset();

    URL serverURL= new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver(serverURL, options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}

@Test
    void createListOfActivitiesUsingGoogleTasks()
{
    ArrayList<String> list1 = new ArrayList<String>();
    list1.add("Complete Activity with Google Tasks");
    list1.add("Complete Activity with Google Keep");
    list1.add("Complete the second Activity Google Keep");

    for ( String values   : list1) {
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(values);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    List<WebElement>  taskValues= driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
    int size = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).size();
    System.out.print("size" + size);
//    Assert.assertEquals(size,3);
    for(int i=0; i< size ;i++)
    {
        if(i==0) {
           String storedTask= taskValues.get(0).getText();
         boolean value=  (storedTask.contains(task1) ||
                 storedTask.contains(task2)  ||
                 storedTask.contains(task3));
System.out.print(value);
            Assert.assertTrue(value);
//       Assert.assertEquals(taskValues.get(0).getText(),"Complete Activity with Google Tasks");
        }
        if(i==1) {
            String storedTask= taskValues.get(0).getText();
            boolean value=  (storedTask.contains(task1) ||
                    storedTask.contains(task2)  ||
                    storedTask.contains(task3));
            System.out.print(value);
            Assert.assertTrue(value);
        }
        if(i==2) {
            String storedTask= taskValues.get(0).getText();
            boolean value=  (storedTask.contains(task1) ||
                    storedTask.contains(task2)  ||
                    storedTask.contains(task3));
            System.out.print(value);
            Assert.assertTrue(value);
        }

    }

}


    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }




}
