package fawry.sofAutomation.pages.lookupDefinitions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import fawry.sofAutomation.pages.main.MainPage;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchAcquirerPojo;

public class SearchAcquirerBankPage extends MainPage {

	WebDriver driver;
	public SearchAcquirerBankPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addBank:bankCode")
	WebElement bankCode_txt;

	@FindBy(id="AddMerchant:textMerchantID")
	WebElement bin_txt;

	@FindBy(id="AddMerchant:AcquirerList")
	WebElement status_List;
	
	@FindBy(id="manageBanks:resetBtn")
	WebElement resetButton;

	@FindBy(id="manageBanks:searchBtn")
	WebElement searchButton;
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addAcquirerBankdata(SearchAcquirerPojo searchAcquirerobj) throws Exception


	{		
		//BankCode
		if (!searchAcquirerobj.getBank_Code().isEmpty()) {
			
			bankCode_txt.clear();
		}

		else {
			bankCode_txt.clear();
			bankCode_txt.sendKeys(searchAcquirerobj.getBank_Code());
		}
		
		//Bin
		if (!searchAcquirerobj.getBIN().isEmpty()) {
			
			bin_txt.clear();
		}
		
		else {
			
			bin_txt.clear();
			bin_txt.sendKeys(searchAcquirerobj.getBIN());
		}
				
		//select status
		if (!searchAcquirerobj.getStatus().isEmpty()) {

			Select StatusList = new Select(status_List);
			StatusList.selectByVisibleText(searchAcquirerobj.getStatus());
			
		}
		

		}

		//Data for Manage Merchant Extra Param


	public void SearchorReset(SearchAcquirerPojo searchacquirerobj) {

		if (searchacquirerobj.getAction().equalsIgnoreCase("Save")) {

			searchButton.click();
		}
		else if (searchacquirerobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}

}
