package hybrid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCommunication {
	
	static String testCase = "D:\\Radhe\\HybridAutomationFramework\\HybridAutomationFramework\\testCase.xls";
	
	public static HashMap readExcel(String strSheetName) throws IOException {
			
		File file = new File(testCase);
		FileInputStream  stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		
		HSSFSheet sheet = workbook.getSheet(strSheetName);
		
		HashMap<Integer,ArrayList <String>> map = new HashMap<Integer,ArrayList <String>>();
		
		int TotalRows = sheet.getLastRowNum();
		
		for(int i=1 ; i<=TotalRows;i++) {
			
			ArrayList <String> List = new ArrayList <String> ();
			HSSFRow row = sheet.getRow(i);
			
			for( int j=0;j<row.getLastCellNum();j++) {
				HSSFCell cell = row.getCell(j);
				List.add(cell.getStringCellValue());
				
				
			}
	
			map.put(i, List);
			
		}		
				
	return map;
		
	}
	
	public static void writeExcel(int rowNumber ,String result) throws IOException {
		
		File file = new File(testCase);
		FileInputStream  stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		
		HSSFSheet sheet = workbook.getSheet("FlightApp");
		
		HSSFRow row = sheet.getRow(rowNumber);
		HSSFCell cell = row.createCell(2);
		cell.setCellValue(result);
		
		FileOutputStream outstr = new FileOutputStream(file);
		workbook.write(outstr);	
		
	}
	
	public static int getSheetCountExcel() throws IOException {
		
		File file = new File(testCase);
		FileInputStream  stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		
		int noOfSheets = workbook.getNumberOfSheets();
		return noOfSheets;
		
		
	}
	
public static String getSheetName( int sheetNumber) throws IOException {
		
		File file = new File(testCase);
		FileInputStream  stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		
		String SheetName = workbook.getSheetName(sheetNumber);
		return SheetName;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
