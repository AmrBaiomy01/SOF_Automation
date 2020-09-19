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
import fawry.sofAutomation.pages.acquirerMerchants.AddAcquirerMerchantPage;
import fawry.sofAutomation.pages.login.LoginPage;
import fawry.sofAutomation.pojos.acquirerMerchants.AcquirerPojo;
import fawry.sofAutomation.pojos.acquirerMerchants.SearchPojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;


public class AddAcquirereMerchantTest extends BasicTest{

	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		AddAcquirerMerchantPage addacquirer = new AddAcquirerMerchantPage(driver);	
		addacquirer.moveToPage("Acquirer Merchants", "Add Acquirer Merchant", driver);
		
	}

	

	@Test(description="Validate Add Acquirer Functionality",priority=1, dataProvider="AddAcquirerDataProvider")
	public static void AddAcquirerDetails(AcquirerPojo addacquirerobj)  
	{
		test = extent.createTest("Validate Add Account Functionality");
		
		SoftAssert sa = new SoftAssert();
		AddAcquirerMerchantPage addacquirer = new AddAcquirerMerchantPage(driver);
		
		AddacquirerVefication addacquveri = new AddacquirerVefication();
		SearchPojo srchacquirer =new SearchPojo();

		driver.navigate().to(fawry.sofAutomation.constants.acquirereMerchants.Constants.ADD_ACQUIRER_MERCHANT_URL);
		
		//Choosing to add account by location id with either an existing region or by adding new region
		try {
			addacquirer.addacquirerdata(addacquirerobj);
			addacquveri.addAcquirerveri(srchacquirer, "");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addacquirer.saveOrCancel(addacquirerobj);
		
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
			AcquirerPojo acquirerTestData = new AcquirerPojo();

			acquirerTestData.setArabic_Name(resultArray.get(i).get(0).toString());
			acquirerTestData.setEnglish_Name(resultArray.get(i).get(1).toString());
			acquirerTestData.setMerchant_ID(resultArray.get(i).get(2).toString());
			acquirerTestData.setAcquirer_Bank(resultArray.get(i).get(3).toString());
			acquirerTestData.setPayment_Type(resultArray.get(i).get(4).toString());
			acquirerTestData.setBiller(resultArray.get(i).get(5).toString());
			//acquirerTestData.setAll_Bill_Types(resultArray.get(i).get(6).toString());
			
			String[] splittedString =(resultArray.get(i).get(6).toString().split(","));
            ArrayList<String> str=new ArrayList<>();
            
            for(int j=0; j<splittedString.length;j++)
           {
            	
                str.add(splittedString[j]);
            }
            acquirerTestData.setAll_Bill_Types(str);
            
			acquirerTestData.setAccount_code(resultArray.get(i).get(7).toString());
			acquirerTestData.setCSP(resultArray.get(i).get(8).toString());
			acquirerTestData.setBank_Terminal_ID(resultArray.get(i).get(9).toString());
			acquirerTestData.setMerchant_Param(resultArray.get(i).get(10).toString());
			acquirerTestData.setValue(resultArray.get(i).get(11).toString());
			acquirerTestData.setExpectedMessage(resultArray.get(i).get(12).toString());
			acquirerTestData.setTestCaseId(resultArray.get(i).get(13).toString());
			acquirerTestData.setAction(resultArray.get(i).get(14).toString());

			result[i][0] = acquirerTestData;

		}


		return result;
	}


	
}
