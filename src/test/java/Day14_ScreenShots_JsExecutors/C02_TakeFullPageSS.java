package Day14_ScreenShots_JsExecutors;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class C02_TakeFullPageSS extends TestBase {

    @Test
    public void test01(){

        //wisequarter
        driver.get("https://www.wisequarter.com/");

        //test that you are in wisequarter
        String expected = "Wise Quarter";
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expected));

        //taka a ss
        ReusableMethods.fullPageScreenShot(driver);
    }
}
