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
import fawry.sofAutomation.pages.lookupDefinitions.AddAccountTypeProfilePage;
import fawry.sofAutomation.pages.lookupDefinitions.AddCustomerProfilePage;
import fawry.sofAutomation.pages.lookupDefinitions.SearchCustomerProfilePage;
import fawry.sofAutomation.pages.lookupDefinitions.SearchFinanceProgramTypePage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchFinanceProgramTypePojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchFinanceProgramTypeTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchFinanceProgramTypePage searchFinanceProgramType = new SearchFinanceProgramTypePage(driver);	
		searchFinanceProgramType.moveToPage("Lookup Definitions", "Search Financial Program Type", driver);
		
	}
	

	@Test(description="Validate search financial Functionality",priority=1, dataProvider="searchfinancialprogramDataProvider")
	public static void searchFinanceProgramType(SearchFinanceProgramTypePojo srchFinanceProgramobj)
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		SearchFinanceProgramTypePage searchhFinanceProgramobj = new SearchFinanceProgramTypePage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Search_Finance_Program_Type);
		
		try {
			searchhFinanceProgramobj.searchFinanceCustomerTypedata(srchFinanceProgramobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sa.assertAll();
		
	}


	@DataProvider(name = "searchfinancialprogramDataProvider")
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
			SearchFinanceProgramTypePojo searchfinanceprogramTestData = new SearchFinanceProgramTypePojo();

			searchfinanceprogramTestData.setFinanceProgramcode_txt(resultArray.get(i).get(0).toString());
					
			
			result[i][0] = searchfinanceprogramTestData;

		}

		return result;
	}

	
}
