package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "userName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "submit")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(linkText = "SIGN-OFF")
	@CacheLookup
	WebElement linkSignOff;
	
	@FindBy(xpath = "//span[contains(text(),'Enter your userName and password correct')]")
	@CacheLookup
	WebElement errorText;
	
	public void setUserName(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickSignOff()
	{
		linkSignOff.click();
	}
	
	public String verifyErrorMsg()
	{
		String errText = errorText.getText();
		return errText;
	}
	
	
	

}
