package TestCases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.CartPage;
import pageObject.Checkoutpage;
import pageObject.Homepage;
import pageObject.Loginpage;
import pageObject.Orderconfirmpage;
import pageObject.Searchproductpage;

public class TC_06EndtoEnd extends BaseClass{

	
	@Test(dataProvider="EndtoEnddata", dataProviderClass=DataProviders.class,groups="Datadriven")
    public void verify_EndtoENd(String eid,String pass, String productName, String str,String citi, String zip, String phone, String expectedResult ) throws InterruptedException {
		
		 boolean actualResult = true;
		
		try {
		// Login page test
		 Homepage home = new Homepage(driver);
		 home.clickLogin();
		 Loginpage lp = new Loginpage(driver);
		 lp.setEmail(eid);
		 lp.setpassword(pass);
		 lp.btnsign();
		 
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
		                
		    // Verify checkout page
	        Checkoutpage ck = new Checkoutpage(driver);
	        
	         ck.clickcheckout();

	        if (ck.isShippingAddressPresent()) {
	            Thread.sleep(2000); // Better to replace with WebDriverWait
	            ck.Next();
	        } else {
	        	Thread.sleep(2000);
	            ck.street(str); 
	            ck.city(citi);
	            ck.selectStateByIndex(2);
	            ck.Zipcode(zip);
	            ck.selectcountryByIndex(3);
	            ck.phoneno(phone);

	            Thread.sleep(3000); // Again, prefer WebDriverWait
	            ck.Next();
	            
	        }
	        
	        Orderconfirmpage ord = new Orderconfirmpage(driver);
	        Thread.sleep(4000);
	        
	        ord.Placeor();
	       boolean confirmorder =    ord.orderconfirmmessage();
	      
	       if (!confirmorder) {
	            throw new Exception("Order confirmation message not shown.");
	        } 
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
	        		
	}}     		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	
	
	
        

