package UtilsDatadriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver = null;
	@BeforeTest
	public void setUptext(){
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\abc\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	@Test(dataProvider="test1data")
	public void test1(String Username,String Password) throws InterruptedException{
		System.out.println(Username+" | "+Password);
		driver.get("https://www.rediff.com/");
		driver.findElement(By.cssSelector("a[title*='Already']")).click();    //tagname[attribute*='value'] - css we have taken "Already" word in sentence "Already we have"
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys(Username); 
		driver.findElement(By.cssSelector("input#password")).sendKeys(Password);
		Thread.sleep(3000);
		}
public static Object[][] testdata(String excelpath,String SheetName) throws IOException{
	// TODO Auto-generated method stub
ExcelUtils Excel=new ExcelUtils(excelpath,SheetName);
int rowCount = Excel.getRowCount(); // number of row count stored in the rowcount
int Colmcount = Excel.getcolunCount(); // number of row column stored in the colmcount
Object data[][] =new Object[rowCount-1][Colmcount]; //[rowCount-1] - due to first line for template and we well not fetch
for (int i=1; i<rowCount; i++){
for (int j=0;j<Colmcount;j++){
	String celldata=Excel.getcellcountdata(i, j);
	System.out.println(celldata+" | ");
	data[i-1][j] = celldata;
}
System.out.println();	
}
return data;
}
@DataProvider(name = "test1data")//you can give any name
public static Object[][] getdata() throws IOException{
String excelpath = "E:\\BCSE4A\\EtoEFramework\\Excel\\TestData.xlsx";
Object data[][]=testdata(excelpath, "Sheet1"); //providing the sheet name and excel path
return data;
}
}

	
	