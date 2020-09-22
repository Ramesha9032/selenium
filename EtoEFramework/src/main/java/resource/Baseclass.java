package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream file=new FileInputStream("E:\\BCSE4A\\EtoEFramework\\src\\main\\java\\resource\\Data.properties");
		
		prop.load(file); //to make connection between prop and file through "load"
		
		String browsername=prop.getProperty("browser");
		                 
		if (browsername.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\abc\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(browsername=="IE")
           {
			
			}
		
		else if (browsername=="UCbrowser")
		{
			
		}
		  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver; //after waited send back to the driver so that we used it in test cases
	
		}
	public void Screenshot(String testcasename,WebDriver driver) throws IOException{ //"testcasename" taken form listeners 
		
		TakesScreenshot ts=(TakesScreenshot) driver; //for responsible to take screenshot 
		File source=ts.getScreenshotAs(OutputType.FILE); //tells where screenshot file will capture
		//source - will creating for vertual memory //C://test//"+result+"screenshot.png
		//String destinationFile=System.getProperty("E:\\BCSE4A\\EtoEFramework\\Excel");//gives the current project location path
		String destinationFile=System.getProperty(("user.dir")+"\\reports\\"+testcasename+".png");		
		FileUtils.copyFile(source,new File(destinationFile));  // fetch the screenshot for virtual location to local system using FileUtiles
		
	}
}
