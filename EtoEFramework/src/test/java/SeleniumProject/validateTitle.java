package SeleniumProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;


import resource.Baseclass;


public class validateTitle extends Baseclass{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void befretest() throws IOException{
		driver=initializeDriver(); // "initializeDriver()method return the driver and put in driver object
	log.info("Driver is initialized");	                                          //driver.get("http://www.qaclickacademy.com/");
		driver.get(prop.getProperty("URL"));
		log.info("Navigate to Home page");
	}
 
	@Test
	public void basepagenavigation() throws IOException, InterruptedException {
		
		
		
		LandingPage obj = new LandingPage(driver);
		
		//Compare the text from the browser with actual text - its any mismatch then it get error
		Assert.assertEquals(obj.titlegettext().getText(), "FEATURED COURSES123");
		log.info("Successfully validated Text message");
		
		//obj.tital().getText(); - this is a actual result so mentioned in actual
	     
}
	@AfterTest
	public void closebrowse()
	{
		driver.close();
	}
		}

