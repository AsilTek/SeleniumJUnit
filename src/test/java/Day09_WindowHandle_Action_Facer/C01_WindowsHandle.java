package Day09_WindowHandle_Action_Facer;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C01_WindowsHandle {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){

    // go to the "https://the-internet.herokuapp.com/iframe"
    driver.get("https://the-internet.herokuapp.com/iframe");

    // click on selenium link
        driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).click();

    //switching to newly opened tab after clicking
        String firstTabHandleValue = driver.getWindowHandle(); //the internet olan tab firsttab e atandi
        Set<String> handleValues = driver.getWindowHandles(); //tum tab'ler
        String secondTabHandleValue = "";

        for (String each : handleValues){
            if(!firstTabHandleValue.equals(each)){
                secondTabHandleValue = each; //burda elemantal selenium secondtab e atandi
            }
        }
        //now I can use secondHandle]value to switch the second tab

        driver.switchTo().window(secondTabHandleValue);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Elemental Selenium";
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        driver.findElement(By.linkText("Join the mailing list")).click();


        //Now switch back to first tab

        driver.switchTo().window(firstTabHandleValue);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        System.out.println(actualTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        //ReusableMethods.wait
    }


    @After
    public void teardown() throws InterruptedException {
        ReusableMethods.wait(4);
        //driver.close(); // closes only last tab
        driver.quit(); //closes all tabs
    }
}
