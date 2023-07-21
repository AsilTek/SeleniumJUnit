package Day14_ScreenShots_JsExecutors;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class C01_TakeScreenShotOfFullPage extends TestBase {

    @Test
    public void test01() throws IOException {

        // go the amazon.com
        driver.get("https://www.amazon.com/");

        // write Nutella to searchbox
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // and test that result has nutella keyword
        WebElement result = driver.findElement(By.xpath("//span[text()='1-48 of 107 results for']"));
        String expectedResult = "Nutella";
        String actualResult = result.getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);

        //Take a screenshot of full page

        //1 Create a TakesScreenShot class object
        TakesScreenshot tss = (TakesScreenshot) driver;

        //2 Create a file path for ss
        String filePath = "target/fullPageSs/ScreenShotSS.jpeg";

        //3 Create file
        File fullPageSS = new File(filePath);

        //4 Creating temp file to save ss
        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        //5 Copying ss from temp file to original file
        FileUtils.copyFile(tempFile,fullPageSS);

//Let's write a method to take a screenshot for above steps !!!

        ReusableMethods.fullPageScreenShot(driver);

    }
}
