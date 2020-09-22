package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet Sheet;
	
	public ExcelUtils(String excelpath,String SheetName ){
		
		try{
		    
			 workbook = new XSSFWorkbook(excelpath); 
			Sheet = workbook.getSheet(SheetName);   //if use "/" then it will work in windows as well
			}
			catch(Exception e){
				
				e.printStackTrace();
			}
		}
		
	public static void getRowCount() throws IOException{
		try{
		int rowCount=Sheet.getPhysicalNumberOfRows(); //it will provide total number of rows
		System.out.println("Number of rows :" + rowCount);
		
		}
		catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
	}
	
	public static void getcellcountdata(int rowNum, int columnNum) throws IOException{
		try{
		String Celldata=Sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
		System.out.println(Celldata);
	}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
	}
	
	public static void getcellcountNumber(int rowNum, int columnNum) throws IOException{
		try{
		double Celldata=Sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
		System.out.println(Celldata);
	}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException{
		getRowCount();
		getcellcountdata(0,0);
		getcellcountNumber(1,1);
		
	}
}
