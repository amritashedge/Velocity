package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import POJO.Browser;

public class Screenshot extends Browser
{
	public static void takeFailedTestScreenshot(WebDriver driver,String name) throws IOException
	{
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yy hh-mm-ss-aa");
		Date date=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		String scrTime=(dateFormat.format(c.getTime()));
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("E:\\ScreenshotSelenium\\FailedTestScreenshot\\"+ scrTime + name +".jpg");
		FileHandler.copy(source, destination);
		
	}
	
	public static void takePassedTestScreenshot(WebDriver driver,String name) throws IOException
	{
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yy hh-mm-ss-aa");
		Date date=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		String scrTime=(dateFormat.format(c.getTime()));
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("E:\\ScreenshotSelenium\\PassedTestScreenshot\\"+ scrTime + name +".jpg");
		FileHandler.copy(source, destination);
	}
}
