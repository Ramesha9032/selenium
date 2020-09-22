package SeleniumProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.loginPage;
import resource.Baseclass;

public class Homepage extends Baseclass{
	public WebDriver driver; //creating the local driver (copy of the driver)
	public static Logger log=LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void beforetest() throws IOException{

		driver=initializeDriver(); // "initializeDriver()method return the driver and put in driver object
		
	}
 
	@Test (dataProvider="getdata") //we are saying that go and find data provider called getdata
	
	public void basepagenavigation(String email,String passwod,String text) throws IOException, InterruptedException {
		
		//driver.get("http://www.qaclickacademy.com/");
		driver.get(prop.getProperty("URL"));
		LandingPage obj = new LandingPage(driver);
		obj.getlogin().click();
		loginPage obj1= new loginPage(driver);
		obj1.emailadress().sendKeys(email);
		log.info("Successfully entered Username");
		Thread.sleep(5000);
		obj1.password().sendKeys(passwod);
		Thread.sleep(5000);
		//System.out.println(text)
		log.info(text);
		obj1.login().click();
}
	
@AfterTest
public void closeweb(){
	driver.close();
}

	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][3];
		//0th row - first 0th row will execute then proceed to 1st row 
		data[0][0]="ramesha@53.com";
		data[0][1]="325345";
		data[0][2]="username1";
		//1st row	
		data[1][0]="sdfsdcz@53.com";
		data[1][1]="325345sdcs";
		data[1][2]="username2";
		return data;
			}
		
	
	}
	

