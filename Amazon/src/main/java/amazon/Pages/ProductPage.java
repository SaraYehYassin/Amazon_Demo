package amazon.Pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.Base.PageBase;

public class ProductPage extends PageBase{
	
	
	By freeShipping_Checkbx= By.xpath("//*[contains(@href,'free_shipping')]/div[contains(@class, 'checkbox')]");
	//By getItByTomorrow_Checkbx= By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'Tomorrow')]");
	By new_Condition = By.xpath("//*[@id='p_n_condition-type/28071525031']");	
	By sortBy_BTN = By.xpath("//select[contains(@name,'s')]");
	
	By proceedToCheckoutBtn = By.xpath("//*[@title='Proceed to checkout']");	
	By addToCart = By.xpath("(//span[@class='a-button-text a-declarative'])[5]");
	By addedToCart_ProceedToChekout = By.xpath("//input[@value='Proceed to checkout']");
	By addedToCart_SuccessMsg = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']");
	By products =By.xpath("//*[@class='a-section aok-relative s-image-fixed-height']");	
	By price =By.xpath("(//span[@class='a-price-whole'])[1]");	
	By addToCartBOX =By.xpath("(//div[@class='a-box-inner'])[1]");	
	By addToCartBtn =By.xpath("//input[@id='add-to-cart-button']");	
	By addedToCartSuccessfully =By.xpath("//span[contains(text(),'Added to Cart')]");	
	By results =By.xpath("//span[contains(text(),'Results')]");
	By brand =By.xpath("//a[@class='a-link-normal'][@id='bylineInfo']");
	By nextPage=By.xpath("//a[@href='/-/en/s?i=videogames&bbn=18022560031&rh=n%3A18022560031%2Cp_n_free_shipping_eligible%3A21909080031&s=price-desc-rank&dc&page=2&language=en&qid=1683822107&rnid=21909079031&ref=sr_pg_1']");
	By noThanksBtn =By.xpath("//a[@class='a-link-normal'][@id='bylineInfo']");
	
	public ProductPage (WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
		 
	}
		
	//apply Filters on Products page
	public void  FilterForProducts (String sortOption )
	{
		waitUntilvisibilityOf(drvier, freeShipping_Checkbx);	
		clickButton(drvier, freeShipping_Checkbx);
		WebElement new_ConditionElement = drvier.findElement(By.id("p_n_condition-type/28071525031"));  
		jse.executeScript("arguments[0].scrollIntoView(true);", new_ConditionElement);	
		clickButton(drvier, new_Condition);
		jse.executeScript("scroll(0, 250);");
        waitUntilvisibilityOf(drvier, sortBy_BTN);
		WebElement element = drvier.findElement(sortBy_BTN);
		action.moveToElement(element).click().build().perform();	
		selectByVisibleText(drvier,sortBy_BTN , sortOption);
		
				
		
	}
	//verify the Sort Is Selected
	
	public boolean  verifySortIsSelected (String sortOption)
	{
		
		 waitUntilClickableOf(drvier, sortBy_BTN);
	
		 Select select = new Select(drvier.findElement(sortBy_BTN));
		 WebElement option =select.getFirstSelectedOption();
		 String SelectedText = option.getText();
		 System.out.println(SelectedText);
			
		
		if (SelectedText.contains(sortOption))
				{
			return true;
		
		}
		else return false;
		
	}	
	//Add To Cart All Products Less Than 15K
	
	public Integer  AddToCartWhenProductsLessThan (int lessThanvalue)
	{		
	    List<WebElement> productsList = drvier.findElements(products);
		
		int productSize= productsList.size();
		//Make a for loop for all products in the page and add if the product is exist and less than 15k
		int prductsCount=0;	
		for (int i = 0; i < productSize; i++)
		{				
			 productsList = drvier.findElements(products);
		    WebElement productElement = productsList.get(i);
			clickButtonWebElement(drvier,productElement );
			waitUntilvisibilityOf(drvier, brand);
			//drvier.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   		 
   		if(drvier.findElements(addToCartBtn).size() == 0) 
		{
   		 getBack(drvier);			
		waitUntilvisibilityOf(drvier, results);	}	
	
   		else {
   		 WebElement priceElement= drvier.findElement(price);
   	  			int priceInt = Integer.parseInt(priceElement.getText().replace(",", ""));  
   	  			System.out.println(priceInt);
   			
   				if( priceInt < lessThanvalue) 
   				{						
   					clickButton(drvier, addToCartBtn);   
   					
   				
   					waitUntilvisibilityOf(drvier, addedToCart_ProceedToChekout);
   					if( drvier.findElements(addedToCart_SuccessMsg).size() != 0)
   					{
   						prductsCount++;
   						
   						
   					}
   					 
   					getBack(drvier);
   					getBack(drvier);
   					refreshPage(drvier);
   					waitUntilvisibilityOf(drvier, results);	
   					
   				}
   				else {
   					getBack(drvier);   					
   					waitUntilvisibilityOf(drvier, results);
   		
   				}
   				
	}
   		
		}
		
		return prductsCount;
			
		}
		
         //Verify Product Added To The Cart 
		
		public boolean  VerifyProductAddedToTheCart ( )
		{
			
			waitUntilvisibilityOf(drvier, addedToCart_SuccessMsg);
			if (elementIsDisplayed(drvier,addedToCart_SuccessMsg)) {
				return true;
				
			}
			else return false;
			}
		
		public void  GoToNextPageIfCartIsSTillEmpty (Integer products ,int lessthan )
		{
			if(products==0)
			{
			  					
					waitUntilvisibilityOf(drvier, nextPage);
					clickButton(drvier, nextPage); 
				  //  AddTolessThanValue(lessthan);
				
			}
			
		
		}
		
		}
	
	

			
	

