package Day12_10102020;

import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HTML_Bing_Search {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    @BeforeSuite
    public void setDriver(){
        driver = Reusable_Methods.getDriver();

        //define where you want to save the report(path)
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html",true);

    }//end of before suite

    @Test(priority = 1)
    public void Bing_Search() throws InterruptedException {
        logger = reports.startTest("Bing Search");
        logger.log(LogStatus.INFO,"Navigating to Bing home page");
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        Reusable_Methods_Loggers.submit(driver,"//*[@id='sb_form_go']",logger,"Search Button");
        Thread.sleep(2000);

        reports.endTest(logger);
    }//end of test

    @Test(priority = 2)
    public void Bing_Search_Result() throws InterruptedException {
        logger = reports.startTest("Bing Search Result");
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='sb_count']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[0]);
        //after all the test steps per @Test you must end the test as well
        reports.endTest(logger);
    }//end of test

    @AfterSuite
    public void closeSession(){
        reports.flush();
        driver.quit();

    }//end of after suite


}//end of java class
