package fawry.sofAutomation.pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fawry.sofAutomation.constants.accounts.Constants;
import fawry.sofAutomation.pojos.accounts.AccountPojo;

public class SearchControlAccountPage {

	WebDriver driver;
	
	public SearchControlAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="searchPOS:textSearchBankNo")
	WebElement Bank_Account_Number;
	
	@FindBy(id="searchPOS:textSearchFromDate1")
	WebElement From_Date;
	
	@FindBy(id="searchPOS:textSearchToDate1")
	WebElement To_Date;
	
	
	
	public String SearchControlAcc(AccountPojo searchaccobj ){
		
		driver.navigate().to(Constants.SEARCH_CONTROL_ACCOUNT_URL);
		
		return null;
				
	}
	
	public void SearchwithvalidAccount() {
		
		Bank_Account_Number.sendKeys("1234543831");
		From_Date.sendKeys("Wed, 01 Jul 2020");
		To_Date.sendKeys("Tue, 14 Jul 2020");
		
	}
	
	public void SearchwithinvalidAccount() {
		
		
	}
	
}
