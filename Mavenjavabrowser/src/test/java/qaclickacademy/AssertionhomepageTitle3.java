package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.loginpage;
import resources.base;

public class AssertionhomepageTitle3 extends base{
	LandingPage l;
	private static Logger log=LogManager.getLogger(base.class.getName());
	@Test
	public void homepageabc() throws IOException
	{
		driver=initializDriver();
		log.info("Driver is intialized");
		driver.get("http://www.qaclickacademy.com/");
		log.info("Driver is intialized");
	}
	@Test
	public void validateAppTitle() throws IOException
	{
 l=new LandingPage(driver);
		//Compare the text from the browser with actual text - its any mismatch then it get error
		Assert.assertEquals(l.tital().getText(), "FEATURED COURSES");
	
		//obj.tital().getText(); - this is a actual result so mentioned in actual
		l.isdisplayed().isDisplayed();
		Assert.assertTrue(l.isdisplayed().isDisplayed());
	///Assert.assertFalse(false); - it is for false statement 
	}
	
	public void validateHeader() throws IOException
	{
		
System.out.println("am i going inside it");
Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
		}
	
	@AfterTest 
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
