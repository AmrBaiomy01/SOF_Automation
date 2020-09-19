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
import fawry.sofAutomation.pojos.lookupDefinitions.AddBillerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddBillerTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddBillerPage addBiller = new AddBillerPage(driver);
		addBiller.moveToPage("Lookup Definitions", "Add Biller", driver);
		
	}
	

	@Test(description="Validate Add Biller Functionality",priority=1, dataProvider="AddBillerPDataProvider")
	public static void AddBillerDetails(AddBillerPojo addBillerobj)  
	{
		test = extent.createTest("Validate Add CSP Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddBillerPage addBiller = new AddBillerPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_Biller_URL);
		
		try {
			addBiller.addBillerdata(addBillerobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sa.assertAll();

	}


	@DataProvider(name = "AddBillerPDataProvider")
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
			AddBillerPojo AddBillerTestData = new AddBillerPojo();

			AddBillerTestData.setCode_txt(resultArray.get(i).get(0).toString());
			AddBillerTestData.setName_txt(resultArray.get(i).get(1).toString());
			AddBillerTestData.setDescription_txt(resultArray.get(i).get(2).toString());
			
			result[i][0] = AddBillerTestData;

		}

		return result;
	}


	
}
