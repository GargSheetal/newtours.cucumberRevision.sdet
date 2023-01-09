package stepDefinitions;



import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import pageObjects.FlightReservationPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public RegisterPage rp;
	public FlightReservationPage frp;
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	public Properties configProp;

	// Creating random string for unique emailId
	public static String randomString()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(7);
		return generatedString1;
	}
	
	// Creating random string for unique password
	public static String randomAlphaNum()
	{
		String generatedString2 = RandomStringUtils.randomAlphanumeric(10);
		return generatedString2;
	}
	
	// Creating random string for unique phone number
	public static String randomNumbers()
	{
		String generatedString3 = RandomStringUtils.randomNumeric(10);
		return generatedString3;
	}

}
