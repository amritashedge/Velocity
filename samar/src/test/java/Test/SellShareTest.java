package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.SellSharePOM;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parameterization;

public class SellShareTest 
{
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver=Browser.openBrowser();
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
	
	@Test
	public void clickChart() throws EncryptedDocumentException, IOException, InterruptedException
	{
		SellSharePOM sellShare=new SellSharePOM(driver);
		//sellShare.searchShare("TATAMOTORS");
		sellShare.clickOnChart("TATAMOTORS",driver);
	}
	
	@Test
	public void marketDepth() throws EncryptedDocumentException, IOException, InterruptedException
	{
		SellSharePOM sellShare=new SellSharePOM(driver);
		sellShare.clickOnMarketDepth("tatamotors",driver);
	}
	
	@Test
	public void sellShareWithMarketOrder()
	{
		SellSharePOM sellShare=new SellSharePOM(driver);
		sellShare.clickOnSell("tatamotors", driver);
		sellShare.clickOnMarketOrder("3");
		
	}
	
	@Test
	public void sellShareWithLimitOrder()
	{
		SellSharePOM sellShare=new SellSharePOM(driver);
		sellShare.clickOnSell("tatasteel", driver);
		sellShare.clickOnLimit("2","300");
	}
	
	@Test
	public void sellShareWithStopLoss()
	{
		SellSharePOM sellShare=new SellSharePOM(driver);
		sellShare.clickOnSell("tatamotors", driver);
		sellShare.clickOnSL("3", "300", "350");
		
	}
	
	
}
