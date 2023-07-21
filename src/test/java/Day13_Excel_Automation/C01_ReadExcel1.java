package Day13_Excel_Automation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel1 {

    @Test
    public void test() throws IOException {

    //when we use Excel file, actually we are not using original file. We create a copy and work on it.

        //file path from content root
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";

        //adding file to project creating a fis obj
        FileInputStream fis = new FileInputStream(filePath);

        //we will create a copy of an Excel file to work on it
        Workbook workbook = WorkbookFactory.create(fis);

    //now we have a copy of Excel file and step by step we will try to reach the data

        Sheet sheet = workbook.getSheet("Sayfa1"); // reaching the specific(Sayfa1) Excel sheet

        //Let's try to reach row 5
        Row row = sheet.getRow(4); //Excel doc. works with index formation, so we enter 4 to reach 5

        //Let's reach 3rd Cell
        Cell cell = row.getCell(2);

        System.out.println("Value of the cell: "+cell);

    }
}
