package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotUserIdPassword 
{
	@FindBy (xpath="//a[text()='Forgot user ID or password?']") private WebElement forgotLink;
	@FindBy (xpath="//input[@id='radio-30']") private WebElement rememberUserId;
	@FindBy (xpath="//label[@for='radio-31']") private WebElement forgotUserId;
	@FindBy (xpath="//input[@placeholder='User ID']") private WebElement userId;
	@FindBy (xpath="//input[@placeholder='PAN']") private WebElement pan;	
	@FindBy (xpath="//label[@for='radio-36']") private WebElement sms;
	@FindBy (xpath="//input[@placeholder='E-mail (as on account)']") private WebElement emailAdress;
	@FindBy (xpath="//input[@placeholder='Mobile number (as on account)']") private WebElement mobile;
	@FindBy (xpath="//button[@type='submit']") private WebElement reset;
	@FindBy (xpath="//a[@class='text-xsmall text-light reset-account-button']") 
	private WebElement backToLogin;
	@FindBy (xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signup;
	
	public ForgotUserIdPassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnForgot()
	{
		forgotLink.click();
	}
	
	public void selectRememberUserId()
	{
		
	}
	
	public void enterPAN(String panNumber)
	{
		pan.sendKeys(panNumber);
	}
	
	public void selectforgotUserId(String panNo)
	{
		forgotUserId.click();
		pan.sendKeys(panNo);
	}
	
	public void enterUserId(String userid)
	{
		userId.sendKeys(userid);
	}
	
	
	
	public void selectEmail(String emailAdress1)
	{
		emailAdress.sendKeys(emailAdress1);
	}
	
	public void selectSMS(String mobileNumber)
	{
		sms.click();
		mobile.sendKeys(mobileNumber);
		
	}
	
		
	public void clickOnReset()
	{
		reset.click();
	}
	
	public void clickOnBackToLogin()
	{
		backToLogin.click();
	}
	
	public void clickOnSignup()
	{
		signup.click();
	}

}
