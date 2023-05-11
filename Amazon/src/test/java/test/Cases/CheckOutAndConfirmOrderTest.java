package test.Cases;



import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.Pages.CartPage;
import amazon.Pages.CheckoutPage;
import amazon.Pages.HomePage;
import amazon.Pages.ProductPage;
import amazon.TestData.TestData;



public class CheckOutAndConfirmOrderTest extends amazon.Base.TestBase{
	

	String url= userdata.getProperty("url");
	HomePage homeObject;
	ProductPage productObject;
	CartPage cartObject;
	CheckoutPage checkoutObject;
	
	
		   
	@BeforeClass
	public void OpenURL ()
	{
	openBrowser(url);
	driver.manage().deleteAllCookies();
	homeObject = new HomePage(driver); 
	productObject = new ProductPage(driver);
	cartObject= new CartPage(driver);
	checkoutObject= new CheckoutPage(driver);
	
	

	}
  @Test (priority = 1,dataProvider= "LoginExistingUser")
  public void LoginIn(String mobileNumber,String password) throws InterruptedException 
  {
	  homeObject.LoginIn(mobileNumber, password);
	Assert.assertTrue(homeObject.checkUserIsSignedInSuccessfully());
	 

}
  
  @Test (priority = 2,dataProvider= "ShppItemData")
  public void ShopItemAndCheckOut(String shopCategoty, String shopSubCategory, String sortType, String indicator) throws InterruptedException 
  {
	 
	homeObject.selectSpecificSubCategory(shopCategoty,shopSubCategory );
	assertTrue(homeObject.verifyCategoryIsSelected(indicator));
	
	productObject.FilterForProducts(sortType);
	assertTrue(productObject.verifySortIsSelected(sortType));
	
	productObject.AddToCartAllProductsLessThan15K();
	//To go to next page if the cart is empty
	//productObject.goToNextPageIfCartIsSTillEmpty(productObject.AddToCartAllProductsLessThan15K());
	homeObject.openCart();
//	assertEquals(productObject.AddToCartAllProductsLessThan15K(), cartObject.ProductsCountInCart());
	cartObject.ProceedToBuy();
	
	
	
	checkoutObject.ChangeAdress();
	checkoutObject.VerifyTherIsAnExistingAddress();
	checkoutObject.UseTheCurrentAddres();
	checkoutObject.ChooseCashonDeliveryIsApplicable();
	
	


	
}
  
  @DataProvider(name="ShppItemData")
  public Object[][] ShppItemData () throws InvalidFormatException, IOException 
  {
         Object[][] data = TestData.fetchData(System.getProperty("user.dir")+"\\UsserData.xlsx", "ShopItem");
      		   
         return data;
  }  
  
  @DataProvider(name="LoginExistingUser")
  public Object[][] RegisterNewUser () throws InvalidFormatException, IOException 
  {
         Object[][] data = TestData.fetchData(System.getProperty("user.dir")+"\\UsserData.xlsx", "LoginExistingUser");
      		   
         return data;
  }  
   
  @AfterClass
  
	public void stopDriver() 
	{
		driver.quit();
	}
	
}
