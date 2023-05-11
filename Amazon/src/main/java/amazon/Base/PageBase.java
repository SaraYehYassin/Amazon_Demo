package amazon.Base;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver drvier;
	protected JavascriptExecutor jse ; 
	public static Select select ; 
	public Actions action ; 
	public static WebDriverWait wait;
	public Alert alert;
	
	
	public PageBase(WebDriver driver) 
	{
        this.drvier = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public static void selectByVisibleText (WebDriver driver, By  dropList, String Option) 
	{
		WebElement element = driver.findElement(dropList);
		select = new Select(element); 
		select.selectByVisibleText(Option);
		
	
		
		
	}
	
	  public static boolean elementIsDisplayed (WebDriver driver, By assertElement) {
			
		WebElement element = driver.findElement(assertElement);
		if (element.isDisplayed()) {
			return true;
			
			}
		return false;
		}
	  
	  public static boolean elementIsSelected (WebDriver driver, By assertElement) {
			
			WebElement element = driver.findElement(assertElement);
			if (element.isSelected()) {
				return true;
				
				}
			return false;
			}
		  
	  
	
	public static void selectByIndex (WebDriver driver, By dropList, Integer index) 
	{
		WebElement element = driver.findElement(dropList);
		select = new Select(element); 
		select.selectByIndex(index);
		
		
	}
	
	public static void setTextElementText (WebDriver driver, By textElement , String value ) 
	{
		WebElement element = driver.findElement(textElement); 
	
		
		element.sendKeys(value);
		
		
	}
	
	public static void clickButton(WebDriver driver, By button) 
	{		
	WebElement element = driver.findElement(button);
	element.click();	
	
		
	}
	
	public static void clickButtonWebElement(WebDriver driver, WebElement button) 
	{		
	
	button.click();	
	
		
	}
	
	
	
	public void HoverOverElement(WebDriver driver, By element_locator) {
		
		WebElement element = driver.findElement(element_locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
			
		
	}

	
	
	public static void refreshPage(WebDriver driver) 
	{		
        
		driver.navigate().refresh();
	
		
	}
	
	public static void getBack(WebDriver driver) 
	{		
        
		driver.navigate().back();
	
		
	}
	
	//Wait until clickable of 
			public static  void waitUntilClickableOf (WebDriver driver, By item)
			
			{
				wait= new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(item));
			}
			
			//Wait until visbility of 
			public static  void waitUntilvisibilityOf (WebDriver driver, By item)
			
			{
				wait= new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(item));
			}
			
			//Wait until presence of 
			public static  void waitUntilPresenceOf (WebDriver driver, By item)
			
			{
				wait= new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(item));
			}
	
	public static void scrollToElementByJavaScript(WebDriver driver, By element) 
	{	
	
		WebElement webElement = driver.findElement(element);
		JavascriptExecutor jse= (JavascriptExecutor) driver; 
		jse.executeScript("arguments[0].scrollIntoView();", webElement);
	
		
	}
	
	public static WebElement convertFromByToWebElement(WebDriver driver, By element) 
	{	
	
		WebElement webElement = driver.findElement(element);
		return webElement;	
	
		
	}
	
	public static void clickByJavaScript (WebDriver driver, By element) 
	{	
	
		JavascriptExecutor jse= (JavascriptExecutor) driver; 
		jse.executeScript("arguments[0].click();", convertFromByToWebElement(driver, element) );	
	
		
	}
	
	
	
	

}
