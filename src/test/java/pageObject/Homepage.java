package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
        super (driver);
    }

	@FindBy(linkText = "Create an Account")   // Login link added in step5
    WebElement InkRegister;
   
    @FindBy(linkText= "Sign In")
    WebElement linkLogin;
    
    
   

    public void clickRegister() {
        InkRegister.click();
    }

    public void clickLogin() {
    	linkLogin.click();
    }



}
