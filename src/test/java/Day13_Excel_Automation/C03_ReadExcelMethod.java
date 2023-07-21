package Day13_Excel_Automation;

import Utilities.ReusableMethods;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcelMethod {

    @Test
    public void test() throws IOException {

        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(2));

        //let's use a method to get specific data
        ReusableMethods.getValueOfExcelFileUsingRowAndCell(filePath
        ,3, 2);

    }
}
