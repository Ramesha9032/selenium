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


public class ValidatingNavigationbar extends Baseclass{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Baseclass.class.getName());
	
@BeforeTest
public void beforetest() throws IOException{
	driver = initializeDriver();
	//driver.get("http://www.qaclickacademy.com/");
	driver.get(prop.getProperty("URL"));
}
	@Test
	public void barisdisplayed() throws IOException{
	
	LandingPage obj = new LandingPage(driver);
	
	Assert.assertTrue(obj.isdisplayedlandingpage().isDisplayed());
	log.info("object are displayed");
	///Assert.assertFalse(false); - it is for false statement 
	
	}
	
	@AfterTest
	public void closebrowser(){
		driver.close();
	}
}
