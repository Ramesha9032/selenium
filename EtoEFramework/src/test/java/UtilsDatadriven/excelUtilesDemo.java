package UtilsDatadriven;

import java.io.IOException;

public class excelUtilesDemo {
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Creating obj of ExcelUtilis class
String projectpath = System.getProperty("user.dir");
ExcelUtils obj = new ExcelUtils(projectpath+"\\Excel\\TestData.xlsx", "Sheet1");
obj.getRowCount();
obj.getcellcountdata(0,0);
obj.getcellcountNumber(1,1);	
obj.getcolunCount();
		
	}

}
