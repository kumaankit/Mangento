package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.CreateAccountpage;
import pageObject.Homepage;

public class TC_01registeration extends BaseClass{

	@Test(dataProvider="Registerdata", dataProviderClass=DataProviders.class,groups="Datadriven")
    public void verify_account_registration(String fname,String lname, String email,String pwd, String cpwd, String exp) throws InterruptedException {
        
		logger.debug("**** Starting TC001_AccountRegistrationTest  ****");
		
		boolean actualResult = true;
		
		
		try {	
		
	
        Homepage hp = new Homepage(driver);
        logger.debug("Clicked on Register Link...");
        Thread.sleep(2000);
        hp.clickRegister();
       
    

        CreateAccountpage regpage = new CreateAccountpage(driver);
      logger.debug("Providing customer details...");
       
        
        regpage.setFirstName(fname);
        regpage.setLastName(lname);
        regpage.setEmail(email);
       
        regpage.setPassword(pwd);
        regpage.setConfirmPassword(cpwd);
       
        regpage.clickContinue();
        
        if (!regpage.isConfirmationMessageShown()) {
            throw new Exception("Confirmation message not shown or registration failed.");
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
       