package pageObject;

//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchproductpage extends Basepage{

	public Searchproductpage (WebDriver driver)
    {
    	super (driver);
    }

	 @FindBy(xpath = "//input[contains(@class, 'input-text')]")  // Or update with the actual input box ID
	    WebElement searchBox;

	    @FindBy(xpath = "//button[@title='Search']")  // Replace with actual search button locator
	     WebElement searchButton;
	    
	   // @FindBy(xpath = "//img[@class='product-image-photo']")  // Replace with actual search button locator
	   //  WebElement productElement;
	    

	    @FindBy(xpath = "//div[contains(@class,'product-item')]")
	    WebElement productResult;

	    @FindBy(xpath = "//div[contains(@class,'message') and contains(@class,'notice')]")
	    WebElement noResultsMessage;
 

	    public void enterSearchQuery(String productName) {
	        searchBox.click();
	        searchBox.sendKeys(productName);
	    }

	    public void clickSearch() {
	        searchButton.click();
	    }
	   
	   
	    /*public boolean isProductFound() {
	        
	         try {   
	          return productElement.isDisplayed();
	        }catch (Exception e) {
                return false;
            }
	    } */
	     
	    public boolean isErrorMessageShown() {
	            try {
	                return noResultsMessage.isDisplayed();
	            } catch (Exception e) {
	                return false;
	            }

	    }}



