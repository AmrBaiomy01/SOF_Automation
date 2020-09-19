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
import fawry.sofAutomation.pages.lookupDefinitions.AddPSPPage;
import fawry.sofAutomation.pages.lookupDefinitions.SearchPSPPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddPSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchPSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchPSPTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchPSPPage searchpsp = new SearchPSPPage(driver);
		searchpsp.moveToPage("Lookup Definitions", "Search PSP", driver);
	}
	

	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="SearchPSPDataProvider")
	public static void searchPSPDetails(SearchPSPPojo searchPSPobj)  
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		SearchPSPPage searchpsp = new SearchPSPPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Search_PSP_URL);
		
		
		try {
			searchpsp.searchPSPdata(searchPSPobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//calling search method
		
		//searchpsp.saveOrCancelOrCancel(searchPSPobj);
		
		sa.assertAll();

	}


	@DataProvider(name = "SearchPSPDataProvider")
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
			SearchPSPPojo PSPsearchData = new SearchPSPPojo();

			PSPsearchData.setCode_txt(resultArray.get(i).get(0).toString());
			PSPsearchData.setStatus_list(resultArray.get(i).get(1).toString());
								
			result[i][0] = PSPsearchData;

		}

		return result;
	}


	
}
