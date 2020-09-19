package fawry.sofAutomation.testsActions.lookupDefinitions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import fawry.sofAutomation.constants.lookupDefinitions.Constants;
import fawry.sofAutomation.pages.login.LoginPage;
import fawry.sofAutomation.pages.lookupDefinitions.AddCSPPage;
import fawry.sofAutomation.pages.lookupDefinitions.SearchCSPPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchCSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchCSPTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchCSPPage searchcsp = new SearchCSPPage(driver);
		searchcsp.moveToPage("Lookup Definitions", "Search CSP", driver);
		
	}
	

	@Test(description="Validate Add CSP Functionality",priority=1, dataProvider="SearchCSPDataProvider")
	public static void SearchCSPDetails(SearchCSPPojo searchCSPobj)  
	{
		test = extent.createTest("Validate Add CSP Functionality");
		
		SoftAssert sa = new SoftAssert();
		SearchCSPPage srchCSP = new SearchCSPPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Search_CSP_URL);
				
		try {
			srchCSP.SearchCSPdata(searchCSPobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//save method
		
		
		sa.assertAll();

	}


	@DataProvider(name = "SearchCSPDataProvider")
	public Object[][] provideTestData(Method method)
	{

		String methodFullName = method.getName();

		PropertiesFilesHandler propLoader = new PropertiesFilesHandler();
		Properties prop = propLoader.loadPropertiesFile(Constants.TEST_DATA_CONFIG_FILE_NAME);

		String connectionProperties = prop.getProperty(methodFullName);

		ArrayList<ArrayList<Object>> resultArray = provideTestData(connectionProperties);
		Object[][] result = new Object[resultArray.size()][1];


		for(int i=0; i<resultArray.size(); i++)
		{
			SearchCSPPojo srchCSPTestData = new SearchCSPPojo();

			srchCSPTestData.setCode_txt(resultArray.get(i).get(0).toString());
					
			result[i][0] = srchCSPTestData;

		}

		return result;
	}


	
}
