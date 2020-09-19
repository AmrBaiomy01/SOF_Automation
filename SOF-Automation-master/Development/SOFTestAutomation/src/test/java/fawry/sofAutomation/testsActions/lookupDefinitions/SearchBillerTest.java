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
import fawry.sofAutomation.pages.lookupDefinitions.AddBillerPage;
import fawry.sofAutomation.pages.lookupDefinitions.AddCSPPage;
import fawry.sofAutomation.pages.lookupDefinitions.SearchBillerPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddBillerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchBillerPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchBillerTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchBillerPage searchBiller = new SearchBillerPage(driver);
		searchBiller.moveToPage("Lookup Definitions", "Search Biller", driver);
		
	}
	

	@Test(description="Validate search Biller Functionality",priority=1, dataProvider="searchBillerDataProvider")
	public static void searchBillerDetails(SearchBillerPojo searchBillerobj)  
	{
		test = extent.createTest("Validate search Biller Functionality");
		
		SoftAssert sa = new SoftAssert();
		SearchBillerPage searchBiller = new SearchBillerPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Search_Biller_URL);
		
		try {
			searchBiller.searchBillerdata(searchBillerobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sa.assertAll();

	}


	@DataProvider(name = "searchBillerDataProvider")
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
			SearchBillerPojo searchBillerTestData = new SearchBillerPojo();

			searchBillerTestData.setCode_txt(resultArray.get(i).get(0).toString());
						
			result[i][0] = searchBillerTestData;

		}

		return result;
	}


	
}
