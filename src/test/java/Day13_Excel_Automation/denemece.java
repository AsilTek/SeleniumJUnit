package Day13_Excel_Automation;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class denemece extends TestBase {

    @Test
    public void test01(){
//div[@role='columnheader'][3]
        driver.get("https://demoqa.com/webtables");

//        List<WebElement> headers = driver.findElements(By.xpath("//div[@role='columnheader']"));
//        for (int i = 0; i < headers.size(); i++) {
//            System.out.println(i+1 +". Header is: "+headers.get(i).getText());
//        }
//        WebElement thirdHeader = driver.findElement(By.xpath("(//div[@role='columnheader'])[3]"));
//        System.out.println(thirdHeader.getText());

        List<WebElement> allTableData = driver.findElements(By.xpath("//div[@role='grid']"));
        int count = 0;
      for (WebElement each : allTableData){
          if(!each.getText().isBlank()){
              System.out.println(each.getText());
              count++;
          }
          System.out.println("dolu olan : "+count);
        }
    }
}
