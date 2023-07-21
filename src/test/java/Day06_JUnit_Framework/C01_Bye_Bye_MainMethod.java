package Day06_JUnit_Framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C01_Bye_Bye_MainMethod {

    @Before
    public void setupMethod(){
        System.out.println("setup method is executed");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown method is executed");
    }

    @Test
    public void test01(){
        System.out.println("test01 is executed");
    }

    @Test
    public void test02(){
        System.out.println("test02 is executed");
    }








}
