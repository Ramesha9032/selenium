package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	
	By Email=By.id("user_email");
	By PassWord=By.id("user_password");
	By Login=By.xpath("//input[@value='Log In'] ");
	
	public loginPage(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement emailadress(){
		
		return driver.findElement(Email);
	}
	
	public WebElement password(){
		return driver.findElement(PassWord);
	}
		
	public WebElement login(){
		return driver.findElement(Login);
	}
	}


	
	