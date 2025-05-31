package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountpage extends Basepage {

	public CreateAccountpage(WebDriver driver) {
        super (driver);
    }

	@FindBy(xpath = "//input[@id='firstname']")
    WebElement txtFirstname;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement txtLastname;

    @FindBy(xpath = "//input[@id='email_address']")
    WebElement txtEmail;

    

    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    WebElement txtConfirmPassword;

   
    
    @FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    WebElement btnaccount;
    
    @FindBy(xpath="//div[@data-ui-id='message-success']")
    WebElement msgConfirmation;

    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastname.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }
   
    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String cpwd) {
        txtConfirmPassword.sendKeys(cpwd);
    }

   

    public void clickContinue() { 
    	btnaccount.click();
    }
    
    public boolean isConfirmationMessageShown()
	{
		try
		{
			// Check if the success message contains the expected text
			return msgConfirmation.isDisplayed();
		}
		catch(Exception e)
		{
			 // If there’s any problem (like message not found), return false
			return false;
		}

	}

}
