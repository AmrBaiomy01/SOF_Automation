package fawry.sofAutomation.testsActions.accounts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fawry.sofAutomation.pages.accounts.SearchControlAccountPage;
import fawry.sofAutomation.pages.login.LoginPage;
import fawry.sofAutomation.testsActions.basic.BasicTest;

public class SearchControlAccountTest extends BasicTest{

	SearchControlAccountPage SearchAccountobj;
	
	@BeforeClass
	public void login() {
		
		LoginPage login = new LoginPage(driver);
		login.successfulllogin();
		SearchAccountobj = new SearchControlAccountPage(driver);
	}  
	
	@Test
	public void ValidAccount() {
		SearchAccountobj = new SearchControlAccountPage(driver);
		SearchAccountobj.SearchwithvalidAccount();
		
	}
	
	/*@Test
	public void InvalidAccount() {
	}*/
	
}
