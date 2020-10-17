package Action_Items;

import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_AI {


    //declare all variables
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting the chrome driver
        driver = Reusable_Methods.getDriver();
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Kayak_AI.xls"));
        readableSheet = readableFile.getSheet(0);
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Kayak_AI_Results.xls"), readableFile);
        //Step 4: define the writable sheet for the writable file
        writableSheet = writableFile.getSheet(0);
        //Step 5: get the count of the rows that are not empty in excel workbook
        rowCount = writableSheet.getRows();
    }//end of set driver

    @Test
    public void totalCharges() throws InterruptedException, WriteException {

        //navigate to kayak homepage
        driver.navigate().to("https://www.kayak.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        if (actualTitle == "Kayak") {
            System.out.println(actualTitle);
        } else {
            System.out.println("The actual title is " + actualTitle);
        }//end of if else condition

        for (int i = 1; i < rowCount; i++) {
            //I need to get content of the cell
            //column is hard coded and row is dynamic(i)
            String airport = writableSheet.getCell(0, i).getContents();
            String startDate = writableSheet.getCell(1, i).getContents();
            String startTime = writableSheet.getCell(2, i).getContents();
            String endDate = writableSheet.getCell(3, i).getContents();
            String endTime = writableSheet.getCell(4, i).getContents();
            String vehicleSize = writableSheet.getCell(5, i).getContents();
            //empty out all cookies from your session
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
            /* below code is inspected before you clicking inside the search field
                 and I am using contains id property as initial portion of id value
                    is changing */
            Reusable_Methods.click(driver, "//*[contains(@id,'pickup-display')]", "Pick up Location");
            Reusable_Methods.sendKeys(driver, "//*[@name='pickup']", airport, "Airport");
            /* click on suggesting link once you type your airport
            orelse it will block your calendar so you need to click on suggested link */
            Reusable_Methods.click(driver, "//*[@class='smarty-item-icon']", "Choose Airport Link");
            //now put like 1 to 2 seconds then click on start date calendar icon
            Thread.sleep(2000);
            //line below is clicking on calendar icon first for start date
            Reusable_Methods.click(driver, "//*[contains(@id,'dateRangeInput-display-start-inner')]", "Start Date");
            Thread.sleep(1000);
            Reusable_Methods.typeAndSubmit(driver, "//*[contains(@id,'pickup-date-input')]", startDate, "Start Date");
            Thread.sleep(1000);
            /* element below is not interactable because you have to close the calendar so click anywhere outside
            like clicking on title search for hundred **/
            Reusable_Methods.click(driver, "//*[@class='title dark']", "Dark Title");
            //put like 1 second
            Thread.sleep(1000);
            //before you select the value from start time you need to click on start time icon first
            Reusable_Methods.click(driver, "//*[contains(@id,'start-time-select-display')]", "Start Time");
            /* also before clicking on the value you should put 1.5 to 2 seconds to slow down selenium
            orlese you will get element not interactable error **/
            Thread.sleep(2500);
            //now click on start time value
            Reusable_Methods.mouseClick(driver, "//*[@class='mpti-Title' and text()='"+vehicleSize+"']", "Start Time");

            Reusable_Methods.clickByIndex(driver,"",2,"View Deal");

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //redefine the arraylist when another tab opens after second tab
            ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(2));
            ArrayList<String> tabs3 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(3));


            //capturing the amount

        }//end of loop

    }//end of test

}//end of java class