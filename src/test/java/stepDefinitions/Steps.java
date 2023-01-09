package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.asynchttpclient.config.AsyncHttpClientConfigHelper.Config;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.FlightReservationPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class Steps extends BaseClass {
	
	@Before
	public void setup() throws IOException
	{
		// Reading config.properties file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		// Browser configuration
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		logger.info("Browser is launched");
	}
	
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage(driver);
	
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		
		logger.info("Baseurl is opened");
		driver.get(url);
	}

	@Then("User enters User Name as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String user, String password) {
		
		logger.info("Entered username and password");
		lp.setUserName(user);
		lp.setPassword(password);
	}

	@And("Clicks on submit button")
	public void clicks_on_submit_button() {
		
		logger.info("Clicked Submit");
		lp.clickSubmit();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expTitle) {
		
		if(driver.getPageSource().contains("Enter your userName and password correct"))
		{
			logger.info("Login failed with invalid credentials");
			driver.close();
			Assert.assertTrue("Login failed with invalid credentials", false);
		}
		else
		{
			logger.info("Login Passed with valid credentials");
			Assert.assertEquals(expTitle, driver.getTitle());
		}	
	}

	@When("User clicks on SIGN-OFF link")
	public void user_clicks_on_sign_off_link() {
		
		logger.info("Clicking SignOff");
		lp.clickSignOff();
	}

	@And("Close browser")
	public void close_browser() {
		
		logger.info("Browser Closed");
		driver.close();
	}
	
	

	// Steps for Register new user -----------------------------------------
	
	@When("Clicks on REGISTER link")
	public void clicks_on_register_link() {
	    
		rp = new RegisterPage(driver);
		rp.clickRegister();
		
	}

	@Then("Enters New User details")
	public void enters_new_user_details() {
		
		rp.setFirstName("Mohan");
		rp.setLastName("Mehra");
		
		String phnNum = randomNumbers();
		rp.setPhnNum(phnNum);
		
		String email = randomString() + "@gmail.com";
		rp.setEmail(email);
		
		rp.setAddress("41 Shambor lane");
		rp.setCity("Willowland");
		rp.setState("Delhi");
		rp.setCountry("INDIA");
		rp.setUserName("MohanMehra");
		rp.setPassword("MohanMehra");
		rp.setConfirmPass("MohanMehra");
		rp.clickSubmit();	
	
	}

	@Then("User can view configuration message {string}")
	public void user_can_view_configuration_message(String expRegText) {

		String actRegText = rp.verifyRegConfirmationMsg();
		if(actRegText.contains(expRegText))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue("New Customer Registration Failed", false);
		}
	}
	
	
	
	// Steps for Flight Reservation -----------------------------------------
	
	@When("User clicks on Flights link")
	public void user_clicks_on_flights_link() {
	    
		frp = new FlightReservationPage(driver);
		frp.clickFlights();
		
	}
	
	@And("Enters Flight details and Preferences")
	public void enters_flight_details_and_preferences() throws InterruptedException {
	    
		frp.setTypeOfTrip("One Way");
		Thread.sleep(3000);
		frp.setPassengers("2");
		frp.setDepartureCity("London");
		frp.setOnMonth("September");
		frp.setOnDay("19");
		frp.setArrivingCity("Paris");
		frp.setReturnMonth("October");
		frp.setReturnDay("8");
		frp.setServiceClass("First class");
		frp.setAirline("Unified Airlines");
		
	}
	
	@And("Clicks Continue button")
	public void clicks_continue_button() {
	    
		frp.clickContinue();	
	}
	
	@Then("User can view message {string}")
	public void user_can_view_message(String msg) {

		Assert.assertEquals(msg, frp.verifyFlightBookingMsg());
		
	}
	
	
	
	
}
