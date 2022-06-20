package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellSharePOM 
{
	@FindBy (xpath="//input[@type='text']") private WebElement searchTab;
	@FindBy (xpath="//span[@class='nice-name']") private List<WebElement> shareName;
	@FindBy (xpath="//button[text()='S ']") private WebElement sellButton;
	@FindBy (xpath="//label[text()='BSE: ']") private WebElement bse;
	@FindBy (xpath="//label[text()='NSE: ']") private WebElement nse;
	@FindBy (xpath="//span[@class='icon icon-trending-up']") private WebElement chart;
	@FindBy (xpath="//span[@class='icon icon-align-center']") private WebElement marketDepth;
	@FindBy (xpath="//span[@class='icon icon-trash']") private WebElement delete;
	@FindBy (xpath="//label[text()='Intraday ']") private WebElement intraday;
    @FindBy (xpath="//label[text()='Longterm ']") private WebElement longterm;
    @FindBy (xpath="//input[@label='Qty.']") private WebElement qty;
    @FindBy (xpath="//input[@label='Price']") private WebElement limitPrice;
    @FindBy (xpath="//input[@label='Trigger price']") private WebElement triggerPrice;
    @FindBy (xpath="//label[text()='Market']") private WebElement marketOrder;
    @FindBy (xpath="//label[text()='Limit']") private WebElement limit;
    @FindBy (xpath="//label[text()='SL']") private WebElement stopLoss;
    @FindBy (xpath="//label[text()='SL-M']") private WebElement stopLossMarket;
    @FindBy (xpath="//button[@type='submit']") private WebElement sellShareButton;
    @FindBy (xpath="//button[text()='Cancel ']") private WebElement cancelButton;
    
    
    WebDriver driver;
    public SellSharePOM(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void searchShare(String name)
    {
    	searchTab.sendKeys(name);
    }
    
    public void clickOnChart(String perticularShareName,WebDriver driver)
    {
    	Actions action=new Actions(driver);
    	for(WebElement share:shareName)
    	{
    		if(share.getText().equalsIgnoreCase(perticularShareName))
    		{
    			action.moveToElement(share).perform();
    			chart.click();
    		}
    	}
    	
    }
    public void clickOnMarketDepth(String perticularShareName,WebDriver driver)
    {
    	Actions action=new Actions(driver);
    	for(WebElement share:shareName)
    	{
    		if(share.getText().equalsIgnoreCase(perticularShareName))
    		{
    			action.moveToElement(share).perform();
    			marketDepth.click();
    		}
    	}
    	
    }
    
    public void clickOnSell(String perticulerShareName,WebDriver driver)
    {
    	Actions action=new Actions(driver);
    	for(WebElement share:shareName)
    	{
    		if(share.getText().equalsIgnoreCase(perticulerShareName))
    		{
    			action.moveToElement(share).perform();
    			sellButton.click();
    		}
    	}
    }
    
    public void clickOnMarketOrder(String quantity)
    {
    	bse.click();
    	intraday.click();
    	//qty.clear();
    	qty.sendKeys(quantity);
    	marketOrder.click();
    	sellShareButton.click();
    }
    
    public void clickOnLimit(String quantity,String price )
    {
    	//nse.click();
    	bse.click();
    	longterm.click();
    	limit.click();
    	qty.clear();
    	qty.sendKeys(quantity);
    	limitPrice.clear();
    	limitPrice.sendKeys(price);
    	sellShareButton.click();
    }
    
    public void clickOnSL(String quantity,String price,String trgrPrice)
    {
    	nse.click();
    	intraday.click();
    	stopLoss.click();
    	qty.clear();
    	qty.sendKeys(quantity);
    	limitPrice.clear();
    	limitPrice.sendKeys(price);
    	triggerPrice.clear();
    	triggerPrice.clear();
    	triggerPrice.sendKeys(trgrPrice);
    	sellShareButton.click();
    }
}

