package Test;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utility.Screenshot;

public class TestListeners extends Screenshot implements ITestListener
{
	
	public void onTestStart(ITestResult result)
	{
		
		System.out.println(result.getName()+"Test has Started");
	}
	
	public void onTestFailure(ITestResult result)
	{
		try {
			Screenshot.takeFailedTestScreenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
			System.out.println(result.getName()+"Test has Failure");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		try {
			Screenshot.takePassedTestScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.getName()+"Test has Success");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getName()+"Test Skipped");
	}

}
