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
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddCSPTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddCSPPage addcsp = new AddCSPPage(driver);
		addcsp.moveToPage("Lookup Definitions", "Add CSP", driver);
		
	}
	

	@Test(description="Validate Add CSP Functionality",priority=1, dataProvider="AddACSPDataProvider")
	public static void AddCSPDetails(AddCSPPojo addCSPobj)  
	{
		test = extent.createTest("Validate Add CSP Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddCSPPage addCSP = new AddCSPPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_Customer_Service_Provider_URL);
		
		try {
			addCSP.addCSPdata(addCSPobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//save method
		addCSP.saveOrCancelOrCancel(addCSPobj);
		
		sa.assertAll();

	}


	@DataProvider(name = "AddACSPDataProvider")
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
			AddCSPPojo CSPTestData = new AddCSPPojo();

			CSPTestData.setCode_txt(resultArray.get(i).get(0).toString());
			CSPTestData.setName_txt(resultArray.get(i).get(1).toString());
			CSPTestData.setDescription_txt(resultArray.get(i).get(2).toString());
			CSPTestData.setEmail_Increase_txt(resultArray.get(i).get(3).toString());
			CSPTestData.setEmail_decrease_txt(resultArray.get(i).get(4).toString());
			CSPTestData.setSMS_Increase_txt(resultArray.get(i).get(5).toString());
			CSPTestData.setSMS_decrease_txt(resultArray.get(i).get(6).toString());
			
			result[i][0] = CSPTestData;

		}

		return result;
	}


	
}
