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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDown {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        WebElement dropDown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Baby"); //picking/displaying wanted element from the dropdown list.
        String expectedOption = "Baby";
        String actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);

        //Printing all elements under the dropdown list
        List<WebElement> list = select.getOptions();
        for (WebElement each : list){
            System.out.println(each.getText());
        }
        System.out.println(list.size()); //how many element under dropdown list

        //bringing elements from dropdown list by index number
        select.selectByIndex(10);
        System.out.println(select.getFirstSelectedOption().getText());

        //bringing elements from dropdown list by HTML value
        select.selectByValue("search-alias=alexa-skills");
        System.out.println(select.getFirstSelectedOption().getText());


    }



    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
