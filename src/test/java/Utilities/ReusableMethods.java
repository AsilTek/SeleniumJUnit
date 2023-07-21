package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void wait(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getValueOfExcelFileUsingRowAndCell(String filePath, int row, int cell) {

        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);

        } catch (IOException e) {

        }
        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(2));


    }

    public static void fullPageScreenShot(WebDriver driver) {

        //1 Create a TakesScreenShot class object
        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyMMddHHmmss");
        String date = ldt.format(dtf);

        //2 Create a file path for ss to save
        String filePath = "target/fullPageSs/ScreenShotSS"+ date +".jpeg";

        //3 Create file
        File fullPageSS = new File(filePath);

        //4 Creating temp file to save ss
        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        //5 Copying ss from temp file to original file
        try {
            FileUtils.copyFile(tempFile,fullPageSS);
        } catch (IOException e) {
        }
    }

    public static void getSSofWebElement(WebElement result){

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyMMddHHmmss");
        String date = ldt.format(dtf);
        String filePath = "target/SSofDesiredWebElement/SsOfDesiredElement"+ date + ".jpeg";

        //original file
        File elementSS = new File(filePath);
        //temp file
        File tempFile = result.getScreenshotAs(OutputType.FILE);

        //copy from temp to original
        try {
            FileUtils.copyFile(tempFile,elementSS);
        } catch (IOException e) {

        }

    }
}
