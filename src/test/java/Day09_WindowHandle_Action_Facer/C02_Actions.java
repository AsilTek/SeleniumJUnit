package Day09_WindowHandle_Action_Facer;

import Day08_Auth_WindowsHandle.C01_Authentication;
import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C02_Actions extends TestBase {

    //1- Let's create a new class: MouseActions1
    @Test
    public void test01(){
        //2- Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Right-click on the drawn area
        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver); //this action object will help me to do mouse and keyboard actions.
        action.contextClick(rightClickArea).perform(); //contextClick means right-click
        ReusableMethods.wait(3);

        //4- Test that the text in Alert is “You selected a context menu”.
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(actualAlertText,expectedAlertText);
        ReusableMethods.wait(3);

        //5- Let's close the alert by saying OK
        driver.switchTo().alert().accept();

        //6- Click on Elemental Selenium link
        WebElement link = driver.findElement(By.linkText("Elemantal Selenium"));
        link.click();

        //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
        //tip: C01_WindowsHandle
    }
}
