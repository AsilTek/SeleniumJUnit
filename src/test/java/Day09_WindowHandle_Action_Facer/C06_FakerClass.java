package Day09_WindowHandle_Action_Facer;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_FakerClass extends TestBase {

    @Test
    public void test01(){
        // 1 - Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //2 - Let's press the create new account button
        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[@rel='async']"));
        createNewAccountButton.click();

        //3 - Write the value in the name, surname, e-mail and password boxes and press the register button
        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        //4 - Let's hit the sign-up button
        WebElement signUp = driver.findElement(By.name("websubmit"));
        signUp.click();
    }
}
