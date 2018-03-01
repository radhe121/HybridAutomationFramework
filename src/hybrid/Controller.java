package hybrid;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import lib.Global;

public class Controller {
	
	static ExtentReports report;
	static ExtentTest logger;
	
	
 @Test
	public void driver() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	//public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		String path = System.getProperty("user.dir") + "\\Reports\\";
		String path1 = path + "AutomationTReport.html";
		
		
		File file = new File(path1);
		
		if(!file.exists()) {
			file.createNewFile();		
		}
		
	 Global.report = new ExtentReports(path1, true);	
		
		
		int NoOfSheets = ExcelCommunication.getSheetCountExcel();
		for( int k =0 ;k<NoOfSheets;k++) {
			
			String SheetName = ExcelCommunication.getSheetName(k);
			HashMap<Integer,ArrayList <String>> testcase = ExcelCommunication.readExcel(SheetName);
			
			for(int i=1 ; i<testcase.size()+1 ;i++) {
				
			 ArrayList<String>	templist = testcase.get(i);
					 
			 KeywordLibaries.callKeyword( templist.get(0), templist.get(1));
			 
				
				
			}
			
			
			
			
		}
		
		
		Global.report.endTest(Global.logger);
		Global.report.flush();
		
		
		
		

	}

}
