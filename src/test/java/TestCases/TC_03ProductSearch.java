package TestCases;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.CartPage;
import pageObject.Searchproductpage;

public class TC_03ProductSearch extends BaseClass{
	@Test(dataProvider="productdata", dataProviderClass=DataProviders.class,groups="Datadriven")
    public void verify_Productsearch_page(String productName) throws InterruptedException {
        
		Searchproductpage searchPage = new Searchproductpage(driver);
        searchPage.enterSearchQuery(productName);
        searchPage.clickSearch();
        JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,500)");
	       CartPage cart = new CartPage(driver);
		    
	        //  verify that whether search product is shown or not
	     
	        List<WebElement> productList = cart.getProducts();

	        if (!productList.isEmpty()) {
	        	Assert.assertTrue(true);
    }
	        else
	        {
	        	Assert.assertTrue(false);
	        }
	
	}}
	
	
	
	
	
