package flightpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import hybrid.Utility;
import lib.Global;



//page factory have intitElements method
//it have Cache feature

public class FlightLoginpagesNew {
	
	WebDriver driver;
	public FlightLoginpagesNew (WebDriver driver){
		
		this.driver = driver;
		
	}
	
	@FindBy (name= "userName")
	public WebElement edtLUserName;
	
	@FindBy (name= "password")
	public WebElement edtLpasswd;
	
	@CacheLookup
	@FindBy (name= "login")
	public WebElement btnLlogin;
	
	@FindBy(how=How.NAME,using = "userName")
	public WebElement edtUser;
	
	
	public void login(String userName ,String password) throws IOException {

		try {
			
		
	    edtLUserName.sendKeys(userName);
	    edtLpasswd.sendKeys(password);
	    btnLlogin.click();		
		
		Global.logger.log(LogStatus.PASS, "Sucessfully login into flight application");
		Utility.takescreenShot(driver, "pass", Global.logger, "login into flight application");
		}
		catch(Exception e) {
		Global.logger.log(LogStatus.FAIL, "unable to login into flight application");
		Utility.takescreenShot(driver, "fail", Global.logger, "login failed");
		}
		

}
	
	
	
	

}
