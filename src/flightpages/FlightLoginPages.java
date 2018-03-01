package flightpages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import hybrid.Utility;
import lib.Global;

public class FlightLoginPages {

	WebDriver driver;

	public FlightLoginPages(WebDriver driver) {
		this.driver = driver;

	}

	By edtLUserName = By.name("userName");
	By edtLPassword = By.name("password");
	By btnLSignIn = By.name("login");
	
	

	public void loginToFlightApp(String userName ,String password) throws IOException {

		try {
		driver.findElement(edtLUserName).sendKeys(userName);
		driver.findElement(edtLPassword).sendKeys(password);
		driver.findElement(btnLSignIn).click();		
		
		Global.logger.log(LogStatus.PASS, "Sucessfully login into flight application");
		Utility.takescreenShot(driver, "pass", Global.logger, "login into flight application");
		}
		catch(Exception e) {
		Global.logger.log(LogStatus.FAIL, "unable to login into flight application");
		Utility.takescreenShot(driver, "fail", Global.logger, "login failed");
		}
		

}

}
