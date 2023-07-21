package Day11_Cookies_Tables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test01(){
        //Go to "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        //Scroll to the bottom of the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //Print the entire body of the web table
        WebElement table = driver.findElement(By.xpath("//tbody"));

        //System.out.println(table.getText()); We were not able to print whole body
        //Test that the number of rows in the web table is 12
        //Print all lines
        List<WebElement> wholeBody = driver.findElements(By.xpath("//tbody/tr"));
        int expectedNumberOfRows = 12;
        int actualNumberOfRows = wholeBody.size();
        for (WebElement each : wholeBody){
            System.out.println(each.getText());
        }

        //Test that the number of columns in the web table is 12
        List<WebElement> columnNumber = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedNumberOfColumns = 12;
        int actualNumberOfColumns= columnNumber.size();
        Assert.assertEquals(expectedNumberOfColumns,actualNumberOfColumns);

        //print column 5
        List<WebElement> columnFive = driver.findElements(By.xpath("//tbody/tr[5]/td"));
        for (WebElement each : columnFive){
            System.out.println(each.getText());
        }

        //Create a method that takes the number of rows and columns as parameters and returns the information in the cell
        valueOfCell(3,7);
    }

    private String valueOfCell(int row, int column) {

        System.out.println("--------------------------------------------");
        String xpath = "//tbody/tr["+row+" ]/td["+column + "]";
        WebElement cellValueOfTable = driver.findElement(By.xpath(xpath));

        return cellValueOfTable.getText();
    }
}
