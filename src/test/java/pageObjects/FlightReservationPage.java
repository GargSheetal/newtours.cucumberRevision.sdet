package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class FlightReservationPage {
	
	public WebDriver ldriver;
	WaitHelper waitHelper;

	
	public FlightReservationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waitHelper = new WaitHelper(ldriver);
	}
	
	
	@FindBy(linkText = "Flights")
	@CacheLookup
	WebElement linkFlights;
	
	@FindBy(xpath = "//input[@value='roundtrip']")
	@CacheLookup
	WebElement radioBtnRoundTrip;
	
	@FindBy(xpath = "//input[@value='oneway']")
	@CacheLookup
	WebElement radioBtnOneWay;
	
	@FindBy(name = "passCount")
	@CacheLookup
	WebElement drpdwnPassengers;
	
	@FindBy(name = "fromPort")
	@CacheLookup
	WebElement drpdwnDepartingFrom;
	
	@FindBy(name = "fromMonth")
	@CacheLookup
	WebElement drpdwnOnMonth;
	
	@FindBy(name = "fromDay")
	@CacheLookup
	WebElement drpdwnOnDay;
	
	@FindBy(name = "toPort")
	@CacheLookup
	WebElement drpdwnArrivingIn;
	
	@FindBy(name = "toMonth")
	@CacheLookup
	WebElement drpdwnReturningMonth;
	
	@FindBy(name = "toDay")
	@CacheLookup
	WebElement drpdwnReturningDay;
	
	@FindBy(xpath = "//input[@value='Coach']")
	@CacheLookup
	WebElement radioBtnServClass;
	
	@FindBy(xpath = "//input[@value='Business']")
	@CacheLookup
	WebElement radioBtnBusiClass;
	
	@FindBy(xpath = "//input[@value='First']")
	@CacheLookup
	WebElement radioBtnFirstClass;
	
	@FindBy(name = "airline")
	@CacheLookup
	WebElement drpdwnAirline;
	
	@FindBy(name = "findFlights")
	@CacheLookup
	WebElement imgContinue;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/p/font/b/font[1]")
	@CacheLookup
	WebElement verificationMsg;
			
			
	public void clickFlights()
	{
		waitHelper.waitForElement(linkFlights, 10);
		linkFlights.click();
	}
	
	public void setTypeOfTrip(String tripType)
	{
		if(tripType.equals("Round Trip"))
		{
			radioBtnRoundTrip.clear();
			radioBtnRoundTrip.click();
		}
		else if(tripType.equals("One Trip"))
		{
			radioBtnOneWay.click();
		}
	}
	
	public void setPassengers(String numOfPass)
	{
		Select passengers = new Select(drpdwnPassengers);
		passengers.selectByValue(numOfPass);	
		
	}
	
	public void setDepartureCity(String fromCity)
	{
		Select departCity = new Select(drpdwnDepartingFrom);
		departCity.selectByVisibleText(fromCity);
	}
	
	public void setOnMonth(String fromMonth)
	{
		Select depMonth = new Select(drpdwnOnMonth);
		depMonth.selectByVisibleText(fromMonth);
	}
	
	public void setOnDay(String fromDay)
	{
		Select onDay = new Select(drpdwnOnDay);
		onDay.selectByVisibleText(fromDay);
	}
	
	public void setArrivingCity(String toCity)
	{
		Select arrivalCity = new Select(drpdwnArrivingIn);
		arrivalCity.selectByVisibleText(toCity);
	}
	
	public void setReturnMonth(String toMonth)
	{
		Select arrivalMon = new Select(drpdwnReturningMonth);
		arrivalMon.selectByVisibleText(toMonth);
	}
	
	public void setReturnDay(String toDay)
	{
		Select arrivalDay = new Select(drpdwnReturningDay);
		arrivalDay.selectByVisibleText(toDay);
	}
	
	public void setServiceClass(String servClass)
	{
		if(servClass.equals("Economy class"))
		{
			radioBtnServClass.click();
		}
		else if(servClass.equals("Business class"))
		{
			radioBtnBusiClass.click();
		}
		else if(servClass.equals("First class"))
		{
			radioBtnFirstClass.click();
		}
	}
	
	public void setAirline(String airline)
	{
		Select airlineList = new Select(drpdwnAirline);
		airlineList.selectByVisibleText(airline);
	}
	
	public void clickContinue()
	{
		imgContinue.click();
	}
	
	public String verifyFlightBookingMsg()
	{
		waitHelper.waitForElement(verificationMsg, 10);
		String verificationText = verificationMsg.getText();
		return verificationText;
	}
	

}
