package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Create the required structure and complete the following task.
// a. Go to the given web page. https://facebook.com
// b. Accept cookies
// c. Press the Create an account button
// D. Locate the radio button elements and choose the one that suits you
public class C04_RadioButton {
  static WebDriver driver;
@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
    public void test01() throws InterruptedException {
    // a. Go to the given web page. https://facebook.com
    String facebookURL = "https://www.facebook.com/";
    driver.get(facebookURL);
    // b. Accept cookies
    // c. Press the Create an account button
    WebElement createButton = driver.findElement(By.xpath("(//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'])"));
    createButton.click();
    Thread.sleep(2000);

// D. Locate the radio button elements and choose the one that suits you
    WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value= '2']"));
    maleRadioButton.click();
    Assert.assertTrue(maleRadioButton.isSelected());
}

@AfterClass
    public static void teardown() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
}
}
