package resources;

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
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver; 
	// if you give as private then we can not use from other class
	public Properties prop; // we used as public so we can inherit from all class
	public WebDriver initializDriver() throws IOException
	{
		 prop = new Properties(); //removed Properties because we drived a method "public Properties prop;"
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Mavenjava\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\abc\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox")) // dont use == bec we are sending property not a value ex:browser=Chrome(chrome is a value of browser property)
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}
}
 