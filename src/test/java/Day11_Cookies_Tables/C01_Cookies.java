package Day11_Cookies_Tables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01(){
        //1- Go to Amazon homepage
        driver.get("https://www.amazon.com/");

        //2- list all cookies
        Set<Cookie> cookieSet= driver.manage().getCookies();

        int number = 1;
        for (Cookie eachCookie : cookieSet){
            System.out.println(number+ " -)"+eachCookie);
            number++;
        }
        //3- Test that the number of cookies on the page is greater than 5
        int expectedCookies = 5;
        int actualCookies = cookieSet.size();
        Assert.assertTrue(actualCookies > expectedCookies);

        //4- Test the value of the cookie with the name i18n-prefs is USD
        String expectedCookieValue = "USD";
        String actualCookieValue = "";
        for (Cookie eachCookie : cookieSet){
            if(eachCookie.getName().equals("i18n-prefs")){
                actualCookieValue = eachCookie.getValue();
            }
        }
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5- Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
        Cookie myCookie = new Cookie("my favorite cookie","chocolate");
        driver.manage().addCookie(myCookie);

        //6- test that the cookie you added is added to the page
        Set<Cookie> amazonAddedCookies = driver.manage().getCookies();
        System.out.println("-----------------------------------------");
        int number2 = 1;
        for (Cookie eachCookie : amazonAddedCookies) {
            System.out.println(number2+ "-)"+ eachCookie);
            number2++;
        }
        //Validate it is added
        Assert.assertEquals(cookieSet.size()+1,amazonAddedCookies.size());
        //2nd way to validate
        boolean haveCookie = false;
        for (Cookie eachCookie : amazonAddedCookies){
            if(eachCookie.getName().equals("my favorite cookie")){
                haveCookie = true;
            }
        }
        Assert.assertTrue(haveCookie);
        //7- Delete the cookie whose name is skin and test it is deleted
        driver.manage().deleteCookieNamed("skin");
        Set<Cookie> amazonDeletedCookie = driver.manage().getCookies();
        boolean skinCookie = true;
        for (Cookie eachCookie : amazonDeletedCookie){
            if(eachCookie.getName().equals("skin")){
                skinCookie = false;
            }
        }
        Assert.assertTrue(skinCookie);

        //8- delete all cookies and test if they are deleted
        driver.manage().deleteAllCookies();
        amazonDeletedCookie = driver.manage().getCookies();

        Assert.assertEquals(0,amazonDeletedCookie.size());

    }
}
