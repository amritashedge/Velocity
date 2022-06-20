package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ForgotUserIdPassword;
import Utility.Parameterization;

public class ForgotUserIdTest 
{
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver=Browser.openBrowser();
	}
	
	@Test
	public void rememberUserId() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		ForgotUserIdPassword forgot=new ForgotUserIdPassword(driver);
		forgot.clickOnForgot();
		forgot.selectRememberUserId();
		String userId=Parameterization.getData(3, 1);		
		String pan=Parameterization.getData(4, 1);
		String email=Parameterization.getData(5, 1);
		forgot.enterUserId(userId);
		forgot.enterPAN(pan);
		forgot.selectEmail(email);
		forgot.clickOnReset();
		
	}
	
	@Test
	public void forgotUserId() throws EncryptedDocumentException, IOException
	{
		ForgotUserIdPassword forgot=new ForgotUserIdPassword(driver);
		forgot.clickOnForgot();
		String pan=Parameterization.getData(4, 1);
		String mobile=Parameterization.getData(6, 1);
		//String email=Parameterization.getData(5, 1);

		forgot.selectforgotUserId(pan);
		forgot.selectSMS(mobile);
		//forgot.selectEmail(email);
		forgot.clickOnReset();
		
	}
	
	@Test
	public void backToLogin() throws InterruptedException
	{
		ForgotUserIdPassword forgot=new ForgotUserIdPassword(driver);
		forgot.clickOnForgot();
		Thread.sleep(2000);
		forgot.clickOnBackToLogin();
		
	}

}
