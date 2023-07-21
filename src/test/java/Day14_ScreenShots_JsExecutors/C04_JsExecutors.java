package Day14_ScreenShots_JsExecutors;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C04_JsExecutors extends TestBase {

    @Test
    public  void  test01(){

         driver.get("https://www.amazon.com/");

        WebElement musicElement = driver.findElement(By.xpath("//a[text()='Music']"));
        //musicElement.click(); // regular way to click an element.

        //Let's use JS executors

        //1- We need to create Js executor obj

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //by using JS we will click
        js.executeScript("arguments[0].click()",musicElement); // JS way to click an element if regular click does not work.

        js.executeScript("alert(\"That's it\")");
    }
}
