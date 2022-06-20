package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parameterization;


@Listeners(TestListeners.class)
public class ZerodhaLoginTest extends baseTest
{
	
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		
		driver=Browser.openBrowser();
	}
	
	@Test
	public void loginWithValidCredientialsTest() throws EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaloginpage=new ZerodhaLoginPage(driver);
		String userName=Parameterization.getData(0, 1);
		String password=Parameterization.getData( 1, 1);
		zerodhaloginpage.enterUserId(userName);
		zerodhaloginpage.enterPassword(password);
		zerodhaloginpage.clickOnLogin();
				
	}
	
	@Test
	public void forgotPasswordLinkTest()
	{
		ZerodhaLoginPage zerodhaloginpage=new ZerodhaLoginPage(driver);
		zerodhaloginpage.clickOnForgotUserIdPassword();
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void signupLinkTest()
	{
		ZerodhaLoginPage zerodhaloginpage=new ZerodhaLoginPage(driver);
		zerodhaloginpage.clickOnSignup();
	}
	
//	@AfterMethod
//	public void screenshot() throws IOException
//	{
//		Screenshot.takeScreenshot(driver);
//	}

}

