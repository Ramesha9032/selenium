package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.loginpage;
import resources.base;



public class homepage extends base{
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initializ() throws IOException
	{
		driver=initializDriver(); // we are not written steps for url bec its running two time
	}
	
	@Test(dataProvider="getData")
	public void homepageabc(String username,String password,String text) throws IOException
	{
		
		driver.get("http://www.qaclickacademy.com/");
		//one is inheritance 
		//create object to that class and inhocke method of it
		LandingPage obj=new LandingPage(driver);
		obj.getLogin().click(); //getLogin simpler to driver.findelemrnt(by.ccsselectot
		loginpage obj1=new loginpage(driver);
		/* for single data sending
		  obj1.emailadress1().sendKeys("ramesha");
		obj1.password1().sendKeys("213424");
		obj1.loginpage1().click();
		}*/
		
		obj1.emailadress1().sendKeys(username);
		obj1.password1().sendKeys(password);
		//System.out.println(text);
		log.info(text);// if you use log4j then no need to use "System.out.println(text);"
		
		obj1.loginpage1().click();
	}
	


	@AfterTest 
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider 
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//Column stands for how many values per each test
		//Object[row][column]
		//Object[1][2] index is not a[1][2] bec if the index value is 1 then it will take only 0th row not move to 1st row
		// so we have to given as Object[2][3]
		
		Object[][] data=new Object[2][3];
		//0th row - first 0th row will execute then proceed to 1st row 
		data[0][0]="ramesha";
		data[0][1]="12345";
		data[0][2]="Restrcted User";
		//1st row
		data[1][0]="ahsh@jhj";
		data[1][1]="234253";
		data[1][2]="sdbhbUser";
		
		return data;
	}
	
	
}
