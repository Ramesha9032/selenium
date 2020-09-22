package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtracterreporterNG {
	static ExtentReports extent; // if we create static then no need to create object in listeners class
	
	public static ExtentReports getReportObject(){
		{
			
			
			String path =System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			//ExtentSparkReporter - it is a reporter 
			reporter.config().setReportName("Web Automation Results"); //report name 
			reporter.config().setDocumentTitle("Test Results");  // document name
			
			 extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Rahul Shetty");
			return extent;
			
		}
	}
}
