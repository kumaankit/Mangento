package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Basepage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Product list (now private)
    @FindBy(xpath = "//li[contains(@class,'product-item')]")
    private List<WebElement> products;

    @FindBy(xpath = "//div[@id='option-label-size-143-item-167']")
    public WebElement size;

    @FindBy(xpath = "//div[contains(@class, 'swatch-option color')]")
    public WebElement color;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addcart;
    
    @FindBy(xpath = "//div[contains(@class,'message-success')]")
    public WebElement successMsg;

    @FindBy(xpath = "//div[contains(@class,'message-error')]")
    public WebElement errorMsg;
    
    @FindBy(xpath = "//a[text()='shopping cart']")
    public WebElement shoppingcart;

    // ✅ Getter for products
    public List<WebElement> getProducts() {
        return products;
    }

    // Optional: methods to click size and color
    public void selectRandomSize() {
        try {
            size.click();
        } catch (Exception e) {
            System.out.println("⚠️ Size not selectable.");
        }
    }

    public void selectRandomColor() {
        try {
            color.click();
        } catch (Exception e) {
            System.out.println("⚠️ Color not selectable.");
        }
    }
        public void clickaddtocart() {
            addcart.click();
        }
        
        public boolean issuccessmessageshown() {
	        
	         try {   
	          return successMsg.isDisplayed();
	        }catch (Exception e) {
               return false;
           }
	    } 
	     
	    public boolean isErrorMessageShown() {
	            try {
	                return errorMsg.isDisplayed();
	            } catch (Exception e) {
	                return false;
	            }
	    }
        public void shocart() {
        	shoppingcart.click();
        }

       /* public boolean validateCartAddition() {
            try {
              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

                // Wait for either success or error message
                if (wait.until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOf(successMsg),
                        ExpectedConditions.visibilityOf(errorMsg)))) {

                    if (successMsg.isDisplayed()) {
                        System.out.println("✅ Success: " + successMsg.getText());
                        return true;
                    } else if (errorMsg.isDisplayed()) {
                        System.out.println("❌ Error: " + errorMsg.getText());
                        return false;
                    }
                }
            

        } catch (Exception e) {
            System.out.println("⚠️ No confirmation message shown: " + e.getMessage());
        }

        return false; // if neither message is */

}

