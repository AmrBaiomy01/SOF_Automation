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
import fawry.sofAutomation.pojos.lookupDefinitions.AddCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddCustomerProfileTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddCustomerProfilePage addcustomerprofile = new AddCustomerProfilePage(driver);	
		addcustomerprofile.moveToPage("Lookup Definitions", "Add Customer Profile", driver);
		
	}
	

	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="AddCustomerProfileDataProvider")
	public static void AddCustomerProfileDetails(AddCustomerProfilePojo addcustomerprofileobj)
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddCustomerProfilePage addCustomerprofileData = new AddCustomerProfilePage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_Customer_Profile_URL);
		
		//Choosing to add account by location id with either an existing region or by adding new region
		try {
			addCustomerprofileData.addACustomerProfiledata(addcustomerprofileobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addCustomerprofileData.saveOrCancel(addcustomerprofileobj);
		
		sa.assertAll();
	}


	@DataProvider(name = "AddCustomerProfileDataProvider")
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
			AddCustomerProfilePojo customerprofileTestData = new AddCustomerProfilePojo();

			customerprofileTestData.setCustomerProfile_Code(resultArray.get(i).get(0).toString());
			customerprofileTestData.setCustomerProfile_Name(resultArray.get(i).get(1).toString());
			customerprofileTestData.setCSPName_List(resultArray.get(i).get(2).toString());
			customerprofileTestData.setDescription(resultArray.get(i).get(3).toString());
			customerprofileTestData.setCustomerCategory_List(resultArray.get(i).get(4).toString());
			customerprofileTestData.setCustomerProfiletype_List(resultArray.get(i).get(5).toString());
			customerprofileTestData.setMobileNumber(resultArray.get(i).get(6).toString());
			
			result[i][0] = customerprofileTestData;

		}

		return result;
	}


	
}
