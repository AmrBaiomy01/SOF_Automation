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
import fawry.sofAutomation.pojos.lookupDefinitions.AddCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchCustomerProfilePojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchCustomerProfileTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchCustomerProfilePage searchCustomerProfile = new SearchCustomerProfilePage(driver);	
		searchCustomerProfile.moveToPage("Lookup Definitions", "Search Customer Profile", driver);
		
	}
	

	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="searchCustomerProfileDataProvider")
	public static void searchCustomerProfileDetails(SearchCustomerProfilePojo srchcustomerprofileobj)
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		SearchCustomerProfilePage searchCustomerprofileData = new SearchCustomerProfilePage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Search_Customer_Profile_URL);
		
		try {
			searchCustomerprofileData.searchACustomerProfiledata(srchcustomerprofileobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sa.assertAll();
	}


	@DataProvider(name = "searchCustomerProfileDataProvider")
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
			SearchCustomerProfilePojo searchcustomerprofileTestData = new SearchCustomerProfilePojo();

			searchcustomerprofileTestData.setCustomerprofilecode_txt(resultArray.get(i).get(0).toString());
			searchcustomerprofileTestData.setCustomerMobileNumber_txt(resultArray.get(i).get(1).toString());
			searchcustomerprofileTestData.setCustomerName_txt(resultArray.get(i).get(2).toString());
			searchcustomerprofileTestData.setCSPName_List(resultArray.get(i).get(3).toString());
			
			
			result[i][0] = searchcustomerprofileTestData;

		}

		return result;
	}

	
}
