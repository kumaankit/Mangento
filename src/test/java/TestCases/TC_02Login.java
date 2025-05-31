package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.Homepage;
import pageObject.Loginpage;

public class TC_02Login extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")
    public void verify_login_page(String eid,String pass,String exp) throws InterruptedException {
        
		 boolean actualResult = true;
		
		//	logger.debug("**** Starting TC001_AccountRegistrationTest  ****");
		try {
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
	        

	    } catch (Exception e) {
	        actualResult = false;
	        System.out.println("Test failed: " + e.getMessage());
	    }

	    // Final assertion against expected result
	    if (exp.equalsIgnoreCase("Pass")) {
	        Assert.assertTrue(actualResult, "Expected registration to pass but it failed.");
	    } else {
	        Assert.assertFalse(actualResult, "Expected registration to fail but it passed.");
	    }
	   		
	
	}}
