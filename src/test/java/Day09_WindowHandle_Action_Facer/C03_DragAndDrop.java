package Day09_WindowHandle_Action_Facer;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_DragAndDrop extends TestBase {

    @Test
    public void test01(){
        //Let's create a new class: MouseActions2--Already done!
        //1- Let's go to https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable");

        //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();
        ReusableMethods.wait(3);

        //3-  Test that,Instead of “Drop here” text “Dropped!” text is there
        WebElement text = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualText = text.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(actualText,expectedText);

    }
}
