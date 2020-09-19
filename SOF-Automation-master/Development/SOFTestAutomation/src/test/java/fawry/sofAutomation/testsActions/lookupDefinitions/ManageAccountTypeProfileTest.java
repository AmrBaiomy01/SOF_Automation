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
import fawry.sofAutomation.pages.lookupDefinitions.ManageAccountTypeProfilePage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddAccountTypeProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.ManageAccountTypeProfilePojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class ManageAccountTypeProfileTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		ManageAccountTypeProfilePage manageacctypeprofile = new ManageAccountTypeProfilePage(driver);
		manageacctypeprofile.moveToPage("Lookup Definitions", "Manage Account Type Profile", driver);
		
	}
	

	@Test(description="Validate manage Account Type Profile Functionality",priority=1, dataProvider="manageAccountTypeProfileDataProvider")
	public static void ManageAccountTypeProfileDetails(ManageAccountTypeProfilePojo manageAccountTypeProfileobj)  
	{
		test = extent.createTest("Validate Manage Account Type Profile Functionality");
		
		SoftAssert sa = new SoftAssert();
		ManageAccountTypeProfilePage manageacctypeprofile = new ManageAccountTypeProfilePage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Manage_Account_Type_profile);
		
		try {
			manageacctypeprofile.manageAccTypeProfile(manageAccountTypeProfileobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		sa.assertAll();

	}


	@DataProvider(name = "manageAccountTypeProfileDataProvider")
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
			ManageAccountTypeProfilePojo manageAccountTypeTestData = new ManageAccountTypeProfilePojo();

			manageAccountTypeTestData.setAccountType_List(resultArray.get(i).get(0).toString());
			manageAccountTypeTestData.setCSP_List(resultArray.get(i).get(1).toString());
			manageAccountTypeTestData.setAcquirerBank_List(resultArray.get(i).get(2).toString());
			manageAccountTypeTestData.setMerchantCode_txt(resultArray.get(i).get(3).toString());
			manageAccountTypeTestData.setPaymentType_List(resultArray.get(i).get(4).toString());
			manageAccountTypeTestData.setBiller_List(resultArray.get(i).get(5).toString());
			manageAccountTypeTestData.setExternalAuthorizerSystemCode_txt(resultArray.get(i).get(6).toString());
						
			String[] splittedString =(resultArray.get(i).get(6).toString().split(","));
            ArrayList<String> str=new ArrayList<>();
            
            for(int j=0; j<splittedString.length;j++)
           {
            	
                str.add(splittedString[j]);
            }
            
            manageAccountTypeTestData.setAll_Bill_Types(str);
			
			result[i][0] = manageAccountTypeTestData;
		}

		
		return result;
	}


	
}
