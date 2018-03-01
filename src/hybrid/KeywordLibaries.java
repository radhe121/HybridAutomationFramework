package hybrid;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import flightpages.FlightLoginPages;
import flightpages.FlightLoginpagesNew;
import lib.Global;

public class KeywordLibaries {
	
	static String [] data;
	static HashMap<String,String> objHM = new HashMap<String,String>();
	
	public static void callKeyword(String Action , String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method methods = KeywordLibaries.class.getMethod(Action, String.class);
		methods.invoke(Action, param);
		
		
		
	}
	
	
	

	
	public static void VerifyLogin(String param) throws IOException {
		
		data = param.split(";");
		for(int i=0;i<data.length;i++) {
		String [] test =	data[i].split("=");
		objHM.put(test[0], test[1]);
			
		}
		
		Global.logger = Global.report.startTest("VerifyLogin", "Login ito Flight");
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\selenium-java-3.4.0\\chromedriver.exe");
		ChromeDriver  driver = new ChromeDriver();
		
		driver.get(Global.URL);
		
		//FlightLoginPages login = new FlightLoginPages(driver);
	
		
		String username = objHM.get("UserName");
		String password = objHM.get("password");
		
		
		FlightLoginpagesNew objlogin = PageFactory.initElements(driver, FlightLoginpagesNew.class);
		objlogin.login(username, password);
	
	
		//login.loginToFlightApp(username,password);
		
		
	
			
		System.out.println("VerifyLogin method calling");
		
		driver.quit();
		
		
	
		
		
	}
	
	
	

}
