package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orderconfirmpage extends Basepage {
	public Orderconfirmpage (WebDriver driver)
    {
    	super (driver);
    }
	
	@FindBy(xpath = "//button[.//span[normalize-space(text())='Place Order']]")
	  public  WebElement Placeorder;
	

	@FindBy(xpath = "//span[text()='Thank you for your purchase!']")
	  public WebElement confirmorder;

	 public void Placeor() {
		 Placeorder.click();
	    }


	 public boolean orderconfirmmessage()
		{
			try
			{
				// Check if the success message contains the expected text
				return confirmorder.isDisplayed();
			}
			catch(Exception e)
			{
				 // If there’s any problem (like message not found), return false
				return false;
			}
    
		}

}
