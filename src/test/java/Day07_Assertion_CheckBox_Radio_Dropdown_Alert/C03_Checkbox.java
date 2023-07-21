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

/*
//Create the required structure and complete the following task.
    // a. Go to the : https://the-internet.herokuapp.com/checkboxes
    // b. Locate the checkbox1 and checkbox2 elements.
    // c. Click the checkbox if Checkbox1 is not selected
    // D. Click the checkbox if Checkbox2 is not selected
 */
public class C03_Checkbox {

    static WebDriver driver;
@BeforeClass
    public static void setup(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}
@Test
    public void test01(){
    // a. Go to the : https://the-internet.herokuapp.com/checkboxes
    String checkURL = "https://the-internet.herokuapp.com/checkboxes";
    driver.get(checkURL);
}
@Test
    public void test02() throws InterruptedException {
    // b. Locate the checkbox1 and checkbox2 elements.
    WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
    // c. Click the checkbox if Checkbox1 is not selected
    Thread.sleep(2000);
    if(!checkBox1.isSelected()){
        checkBox1.click();
        System.out.println("test for checkBox1 is passed");
    }else{
        System.out.println("test for checkBox1 is failed");
    }
    // D. Click the checkbox if Checkbox2 is not selected
    Thread.sleep(2000);
    if(!checkBox2.isSelected()){
        checkBox2.click();
        System.out.println("test for checkBox1 is passed");
    }else{
        System.out.println("test for checkBox1 is failed");
    }

}
@AfterClass
    public static void teardown() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
}

}
