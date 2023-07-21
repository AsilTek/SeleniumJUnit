package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
// set required options
// go to the https://the-internet.herokuapp.com/javascript_alerts
// create 3 different methods to click jsAlerts
// handle them
public class C06_JSAlert {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test01() throws InterruptedException {
        // go to the https://the-internet.herokuapp.com/javascript_alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']"));
        Thread.sleep(2000);
        jsAlert.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }




    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
