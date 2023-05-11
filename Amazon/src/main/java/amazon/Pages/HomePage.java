package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import amazon.Base.PageBase;


public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}
	
	
	By accountList= By.xpath("//*[@id='nav-link-accountList-nav-line-1']");	
	By signIN= By.xpath("//*[@class='nav-action-inner']");	
	By emailAddressTxtBox = By.id("ap_email");
	By continueBtn = By.xpath("//span[@id='continue']");
	By passwordTxtBox = By.xpath("//*[@id='ap_password']");
	By auth_SignIn =  By.xpath("//*[@id='signInSubmit']");
	By signOut = By.xpath("//*[@id='nav-item-signout']");
	By allSideMenuList = By.xpath("//span[@class='hm-icon-label']");
	By seeAll_SideMenuList = By.xpath("//a[@class='hmenu-item hmenu-compressed-btn']");
	By cart = By.xpath("//*[@id='nav-cart-count']");
	By proceedTocart = By.xpath("//*[@id='nav-cart-count']");
	By proceedToBuy= By.xpath("//div[contains(text(),'Proceed to Buy')]");
	
	
    

		 
    public void LoginIn(String mobileNumber, String password) throws InterruptedException
    {
    	
    	
    	//jse.executeScript("arguments[0].click();",);
    	HoverOverElement(drvier, accountList);
    	clickButton(drvier,  signIN);
    	waitUntilvisibilityOf(drvier, emailAddressTxtBox);
    	setTextElementText(drvier, emailAddressTxtBox, mobileNumber);
    	clickButton(drvier,  continueBtn);
    	waitUntilvisibilityOf(drvier, passwordTxtBox);
    	setTextElementText(drvier, passwordTxtBox, password);
    	waitUntilvisibilityOf(drvier, auth_SignIn);
    	clickButton(drvier,  auth_SignIn);  	
    	  
    }	 
		
	public Boolean checkUserIsSignedInSuccessfully ()
	{
		waitUntilvisibilityOf(drvier, accountList);
		HoverOverElement(drvier, accountList);
		if (elementIsDisplayed(drvier,signOut)) {
			return true;
		
		}
		else return false;
		
	}
	

	//Select specific Category
	public void  selectSpecificSubCategory (String mainMenu, String subMenu)
	{
		clickButton(drvier, allSideMenuList);
		
		waitUntilvisibilityOf(drvier, seeAll_SideMenuList);
		clickButton(drvier, seeAll_SideMenuList);
		By mainMenuBY = By.xpath("//div[contains(text(),'"+mainMenu+"')]/..");
		waitUntilvisibilityOf(drvier, mainMenuBY);	
		clickButton(drvier,mainMenuBY );		
		By item = By.xpath("//a[contains(text(),'"+subMenu+"')]");
		waitUntilvisibilityOf(drvier, item);
		clickButton(drvier, item);		
	}
	
	public boolean  verifyCategoryIsSelected (String selectedItem)
	{
		//b[contains(text(),'Video Games')]
		By selectedItemBY = By.xpath("//b[contains(text(),'"+selectedItem+"')]");
		waitUntilvisibilityOf(drvier, selectedItemBY);	
		
		if (elementIsDisplayed(drvier,selectedItemBY)) {
			return true;
		
		}
		else return false;
		
	}	
	
	
	public void  openCart ()
	{
		clickButton(drvier, cart);
		waitUntilvisibilityOf(drvier, proceedToBuy);
			
	}
	
	

	
	
	
}
