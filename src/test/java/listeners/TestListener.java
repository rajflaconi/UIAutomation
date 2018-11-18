package listeners;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    ExtentTest logger;
    
    //Overriding methods of ITestLisener Interface
    
	public void onTestStart(ITestResult result) {
	
		logger = extent.createTest(result.getMethod().getMethodName());
		
	}
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " "+"is passed", ExtentColor.GREEN));
	 }
	 
		
	
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+" "+"is failed", ExtentColor.RED));
		  try {
			String screenshotPath = getScreenshot(driver, result.getName());
			
			logger.addScreenCaptureFromPath(screenshotPath, "Screenshot");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName()+ "is skipped", ExtentColor.YELLOW));
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {

		extent.flush();
		
		
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


}
