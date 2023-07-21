package Day09_WindowHandle_Action_Facer;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01(){
        //1- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2- Move the mouse over the menu to open the “Account & Lists” menu in the upper right section.
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[text() = 'Account & Lists']"));
        actions.moveToElement(element).perform();

        //3- Press the “Create a list” button
        WebElement listButton = driver.findElement(By.xpath("//span[text() = 'Create a List']"));
        listButton.click();

        //4- Test that "Your Lists" is written on the page that opens
        WebElement test = driver.findElement(By.xpath("//div[@aria-level = '1']"));
        System.out.println(test.getText());
        Assert.assertTrue(test.isDisplayed());
    }
}
