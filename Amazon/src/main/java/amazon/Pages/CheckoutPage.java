package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.Base.PageBase;

public class CheckoutPage extends PageBase {

	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}
	
	By changesAddress= By.xpath("//a[@href='javascript:void(false);']");
	By useThisAddress= By.xpath("//*[@id='shipToThisAddressButton']");	
	By cashOnDelivery= By.xpath("//*[@id='pp-nQljT3-72']");
	
	By mobileNumber= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	By streetName= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	By buldingName= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	By city= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	By district= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	By governorate= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	By addAddress= By.xpath("//*[@id='nav-flyout-ya-signin']");	
	
	
	public void  ChangeAdress ( )
	{
		waitUntilvisibilityOf(drvier, changesAddress);
		 WebElement changesAddressElement= drvier.findElement(changesAddress);
		jse.executeScript("arguments[0].scrollIntoView(true);", changesAddressElement);
		 
				
	}
	
	public Boolean  VerifyTherIsAnExistingAddress ( )
	{
		
		clickButton(drvier,changesAddress );
		waitUntilvisibilityOf(drvier, useThisAddress);
		if (elementIsDisplayed(drvier,useThisAddress)) {
			return true;
		
		}
		else return false;
				
	}
	
	public void  UseTheCurrentAddres ( )
	{
		
		waitUntilvisibilityOf(drvier, useThisAddress);
		clickButton(drvier,useThisAddress );
				
	}
	
	public void  ChooseCashonDeliveryIsApplicable ( )
	{
		waitUntilvisibilityOf(drvier, changesAddress);
		if(drvier.findElements(cashOnDelivery).size() != 0)
		{
			
			
			clickButton(drvier,cashOnDelivery );
		}
		
				
	}
	
	
}
