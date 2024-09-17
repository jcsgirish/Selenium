package selenium.Testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import seleniumauto.resources.ExtentReportertestNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReportertestNG.getReportObject();
	

    @Override
    public void onTestStart(ITestResult result) {
        // Code for when a test starts
    	test=extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "Test Passed");
    	
    	
        // Code for when a test succeeds
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code for when a test fails
    	test.fail(result.getThrowable());
    	try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code for when a test is skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code for partial test success
    }

    @Override
    public void onStart(ITestContext context) {
        // Code for when the test starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code for when the test finishes
    	extent.flush();
    }
}
