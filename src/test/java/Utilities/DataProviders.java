
package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProvider 1
	
		@DataProvider(name="Registerdata") 
		public String [][] getRegisterData() throws IOException
		{
			String path=".\\testData\\DataDriven.xlsx";//taking xl file from testData
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Registerpage");	
			int totalcols=xlutil.getCellCount("Registerpage",1);
					
			String registrationData[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					registrationData[i-1][j]= xlutil.getCellData("Registerpage",i, j);  //1,0
				}
			}
		return registrationData;//returning two dimension array
					
		}
		//DataProvider 2

		@DataProvider(name="LoginData") 
		public String [][] getLoginData() throws IOException
		{
			String path=".\\testData\\DataDriven.xlsx";//taking xl file from testData
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Login");	
			int totalcols=xlutil.getCellCount("Login",1); 
					
			String Logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
				Logindata[i-1][j]= xlutil.getCellData("Login",i, j);  //1,0
				}
			}
			return Logindata;
		} 
		
		
		
		//DataProvider 3
			@DataProvider(name="productdata") 
			public String [][] getproductData() throws IOException
			{
				String path=".\\testData\\DataDriven.xlsx";//taking xl file from testData
				
				ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
				
				int totalrows=xlutil.getRowCount("products");	
				int totalcols=xlutil.getCellCount("products",1); 
						
				String productdata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
				
				for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
				{		
					for(int j=0;j<totalcols;j++)  //0    i is rows j is col
					{
						productdata[i-1][j]= xlutil.getCellData("products",i, j);  //1,0
					}
				}
				return productdata;
			}
			
		
		//DataProvider 4
				@DataProvider(name="Cartdata") 
				public String [][] getcartData() throws IOException
				{
					String path=".\\testData\\DataDriven.xlsx";//taking xl file from testData
					
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("CartPages");	
					int totalcols=xlutil.getCellCount("CartPages",1); 
							
					String Cartdata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							Cartdata[i-1][j]= xlutil.getCellData("CartPages",i, j);  //1,0
						}
					}
					return Cartdata;
				}
					//DataProvider 5
					@DataProvider(name="Checkoutdata") 
					public String [][] getcheckoutData() throws IOException
					{
						String path=".\\testData\\DataDriven.xlsx";//taking xl file from testData
						
						ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
						
						int totalrows=xlutil.getRowCount("Checkoutpage");	
						int totalcols=xlutil.getCellCount("Checkoutpage",1); 
								
						String Checkoutdata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
						
						for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
						{		
							for(int j=0;j<totalcols;j++)  //0    i is rows j is col
							{
								Checkoutdata[i-1][j]= xlutil.getCellData("Checkoutpage",i, j);  //1,0
							}
						}
						return Checkoutdata;
						
					}
					
					//DataProvider 6

					@DataProvider(name="EndtoEnddata") 
					public String [][] getEndData() throws IOException
					{
						String path=".\\testData\\DataDriven.xlsx";//taking xl file from testData
						
						ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
						
						int totalrows=xlutil.getRowCount("EndtoEnd");	
						int totalcols=xlutil.getCellCount("EndtoEnd",1); 
								
						String EndtoEnddata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
						
						for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
						{		
							for(int j=0;j<totalcols;j++)  //0    i is rows j is col
							{
								EndtoEnddata[i-1][j]= xlutil.getCellData("EndtoEnd",i, j);  //1,0
							}
						}
						return EndtoEnddata;
						


}}

