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
import fawry.sofAutomation.pages.lookupDefinitions.SearchAcquirerBankPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchAcquirerPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchAcquirerBankTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchAcquirerBankPage addacquirer = new SearchAcquirerBankPage(driver);	
		addacquirer.moveToPage("Lookup Definitions", "Search Acquirer Bank", driver);
		
	}
	

	@Test(description="Validate Ssearch Acquirer Functionality",priority=1, dataProvider="SearchAcquirerBankDataProvider")
	public static void AddAcquirerDetails(SearchAcquirerPojo searchacquirerobj)  
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		SearchAcquirerBankPage addacquirer = new SearchAcquirerBankPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Search_Acquirer_Banks_URL);
		
		//Choosing to add account by location id with either an existing region or by adding new region
		
	
		addacquirer.SearchorReset(searchacquirerobj);
		
		sa.assertAll();

	}


	@DataProvider(name = "SearchAcquirerBankDataProvider")
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
			SearchAcquirerPojo acquirerTestData = new SearchAcquirerPojo();

			acquirerTestData.setBank_Code(resultArray.get(i).get(0).toString());
			acquirerTestData.setBIN(resultArray.get(i).get(1).toString());
			acquirerTestData.setStatus(resultArray.get(i).get(2).toString());			

			result[i][0] = acquirerTestData;

		}


		return result;
	}


	
}
