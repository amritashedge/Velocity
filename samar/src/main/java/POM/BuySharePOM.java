package POM;

//import java.time.Duration;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuySharePOM 
{
	
    @FindBy (xpath="//input[@type='text']") private WebElement searchTab;
    @FindBy (xpath="//span[@class='nice-name']") private List<WebElement> shareName;
    @FindBy (xpath="//button[text()='B ']") private WebElement buyButton;
    @FindBy (xpath="//label[text()='Intraday ']") private WebElement intraday;
    @FindBy (xpath="//label[text()='Longterm ']") private WebElement longterm;
    @FindBy (xpath="//input[@label='Qty.']") private WebElement qty;
    @FindBy (xpath="//input[@label='Price']") private WebElement limitPrice;
    @FindBy (xpath="//input[@label='Trigger price']") private WebElement triggerPrice;
    @FindBy (xpath="//label[text()='Market']") private WebElement marketOrder;
    @FindBy (xpath="//label[text()='Limit']") private WebElement limit;
    @FindBy (xpath="//label[text()='SL']") private WebElement stopLoss;
    @FindBy (xpath="//label[text()='SL-M']") private WebElement stopLossMarket;
    @FindBy (xpath="//button[@type='submit']") private WebElement buyShareButton;
    @FindBy (xpath="//button[text()='Cancel ']") private WebElement cancelButton;
    @FindBy (xpath="//label[text()='BSE: ']") private WebElement bse;
	@FindBy (xpath="//label[text()='NSE: ']") private WebElement nse;
	
    public BuySharePOM(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void enterShareName(String name)
	{
		searchTab.sendKeys(name);
		searchTab.sendKeys(Keys.ENTER);
	//	searchTab.click();
	}
	public void clickOnBuyShare1(String perticulerShare,WebDriver driver)
	{
		Actions action=new Actions(driver);
		for(WebElement stock:shareName)
		{
			if(stock.getText().equals(perticulerShare))
			{
				action.moveToElement(stock).perform();
				buyButton.click();
			}
		}
			
	}
	
	public void clickOnMarket(String quantity) throws InterruptedException
	{
//		intraday.click();
//		qty.sendKeys(quantity);
//		marketOrder.click();
//		buyShareButton.click();
		
		bse.click();
		longterm.click();
		qty.sendKeys(quantity);
		marketOrder.click();
		Thread.sleep(2000);
		buyShareButton.click();
				
	}
	public void ClickOnLimit(String quantity,String price) throws InterruptedException
	{
		intraday.click();
	
		qty.clear();
		qty.sendKeys(quantity);
		limitPrice.clear();
		limitPrice.sendKeys(price);
		//buyShareButton.click();
		limit.click();
		Thread.sleep(2000);
		cancelButton.click();
	}
	
	public void clickOnSL(String quantity,String price,String trgrPrice)
	{
		intraday.click();
		stopLoss.click();
		qty.clear();
		qty.sendKeys(quantity);
		limitPrice.clear();
		triggerPrice.clear();
		triggerPrice.clear();
		limitPrice.sendKeys(price);
		
		triggerPrice.sendKeys(trgrPrice);
		
		buyShareButton.click();
	}
	
	public void clickOnSLM(String quantity,String trgrPrice)
	{
		longterm.click();
		stopLossMarket.click();
		qty.clear();
		triggerPrice.clear();
		qty.sendKeys(quantity);
		
		triggerPrice.sendKeys(trgrPrice);
		buyShareButton.click();
	}
	
//	public void clickOnBuyShare(String name,WebDriver driver) throws InterruptedException
//	{
//		  int size=driver.findElements(By.xpath("((//div[@class='vddl-list list-flat'])//div)//div//div")).size();
//          for (int i = 1; i <=size ; i++) 
//          {
//             String nameOfShare= driver.findElement(By.xpath
//            ("((((//div[@class='vddl-list list-flat'])//div)//div//div)["+i+"]//span//span//span)[1]")).getText();
//             if (nameOfShare.equalsIgnoreCase(name))
//               {
//            	 
//                 Actions actions=new Actions(driver);
//                 actions.moveToElement(driver.findElement(By.xpath
//                ("((((//div[@class='vddl-list list-flat'])//div)//div//div)[2]//span//span)[1]")))
//                 .pause(Duration.ofSeconds(3)).build().perform();
//                (driver.findElement(By.xpath("//button[@class='button-blue buy']"))).click();
//		
//	           }
//
//           }
//	}

	

}
