package fawry.sofAutomation.testsActions.lookupDefinitions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import fawry.sofAutomation.constants.lookupDefinitions.Constants;
import fawry.sofAutomation.pages.basicDefinitions.AddFinanceProgramPage;
import fawry.sofAutomation.pages.login.LoginPage;
import fawry.sofAutomation.pages.lookupDefinitions.AddAccountTypeProfilePage;
import fawry.sofAutomation.pages.lookupDefinitions.AddCustomerProfilePage;
import fawry.sofAutomation.pages.lookupDefinitions.AddFinanceProgramTypePage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddFinanceProgramTypePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddFinanceProgramTypeTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddFinanceProgramTypePage addfinanceprogram = new AddFinanceProgramTypePage(driver);	
		addfinanceprogram.moveToPage("Lookup Definitions", "Add Financial Program Type", driver);
		
	}
	

	@Test(description="Validate Add Finance Program Type Functionality",priority=1, dataProvider="AddfinanceprogramDataProvider")
	public static void AddfinanceprogramDetails(AddFinanceProgramTypePojo addfinanceprogobj)
	{
		test = extent.createTest("Validate Add finance program Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddFinanceProgramTypePage addFinanceProgramobj = new AddFinanceProgramTypePage(driver);

		driver.navigate().to(fawry.sofAutomation.constants.lookupDefinitions.Constants.Add_Finance_Program_Type);
		
		//Choosing to add account by location id with either an existing region or by adding new region
		
		try {
			addFinanceProgramobj.addFinanceprogram(addfinanceprogobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		sa.assertAll();
	}


	@DataProvider(name = "AddfinanceprogramDataProvider")
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
			AddFinanceProgramTypePojo addFinanceprogTestData = new AddFinanceProgramTypePojo();

			addFinanceprogTestData.setFinanceProgram_Code(resultArray.get(i).get(0).toString());
			addFinanceprogTestData.setFinanceProgram_Name(resultArray.get(i).get(1).toString());
			addFinanceprogTestData.setFinanceProgram_Description(resultArray.get(i).get(2).toString());
			addFinanceprogTestData.setNature_List(resultArray.get(i).get(3).toString());
			addFinanceprogTestData.setSubAccountLength_txt(resultArray.get(i).get(4).toString());
			
			result[i][0] = addFinanceprogTestData;

		}

		return result;
	}


	
}
