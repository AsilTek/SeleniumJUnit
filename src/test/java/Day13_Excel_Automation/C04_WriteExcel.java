package Day13_Excel_Automation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void test() throws IOException {
        //to reach the cells we do following
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        //to write on the copied file we use createCell method
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("New Cell Value");

        //we should create FileOutputStream obj to kind of push the changes to original file
        FileOutputStream fos = new FileOutputStream(filePath);
        //we write changes to original file with the write method
        workbook.write(fos);

        workbook.close();
    }
}
