package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
   //By sign= By.xpath("//*[@class='pull-right']/ul/li[4]/a/span");
	private By sign= By.cssSelector("a[href*='sign_in']");
	private By tital= By.xpath("//*[@id='content']/div/div/h2");
	private By isdisplayes=By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[8]/a");
	private  By header=By.cssSelector("div[class*='video-banner'] h3");
   
   public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	   this.driver= driver;
}

public WebElement getLogin()
   {
	   return driver.findElement(sign);
   }
public WebElement tital()
{
	   return driver.findElement(tital);
}
public WebElement isdisplayed()
{
	   return driver.findElement(isdisplayes);
}
public WebElement getHeader()
{
	return driver.findElement(header);
}
}
