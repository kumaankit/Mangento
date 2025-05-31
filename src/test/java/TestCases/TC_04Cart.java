package TestCases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.CartPage;
import pageObject.Homepage;
import pageObject.Loginpage;
import pageObject.Searchproductpage;

public class TC_04Cart extends BaseClass {
	@Test(dataProvider = "Cartdata", dataProviderClass = DataProviders.class)
    public void cartFlowTest(String eid, String pass, String productName, String expectedResult) throws Exception {
		boolean actualResult = true;
		
		
		try { 
		// ====== Step 1: Login ======
		 Homepage home = new Homepage(driver);
		 home.clickLogin();
		 Loginpage lp = new Loginpage(driver);
		 lp.setEmail(eid);
		 lp.setpassword(pass);
		 lp.btnsign();
		 // Verify login page whether it is successfully sign or not
		 boolean messageShown = lp.welcomemessgae();
		 if(!messageShown)
			{			
				
			 throw new Exception("Login failed");
				
			}
	        
		 //verify search product
		   Searchproductpage searchPage = new Searchproductpage(driver);
	        searchPage.enterSearchQuery(productName);
	        searchPage.clickSearch();
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,500)");
	        
	          CartPage cart = new CartPage(driver);
	    
		        //  verify that whether search product is shown or not
		     
		        List<WebElement> productList = cart.getProducts();

		        if (!productList.isEmpty()) {
		             Thread.sleep(3000);

		            // Select random product
		            Random rand = new Random();
		            WebElement selectedProduct = productList.get(rand.nextInt(productList.size()));

		          Thread.sleep(2000);

		            // Click it
		            selectedProduct.click();

		        } else {
		            System.out.println("No products found.");
		        }
                       cart.selectRandomSize();
		                cart.selectRandomColor();
		                
		                cart.clickaddtocart();
		                
		                // After clicking on cart verify whether 
		                if(!cart.issuccessmessageshown()) {
		                	throw new Exception("Product was not added to cart.");
		                }
		                cart.shocart();
		}
		                
		                catch (Exception e) {
		      	          actualResult = false;
		      	          System.out.println("Test step failed: " + e.getMessage());
		      	      }

		      	      // Final validation against expected result
		      	      if (expectedResult.equalsIgnoreCase("Pass")) {
		      	          Assert.assertTrue(actualResult, "Expected test to pass, but it failed.");
		      	      } else {
		      	          Assert.assertFalse(actualResult, "Expected test to fail, but it passed.");
		      	      }    		
        
    }
}

