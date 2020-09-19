package fawry.sofAutomation.testsActions.accounts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import fawry.sofAutomation.constants.accounts.AssertionErrorMessages;
import fawry.sofAutomation.constants.accounts.Constants;
import fawry.sofAutomation.pages.accounts.StatictestPage;
import fawry.sofAutomation.pages.login.LoginPage;
import fawry.sofAutomation.pojos.accounts.Tetspagepojo;
import fawry.sofAutomation.testsActions.basic.BasicTest;
import fawry.sofAutomation.utils.PropertiesFilesHandler;



public class TestpageTest extends BasicTest{


	@BeforeClass
	public void login() 
	{
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		

	}
	

	@Test(description="Validate Move Account Functionality",priority=1, dataProvider="StaticpagesTestData")
	public static void moveAccount(Tetspagepojo stpgsobj) throws Exception  
	{
		test = extent.createTest("Validate Move Account Functionality");

		SoftAssert saa = new SoftAssert();
		StatictestPage staticpages = new StatictestPage(driver);
		staticpages.userActions(stpgsobj);
		
	}

	
	@DataProvider(name = "StaticpagesTestData")
	public Object[][] provideTestData(Method method)
	{

		String methodFullName = method.getName();

		PropertiesFilesHandler propLoader = new PropertiesFilesHandler();
		Properties prop = propLoader.loadPropertiesFile(Constants.TEST_DATA_CONFIG_FILE_NAME);

		String connectionProperties = prop.getProperty(methodFullName);

		ArrayList<ArrayList<Object>> resultArray = provideTestData(connectionProperties);
		Object[][] result = new Object[resultArray.size()][1];

		System.out.println(resultArray.size());
		
		for(int i=0; i<resultArray.size(); i++)
		{
			Tetspagepojo AddtestData = new Tetspagepojo();

			AddtestData.setArcontent(resultArray.get(i).get(5).toString());
			AddtestData.setEncontent(resultArray.get(i).get(4).toString());
			AddtestData.setPagetype(resultArray.get(i).get(3).toString());
			AddtestData.setPageNameAr(resultArray.get(i).get(2).toString());
			AddtestData.setPageNameEn(resultArray.get(i).get(1).toString());
			AddtestData.setAction(resultArray.get(i).get(0).toString());
			result[i][0] = AddtestData;
		}


		return result;
	}

}
