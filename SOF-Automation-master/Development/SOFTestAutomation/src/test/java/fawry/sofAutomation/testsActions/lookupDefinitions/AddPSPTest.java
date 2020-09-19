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
import fawry.sofAutomation.pojos.lookupDefinitions.AddPSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddPSPTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddPSPPage addpsp = new AddPSPPage(driver);	
		addpsp.moveToPage("Lookup Definitions", "Add PSP", driver);
		
	}
	

	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="AddPSPDataProvider")
	public static void AddPSPDetails(AddPSPPojo addPSPobj)  
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddPSPPage addpsp = new AddPSPPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_PSP_URL);
		
		try {
			addpsp.addPSPdata(addPSPobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//save method
		addpsp.saveOrCancelOrCancel(addPSPobj);
		
		sa.assertAll();

	}


	@DataProvider(name = "AddPSPDataProvider")
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
			AddPSPPojo PSPTestData = new AddPSPPojo();

			PSPTestData.setPSP_status(resultArray.get(i).get(0).toString());
			PSPTestData.setCode_txt(resultArray.get(i).get(1).toString());
			PSPTestData.setName_txt(resultArray.get(i).get(2).toString());
			PSPTestData.setDescription_txt(resultArray.get(i).get(3).toString());
			
			result[i][0] = PSPTestData;

		}

		return result;
	}


	
}
