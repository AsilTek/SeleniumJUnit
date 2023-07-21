package Day06_JUnit_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
// create 3 different test methods
// for each method create a driver
// 1) go to the https://www.amazon.com
// 2) wisequarter.com
// 3) youtube.com
// in all method print the title of the website
public class C02_Before_After {

WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Before is executed");

    }
    @After
    public void tearDown() throws InterruptedException {
        System.out.println("After is executed");
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test02(){
        driver.get("https://wisequarter.com/");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());

    }
}
