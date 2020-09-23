package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {
	
	public WebDriver driver;
   By emailadress=By.id("user_email");
   By password=By.id("user_password");
   By login=By.cssSelector("input[class*='login-button']");
   
   public loginpage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	   this.driver= driver;
}


public WebElement emailadress1() {
	// TODO Auto-generated method stub
	return driver.findElement(emailadress);
}


public WebElement password1() {
	// TODO Auto-generated method stub
	return driver.findElement(password);
}

public WebElement loginpage1() {
	// TODO Auto-generated method stub
	return driver.findElement(login);
}


}
