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
import fawry.sofAutomation.pages.lookupDefinitions.AddGenericLookupPage;
import fawry.sofAutomation.pages.lookupDefinitions.AddPSPPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddGenericLookupPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddPSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddGenericLookupTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddGenericLookupPage addGenericlookup = new AddGenericLookupPage(driver);	
		addGenericlookup.moveToPage("Lookup Definitions", "Add Generic Lookup", driver);
		
	}
	

	@Test(description="Validate Add Generic Lookup Functionality",priority=1, dataProvider="AddGenLookupDataProvider")
	public static void AddGenLookupDetails(AddGenericLookupPojo addGenericLookupobj)  
	{
		test = extent.createTest("Validate Add Generic Lookup Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddGenericLookupPage addGenLookupobj = new AddGenericLookupPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_Generic_lookup_Type);
		
		try {
			addGenLookupobj.addGenericLookupdata(addGenericLookupobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sa.assertAll();

	}


	@DataProvider(name = "AddGenLookupDataProvider")
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
			AddGenericLookupPojo addGenlookTestData = new AddGenericLookupPojo();

			addGenlookTestData.setLookupType_List(resultArray.get(i).get(0).toString());
			addGenlookTestData.setCode_txt(resultArray.get(i).get(1).toString());
			addGenlookTestData.setName_txt(resultArray.get(i).get(2).toString());
			addGenlookTestData.setDescription_txt(resultArray.get(i).get(3).toString());
			
			result[i][0] = addGenlookTestData;

		}

		return result;
	}


	
}
