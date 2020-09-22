package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

public WebDriver driver;
	//click on login button
By signin=By.cssSelector("a[href*='sign_in']"); 
		//created css selector(login) and stored it in "signin"
By tital= By.xpath("//*[@id='content']/div/div/h2");
By Isdisplayed= By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[8]/a");
		
public LandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver; 
		}

public WebElement getlogin()
		{
return driver.findElement(signin); //here returning the 'signin' method
		}
		
public WebElement titlegettext(){
	return driver.findElement(tital);
}

public WebElement isdisplayedlandingpage()
{
	return driver.findElement(Isdisplayed);
}

	}

	
	