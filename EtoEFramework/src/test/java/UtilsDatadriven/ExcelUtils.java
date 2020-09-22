package UtilsDatadriven;

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

	public static int getRowCount() throws IOException{
		int rowCount=0;
		try{
			rowCount=Sheet.getPhysicalNumberOfRows(); //it will provide total number of rows
			System.out.println("Number of rows :" + rowCount);

		}
		catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		return rowCount;
	}

	public static int getcolunCount() throws IOException{
		int colmCount=0;
		try{
			colmCount=Sheet.getRow(0).getPhysicalNumberOfCells(); //it will provide total number of rows
			System.out.println("Number of cloumn :" + colmCount);

		}
		catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		return colmCount;
	}

	public static String getcellcountdata(int rowNum, int columnNum) throws IOException{
		String Celldata = null;
		try{
			Celldata=Sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
			System.out.println(Celldata);
		}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		return Celldata;
	}

	public static double getcellcountNumber(int rowNum, int columnNum) throws IOException{
		double Celldata = 0;
		try{
			Celldata=Sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
			System.out.println(Celldata);
		}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		return Celldata;
	}
	public static void main(String[] args) throws IOException{
		getRowCount();
		getcellcountdata(0,0);
		getcellcountNumber(1,1);

	}
}
