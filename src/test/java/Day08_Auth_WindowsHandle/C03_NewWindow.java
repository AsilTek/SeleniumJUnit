package Day08_Auth_WindowsHandle;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_NewWindow extends TestBase {
   // ● Create a new class: WindowHandle ● Go to the ● Assign Page's window handle to a String variable
   // ● Test if the page title contains “Amazon”
   // ● Create a new tab and go to wisequarter.com in the tab that opens
   // ● Test if the page title contains “wise quarter”
   // ● Create a new window and go to walmart.com on the page that opens
   // ● Test if the page title contains “Walmart”
   // ● Go back to the first page and test your return to the amazon page

    @Test
    public void test01(){
// ● Go to the
        driver.get("https://www.amazon.com/");
        String actualUrl = "https://www.amazon.com/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
//● Assign Page's window handle to a String variable
        String windowHandle = driver.getWindowHandle();
// ● Test if the page title contains “Amazon”
        System.out.println(driver.getTitle());
        String expectedTitle = driver.getTitle();
        String actualTitle = "Amazon";
        Assert.assertTrue(expectedTitle.contains(actualTitle));
// ● Create a new tab and go to wisequarter.com in the tab that opens
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com/");
// ● Test if the page title contains “wise quarter”
        System.out.println(driver.getTitle());
        String expectedTitle2 = driver.getTitle();
        String actualTitle2 = "Wise Quarter";
        Assert.assertTrue(expectedTitle2.contains(actualTitle2));
// ● Create a new window and go to walmart.com on the page that opens
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");
// ● Test if the page title contains “Walmart”
        System.out.println(driver.getTitle());
        String expectedTitle3 = driver.getTitle();
        String actualTitle3 = "Walmart";
        Assert.assertTrue(expectedTitle3.contains(actualTitle3));
// ● Go back to the first page and test your return to the amazon page
        driver.switchTo().window(windowHandle);
        Assert.assertTrue(expectedTitle.contains(actualTitle));

    }
}
