package Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.SignupPagePOM;
import Utility.Parameterization;

public class SignupTest 
{
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser()
	{
		
		driver=Browser.openBrowser();
	}
	
	@Test
	public void signup() throws EncryptedDocumentException, IOException
	{
		
		SignupPagePOM obj=new SignupPagePOM(driver);
		obj.clickOnSignup();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i=s1.iterator();
		String adress=i.next();
		System.out.println(adress);
		String adress2=i.next();
		System.out.println(adress2);
		driver.switchTo().window(adress2);		
		String mobile=Parameterization.getData(6, 1);
		System.out.println(mobile);
		obj.enterMobileNumber(mobile);
		obj.clickOnContinue();
		
	}

}
