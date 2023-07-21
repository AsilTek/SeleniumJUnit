package Day12_WebTable_Excel;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01(){
        //Go to “https://demoqa.com/webtables” page
        driver.get("https://demoqa.com/webtables");

        //Print the headers found in Headers
        WebElement headers = driver.findElement(By.cssSelector("[class='rt-thead -header']"));
        System.out.println(headers.getText());

        //Print the title of the 3rd column
        List<WebElement> titleList = driver.findElements(By.cssSelector("[class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println(titleList.get(2).getText()); //Age

        //Print all the data in the table
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        WebElement allTableData = driver.findElement(By.xpath("//div[@class = 'rt-table']"));
        System.out.println(allTableData.getText());

        //Print how many non-empty cells (data) are in the table
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        List<WebElement> allCells = driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each : allCells) {
            if (!(each.getText().equals("") || each.getText().equals(" "))) {
                System.out.println(each.getText());
            }
        }
        //Print the number of rows in the table
        List<WebElement> rowList = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println(rowList.size());
        //Print the number of columns in the table
        List<WebElement> colList = driver.findElements(By.xpath("(//div[@role='row'])[1]/div"));
        System.out.println(colList.size());//7

        //Print the 3rd column in the table
        System.out.println(titleList.get(2).getText()); // this will print everything at once

        //Print 3rd column data one by one
        System.out.println("****************************************************************");
        List<WebElement> thirdColumnData = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[3]"));
        for (WebElement each: thirdColumnData) {
            System.out.println(each.getText());
        }


        //Print the Salary of the person whose "First Name" is Kierra in the table

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        for(int i=0; i<allCells.size(); i++){
            if(allCells.get(i).getText().equals("Kierra")){
                System.out.println("Salary of Kierra: " + allCells.get(i+4).getText());
            }
        }

        //Create a method on the Page page, it will print the data for me when I enter the number of rows and columns from the Test page.

        WebElement cell1And4 = getTablevalueUsingRowAndColumn(1, 4);
        System.out.println(cell1And4.getText());
    }

    public WebElement getTablevalueUsingRowAndColumn(int row, int column) {

        //       //div[@class='rt-tr-group'][  1    ]//div[   4   ]
        String xpath = "//div[@class='rt-tr-group'][" + row +  "]//div["+ column +"]";
        WebElement valueOfElement = driver.findElement(By.xpath(xpath));

        return valueOfElement;
    }

}
