package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	 public Loginpage (WebDriver driver)
	    {
	    	super (driver);
	    }

	 @FindBy(xpath = "//input[@id='email']")
	    WebElement emailid;

	    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	   WebElement password;
	    
	    @FindBy(xpath="//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	    WebElement clicksignin;
	  
	    @FindBy(xpath = "//span[@class='logged-in' and starts-with(text(), 'Welcome,')]")
		   WebElement confirmtext;
	    

	    public void setEmail(String eid) {
	       emailid.sendKeys(eid);
	    }

	    public void setpassword(String pass) {
	        password.sendKeys(pass);
	    }
	        
	        public void btnsign() {
		       clicksignin.click();
		       
	        }
		     
		       public boolean welcomemessgae()
				{
					try
					{
						// Check if the success message contains the expected text
						return confirmtext.isDisplayed();
					}
					catch(Exception e)
					{
						 // If there’s any problem (like message not found), return false
						return false;
					}
		       
		      
				}

}


