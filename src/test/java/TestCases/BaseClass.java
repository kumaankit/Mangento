
package TestCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	 
	public Logger logger;// Log4j	
	public Properties p; 
		
		
		@BeforeMethod()
		@Parameters({"os", "browser"})
		     public void setup( String os , String br) throws IOException {
			
			//Loading config.properties file
			
			FileReader file = new FileReader("./src//test//resources//config.properties");
			p = new Properties();
			p.load(file);
			
			logger = LogManager.getLogger(this.getClass());
			
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN11);//setPlatform(Platform.WIN11);
				}
				else if (os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if (os.equalsIgnoreCase("linux"))
				{
					capabilities.setPlatform(Platform.LINUX);
				}
				else
				{
					System.out.println("No matching os");
					return;
				}
				//browser
				switch (br.toLowerCase())
				{
				case "chrome" : capabilities.setBrowserName("chrome"); break;
				case "edge": capabilities.setBrowserName("edge"); break;
				case "firefox": capabilities.setBrowserName("firefox"); break;
				default: System.out.println("No matching browser"); return;
				
				} 
			
				driver=new RemoteWebDriver(new URL("http://192.168.29.194:4444"), capabilities);
			}
			
			
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
				case "chrome": driver=new ChromeDriver(); break;
				case "edge": driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default : System.out.println("Invalid browser name.."); return;
			}
		}	
		    	
		    	
		        driver.manage().deleteAllCookies();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.get(p.getProperty("appURL"));
		        driver.manage().window().maximize();
		    }

		    @AfterMethod ()
		    public void tearDown() {
		        driver.quit();
		    }

		    public String randomString() {
		        String generatedString = RandomStringUtils.randomAlphabetic(5);
		        return generatedString;
		    }
		    public String randomNumber() {
		        String generatedNumber = RandomStringUtils.randomNumeric(10);
		        return generatedNumber;
		    }

		    public String randomAlphaNumeric() {
		        String generatedString = RandomStringUtils.randomAlphabetic(3);
		        String generatedNumber = RandomStringUtils.randomNumeric(3);
		        return (generatedString + "@" + generatedNumber);}
		        
		        public String captureScreen(String tname) throws IOException {

		    		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    				
		    		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		    		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		    		
		    		String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\" + tname + "_" + timeStamp + ".png";
		    		File targetFile=new File(targetFilePath);
		    		
		    		sourceFile.renameTo(targetFile);
		    			
		    		return targetFilePath; 

	}
	}

