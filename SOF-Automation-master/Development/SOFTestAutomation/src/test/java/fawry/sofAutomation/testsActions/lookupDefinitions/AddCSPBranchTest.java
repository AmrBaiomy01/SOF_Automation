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
import fawry.sofAutomation.pages.lookupDefinitions.AddCSPBranchPage;
import fawry.sofAutomation.pages.lookupDefinitions.AddCSPPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPBranchPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddCSPBranchTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddCSPBranchPage addacquirer = new AddCSPBranchPage(driver);	
		addacquirer.moveToPage("Lookup Definitions", "Add CSP Branch", driver);
		
	}
	

	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="AddACSPBranchDataProvider")
	public static void AddCSPbranchDetails(AddCSPBranchPojo addCSPbranchobj)
	{
		test = extent.createTest("Validate Add CSPBranch Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddCSPBranchPage addCSPBranch = new AddCSPBranchPage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_CSP_Branch_URL);
		
		try {
			addCSPBranch.addCSPbranchdata(addCSPbranchobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Choosing to add account by location id with either an existing region or by adding new region
		
		addCSPBranch.saveOrReset(addCSPbranchobj);
		
		sa.assertAll();

	}


	@DataProvider(name = "AddACSPBranchDataProvider")
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
			AddCSPBranchPojo CSPBranchTestData = new AddCSPBranchPojo();

			CSPBranchTestData.setCode_txt(resultArray.get(i).get(0).toString());
			CSPBranchTestData.setAlias_txt(resultArray.get(i).get(1).toString());
			CSPBranchTestData.setBranchname_txt(resultArray.get(i).get(2).toString());
			CSPBranchTestData.setBranchaddress_txt(resultArray.get(i).get(3).toString());
			CSPBranchTestData.setCSPname_list(resultArray.get(i).get(4).toString());
			
			
			result[i][0] = CSPBranchTestData;

		}

		return result;
	}


	
}
