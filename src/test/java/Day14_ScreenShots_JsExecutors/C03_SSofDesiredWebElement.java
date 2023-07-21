package Day14_ScreenShots_JsExecutors;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_SSofDesiredWebElement extends TestBase {

    @Test
    public void test01() throws IOException {

        // go the amazon.com
        driver.get("https://www.amazon.com/");

        // write Nutella to searchbox
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // and test that result has nutella keyword
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedResult = "Nutella";
        String actualResult = result.getText();
        System.out.println(actualResult);
        //Assert.assertEquals(expectedResult, actualResult);

        //take ss of result element


//        //create file path
//
//        LocalDateTime ldt = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyMMddHHmmss");
//        String date = ldt.format(dtf);
//        String filePath = "target/SSofDesiredWebElement/SsOfDesiredElement"+ date + ".jpeg";
//
//        //original file
//        File elementSS = new File(filePath);
//        //temp file
//        File tempFile = result.getScreenshotAs(OutputType.FILE);
//
//        //copy from temp to original
//        FileUtils.copyFile(tempFile,elementSS);

        ReusableMethods.getSSofWebElement(result);

    }
}
