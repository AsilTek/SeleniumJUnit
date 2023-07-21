package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

/*
/ create 3 test method
    // 1) go to the amazon.com and test that you are in amazon.com
    // 2) search for nutella and test that you have searched for nutella
    // 3) test that there are more than 30 result of nutella
 */
public class C02_AssertMethods {

    static WebDriver driver;
@BeforeClass
    public static void setup(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
// 1) go to the amazon.com and test that you are in amazon.com
@Test
    public void test01() {

    String amazonURL = "https://www.amazon.com/";
    driver.get(amazonURL);
    String expected = amazonURL;
    String actual = driver.getCurrentUrl();
    Assert.assertEquals(expected,actual);
}
// 2) search for nutella and test that you have searched for nutella
@Test
public void test02(){
    String searchedText = "Nutella";
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys( searchedText + Keys.ENTER);

    WebElement resultText = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));
    String resultTextstr = resultText.getText();


    Assert.assertTrue("searched text is not in result text",resultTextstr.contains(searchedText));
}
    // 3) test that there are more than 30 result of nutella
 @Test
    public void test03(){
     WebElement resultText = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));
     String resultTextstr = resultText.getText();
     System.out.println(resultTextstr);
     String[] arr = resultTextstr.split(" ");
     System.out.println(Arrays.toString(arr));
     int actual = Integer.parseInt(arr[2]) ;
     int expected = 30;
     Assert.assertTrue(actual>expected);


 }

@AfterClass
    public static void teardown() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
}










}
