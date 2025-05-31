package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Checkoutpage extends Basepage {
	public Checkoutpage(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath = "//button[@type='button' and @data-role='proceed-to-checkout' and @title='Proceed to Checkout' and contains(@class, 'action primary checkout')]")
	 public  WebElement checkout; 
	
	@FindBy(xpath = "//div[contains(@class, 'shipping-address-item') and contains(@class, 'selected-item')]")
	public List<WebElement> ShipAddressList;  // Use List to avoid exception if not found
	
	@FindBy(xpath = "//input[@name='street[0]']")
	public WebElement boxStreet;
	
	@FindBy(xpath = "//input[@name='city']") 
	WebElement boxcity;
	
	@FindBy(xpath = "//select[@name='region_id']")
	   WebElement boxstate;
	
	@FindBy(xpath = "//input[@name='postcode']")
	   WebElement boxZip;
	
	@FindBy(xpath = "//select[@name='country_id']")
	   WebElement dropcountry;
	
	@FindBy(xpath = "//input[@name='telephone']")
	   WebElement boxnumber;
	@FindBy(xpath = "//button[@data-role='opc-continue']/span[text()='Next']")
	   WebElement btnNext;
	
	
	
	public void clickcheckout() {
	       checkout.click();
	    }
		
		
	        // Proceed to cart or ch
		public void street(String str) {
		       boxStreet.sendKeys(str);
		    }
		public void city(String citi) {
			boxcity.sendKeys(citi);
		    }

		public void selectStateByIndex(int index) {
		    Select select = new Select(boxstate);
		    select.selectByIndex(index);	       
		    }
		
		public void Zipcode(String zip) {
		       boxZip.sendKeys(zip);
		    }
		public void selectcountryByIndex(int index) {
		    Select select1 = new Select(dropcountry);
		    select1.selectByIndex(index);	       
		    }


		public void phoneno(String phone) {
			boxnumber.sendKeys(phone);
		}
		       
		       public void Next() {
			       btnNext.click();
		       }
			       
			      
					    		
		       public boolean isShippingAddressPresent() {
		    	    return !ShipAddressList.isEmpty() && ShipAddressList.get(0).isDisplayed();
		    	}
	    		         
	    		        
	    		        }
	    		    
	   








