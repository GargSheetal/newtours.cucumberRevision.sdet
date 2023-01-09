package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
public WebDriver ldriver;
	
	public RegisterPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By linkRegister = By.linkText("REGISTER");
	By txtFirstName = By.name("firstName");
	By txtLastName = By.name("lastName");
	By phnNum = By.name("phone");
	By txtEmail = By.name("userName");
	By txtAddress = By.name("address1");
	By txtCity = By.name("city");
	By txtState = By.name("state");
	By txtPostalCode = By.name("postalCode");
	By drpdownCountry = By.name("country");
	By txtUserName = By.name("email");
	By txtPassword = By.name("password");
	By txtConfirmPass = By.name("confirmPassword");
	By btnSubmit = By.xpath("//input[@name='submit' and @type='submit']");
	By RegConfirmationText = By.xpath("//font[contains(text(),'Thank you for registering.')]");
	
	
	public void clickRegister()
	{
		ldriver.findElement(linkRegister).click();
	}
	
	public void setFirstName(String firstName)
	{
		ldriver.findElement(txtFirstName).sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		ldriver.findElement(txtLastName).sendKeys(lastName);
	}
	
	public void setPhnNum(String phonenum)
	{
		ldriver.findElement(phnNum).sendKeys(phonenum);
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setAddress(String add)
	{
		ldriver.findElement(txtAddress).sendKeys(add);
	}
	
	public void setCity(String city)
	{
		ldriver.findElement(txtCity).sendKeys(city);
	}
	
	public void setState(String state)
	{
		ldriver.findElement(txtState).sendKeys(state);
	}
	
	public void setPostCode(String postcode)
	{
		ldriver.findElement(txtPostalCode).sendKeys(postcode);
	}
	
	public void setCountry(String CountryName)
	{
		WebElement drpCountry = ldriver.findElement(drpdownCountry);
		Select dropdownCountry = new Select(drpCountry);
		dropdownCountry.selectByVisibleText(CountryName);	
	}
	
	public void setUserName(String username)
	{
		ldriver.findElement(txtUserName).sendKeys(username);
	}
	
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setConfirmPass(String confirmPwd)
	{
		ldriver.findElement(txtConfirmPass).sendKeys(confirmPwd);
	}
	
	public void clickSubmit()
	{
		ldriver.findElement(btnSubmit).submit();
		
	}
	
	public String verifyRegConfirmationMsg()
	{
		String actRegText = ldriver.findElement(RegConfirmationText).getText();
		return actRegText;
	}
	

}
