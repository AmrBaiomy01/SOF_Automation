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
import fawry.sofAutomation.pojos.lookupDefinitions.AddAccountTypeProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddAccountTypeProfileTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddAccountTypeProfilePage addacctypeprofile = new AddAccountTypeProfilePage(driver);	
		addacctypeprofile.moveToPage("Lookup Definitions", "Add Account Type Profile", driver);
		
	}
	

	@Test(description="Validate Add Account Type Profile Functionality",priority=1, dataProvider="AddAccountTypeProfileDataProvider")
	public static void AddAccountTypeProfileDetails(AddAccountTypeProfilePojo AddAccountTypeProfileobj)  
	{
		test = extent.createTest("Validate Add Account Type Profile Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddAccountTypeProfilePage addacctypeprofile = new AddAccountTypeProfilePage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_Account_Type_Profile);
		
		try {
			addacctypeprofile.addAccTypeProfile(AddAccountTypeProfileobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sa.assertAll();

	}


	@DataProvider(name = "AddAccountTypeProfileDataProvider")
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
			AddAccountTypeProfilePojo addAccountTypeTestData = new AddAccountTypeProfilePojo();

			addAccountTypeTestData.setAccountType_List(resultArray.get(i).get(0).toString());
			addAccountTypeTestData.setCSP_List(resultArray.get(i).get(1).toString());
			addAccountTypeTestData.setAcquirerBank_List(resultArray.get(i).get(2).toString());
			addAccountTypeTestData.setMerchantCode_txt(resultArray.get(i).get(3).toString());
			addAccountTypeTestData.setExternalAuthorizerSystemCode_txt(resultArray.get(i).get(4).toString());
			addAccountTypeTestData.setPaymentType_List(resultArray.get(i).get(5).toString());
			addAccountTypeTestData.setBiller_List(resultArray.get(i).get(6).toString());
						
			String[] splittedString =(resultArray.get(i).get(6).toString().split(","));
            ArrayList<String> str=new ArrayList<>();
            
            for(int j=0; j<splittedString.length;j++)
           {
            	
                str.add(splittedString[j]);
            }
            addAccountTypeTestData.setAll_Bill_Types(str);
			
			result[i][0] = addAccountTypeTestData;

		}

		return result;
	}


	
}
