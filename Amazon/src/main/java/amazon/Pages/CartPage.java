package amazon.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.Base.PageBase;

public class CartPage extends PageBase{
	
	public CartPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}
	
	
	//By proceedToBuy= By.xpath("//*[@id='a-autoid-0']");	
	By productsCount =By.xpath("//span[@class='a-dropdown-label']");		
	List<WebElement> productsList = drvier.findElements(productsCount);    
	int elementsCount = productsList.size();
	By proceedToBuy= By.xpath("//input[@value='Proceed to checkout']");
	
	
	public Integer  ProductsCountInCart ( )
	{
		List<WebElement> productsList = drvier.findElements(productsCount);    
		int elementsCount = productsList.size();
		return elementsCount;
		//System.out.println(elementsCount);
			
		}
	
	public void  ProceedToBuy ( )
	{
		waitUntilvisibilityOf(drvier, proceedToBuy);
		clickButton(drvier, proceedToBuy);
		
		
			
		}
	

}
