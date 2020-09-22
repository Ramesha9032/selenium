package SeleniumProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Baseclass;
import resource.ExtracterreporterNG;

public class Listeners extends Baseclass implements ITestListener {
	
	ExtentReports extent = ExtracterreporterNG.getReportObject();
	
	ExtentTest test; //Globally declared for to fetch "test" in all methods
	
	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
			test= extent.createTest(result.getMethod().getMethodName());	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		test.log(Status.PASS, "TestPassed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		WebDriver driver = null;
		String Testcasemethodname = result.getMethod().getMethodName(); // helps to take the method name which has failed
		try{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
		
		try {
			Screenshot(Testcasemethodname, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
public void onFinish(ITestContext context) { //once all test cases are executed 
		
		extent.flush(); //generating the report we have to flash the extent
	}  // ITesrListeners - listeners interfaces

}
