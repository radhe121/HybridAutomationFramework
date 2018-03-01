package hybrid;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility {
	
	public static void takescreenShot(WebDriver driver,String StrPassFail,ExtentTest logger ,String Description) throws IOException {
		
		if(StrPassFail=="pass") {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String time = Utility.getCurTime("H-mm-ss a");
			
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") +"\\ScreenShots\\img_"+ time +".jpg"));
					
			String image = logger.addScreenCapture(System.getProperty("user.dir") +"\\ScreenShots\\img_"+ time +".jpg");
			
			logger.log(LogStatus.PASS,Description,image );				
			
		}
		
		else {
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") +"\\ScreenShots\\img.jpg"));

			String image = logger.addScreenCapture(System.getProperty("user.dir") +"\\ScreenShots\\img.jpg");

			logger.log(LogStatus.FAIL,Description,image );							
			
		}
		
		
		
		
	}
	
	public static String getCurTime(String format) {
		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}
		
		
		
		

	
	
	
	

}
