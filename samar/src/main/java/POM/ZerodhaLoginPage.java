package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage 
{
	@FindBy (xpath="//input[@id='userid']") private WebElement userId;
	@FindBy (xpath="//input[@id='password']") private WebElement pass;
	@FindBy (xpath="//button[@type='submit']") private WebElement login;
	@FindBy (xpath="//a[text()='Forgot user ID or password?']") private WebElement forgotId;
	@FindBy (xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signup;
	
	public ZerodhaLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String email)
	{
		userId.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		pass.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnForgotUserIdPassword()
	{
		forgotId.click();
	}
	
	public void clickOnSignup()
	{
		signup.click();
	}
	
	

}
