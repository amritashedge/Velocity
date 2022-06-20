package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parameterization;

public class ZerodhaPinTest
{
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver=Browser.openBrowser();
	}
	
	@Test
	public void continueWithValidPin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ZerodhaLoginPage zerodhaloginpage=new ZerodhaLoginPage(driver);
		String userName=Parameterization.getData( 0, 1);
		String password=Parameterization.getData( 1, 1);
		zerodhaloginpage.enterUserId(userName);
		zerodhaloginpage.enterPassword(password);
		zerodhaloginpage.clickOnLogin();
		
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhapinpage=new ZerodhaPinPage(driver);
		String pin=Parameterization.getData( 2, 1);
		System.out.println(pin);
		zerodhapinpage.enterPin(pin);
		zerodhapinpage.clickOnContinue();
		Thread.sleep(2000);
		
		
	}
	
	
	
	
	

}
