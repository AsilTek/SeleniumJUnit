package Day13_Excel_Automation;

import com.sun.source.tree.Tree;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel2 {

    @Test
    public void test() throws IOException {
        //file path from content root
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";

        //adding file to project creating a fis obj
        FileInputStream fis = new FileInputStream(filePath);

        //we will create a copy of an Excel file to work on it
        Workbook workbook = WorkbookFactory.create(fis);

    //-----------------Question1 below -------------------------

    // let's reach row 2 and column 2 of sheet named Sayfa1
        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(1)); //Kabul

    //  test that 2. row and 4.cell value is Kabil
        String expectedValue = "Kabil";
        String actualValue = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedValue, actualValue);

    // let's try to find how many rows are being used in sheet named Sayfa2
        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum()); // 23 // reaching Sayfa 2 and returns number of rows(empty rows are included)

    // try to find how many used rows we have in the second sheet
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()); //8 reaching Sayfa 2 and returns number of rows(empty rows are excluded)

    //Let's create a map from excel doc
        Map<String,String> contriesMap = new TreeMap<>();

        String key = "";
        String value = "";
        int lastRowNumberOfSheet = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 1; i <lastRowNumberOfSheet; i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + "-"+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() +"-"+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            contriesMap.put(key,value);

        }
        System.out.println(contriesMap);

        for (String each: contriesMap.keySet()){
            System.out.println(each);
            System.out.println(": "+ contriesMap.get(each));
        }
    }



}
