package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.BuySharePOM;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parameterization;

public class BuyShareTest
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
	public void buyShareWithMarketOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		BuySharePOM buyShare=new BuySharePOM(driver);
		//zerodhapinpage.enterShareName("WIPRO");
		buyShare.clickOnBuyShare1("TATAMOTORS", driver);
		buyShare.clickOnMarket("1");
	}
	@Test
	public void buyShareWithLimitOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
				
		BuySharePOM buyShare=new BuySharePOM(driver);
		buyShare.enterShareName("WIPRO");
		buyShare.clickOnBuyShare1("TATAMOTORS", driver);
		
		buyShare.ClickOnLimit("3", "350");
	}
	
	@Test
	public void buyShareWithSL() throws EncryptedDocumentException, IOException, InterruptedException
	{
		BuySharePOM buyShare=new BuySharePOM(driver);
		buyShare.enterShareName("WIPRO");
		buyShare.clickOnBuyShare1("TATAMOTORS", driver);
		buyShare.clickOnSL("4", "200", "600");
	}
	
	@Test
	public void buyShareWithSLM() throws InterruptedException, EncryptedDocumentException, IOException
	{
		BuySharePOM buyShare=new BuySharePOM(driver);
		buyShare.enterShareName("WIPRO");
		buyShare.clickOnBuyShare1("TATAMOTORS", driver);
		buyShare.clickOnSLM("4", "400");

	}

}
