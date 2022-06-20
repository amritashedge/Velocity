package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPagePOM 
{
	@FindBy (xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signup;
	@FindBy (xpath="//input[@id='user_mobile']") private WebElement mobileNumber;
	@FindBy (xpath="//button[@id='open_account_proceed_form']") private WebElement clkContinue;
	
	public SignupPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignup()
	{
		signup.click();
		
	}
	public void enterMobileNumber(String number)
	{
		
		mobileNumber.sendKeys(number);
	}
	
	public void clickOnContinue()
	{
		clkContinue.click();
	}
	
	

}

