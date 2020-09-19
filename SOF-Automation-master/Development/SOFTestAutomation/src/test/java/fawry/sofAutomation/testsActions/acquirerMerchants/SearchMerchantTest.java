package fawry.sofAutomation.testsActions.acquirerMerchants;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import fawry.sofAutomation.constants.acquirereMerchants.Constants;
import fawry.sofAutomation.dbVerification.acquirereMerchants.AddacquirerVefication;
import fawry.sofAutomation.pages.acquirerMerchants.SearchAcquirerMerchantPage;
import fawry.sofAutomation.pages.login.LoginPage;
import fawry.sofAutomation.pojos.acquirerMerchants.SearchPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class SearchMerchantTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchAcquirerMerchantPage searchacquirer = new SearchAcquirerMerchantPage(driver);
		searchacquirer.moveToPage("Acquirer Merchants", "Search Acquirer Merchant", driver);
	}

	
	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="AddAcquirerDataProvider")
	public static void SearchMerchantData(SearchPojo searchacquirerobj)  
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		
		SearchAcquirerMerchantPage searchAcquirer = new SearchAcquirerMerchantPage(driver);
		
		
		//AddacquirerVefication addacquveri = new AddacquirerVefication();
		//SearchPojo srchacquirer =new SearchPojo();

		driver.navigate().to(Constants.SEARCH_MERCHANTS_URL);
		
		//Choosing to add account by location id with either an existing region or by adding new region
		try {
			searchAcquirer.searchMerchant(searchacquirerobj);
			searchAcquirer.saveOrCancel(searchacquirerobj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sa.assertAll();

	}


	@DataProvider(name = "AddAcquirerDataProvider")
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
			SearchPojo acquirerTestData = new SearchPojo();

			acquirerTestData.setAcquirer_Bank(resultArray.get(i).get(0).toString());
			acquirerTestData.setPayment_Type(resultArray.get(i).get(1).toString());
			acquirerTestData.setBiller(resultArray.get(i).get(2).toString());
			acquirerTestData.setBill_type(resultArray.get(i).get(3).toString());
			acquirerTestData.setMerchant_ID(resultArray.get(i).get(4).toString());
			acquirerTestData.setRetailer_code(resultArray.get(i).get(5).toString());
			

			result[i][0] = acquirerTestData;

		}


		return result;
	}


	
}
