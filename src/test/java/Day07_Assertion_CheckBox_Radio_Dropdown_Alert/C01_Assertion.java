package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;

public class C01_Assertion {

    int p1Age = 66;
    int p2Age = 70;
    int p3Age = 77;
    int retirementAge = 70;

    @Test
    public void test01(){

//        if(p1Age > retirementAge){
//            System.out.println("test is passed");
//        }else{
//            System.out.println("test is failed");
//        }
       Assert.assertTrue(p1Age > retirementAge); // method underlined yellow, because statement is false
    }
    @Test
    public void test02(){


        Assert.assertFalse(p1Age > retirementAge);
    }

    @Test
    public void test03(){


        Assert.assertEquals(p2Age,retirementAge); //Assert.assertEquals(expected, actual)
        Assert.assertNotEquals(14,15);
    }


}
