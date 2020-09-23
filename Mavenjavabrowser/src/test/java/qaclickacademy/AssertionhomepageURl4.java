package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.loginpage;
import resources.base;

//Adding logs
//generating html report 
//Screenshot on failure 
//jenkins integration 
public class AssertionhomepageURl4 extends base{
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{

		driver=initializDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void homepageabc() throws IOException
	{
		
		LandingPage obj=new LandingPage(driver);
		//Compare the text from the browser with actual text - its any mismatch then it get error
		Assert.assertEquals(obj.tital().getText(), "FEATURED OURSES");
		//obj.tital().getText(); - this is a actual result so mentioned in actual
		
	}
	
	@AfterTest 
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
