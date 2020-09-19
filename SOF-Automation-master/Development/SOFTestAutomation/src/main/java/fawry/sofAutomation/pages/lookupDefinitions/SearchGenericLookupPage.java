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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import fawry.sofAutomation.pages.main.MainPage;
import fawry.sofAutomation.pojos.lookupDefinitions.AddGenericLookupPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddPSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchGenericLookupPojo;

public class SearchGenericLookupPage extends MainPage {

	WebDriver driver;
	public SearchGenericLookupPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="searchBiller:lookupTypeList")
	WebElement lookupType_List;
	
	
	@FindBy(id="searchBiller:code")
	WebElement Code_txt;
	
	
	@FindBy(id="searchBiller:searchBtn")
	WebElement searchButton;
	
	@FindBy(id="searchBiller:resetBtn")
	WebElement resetButton;
	
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void srchGenericLookupdata(SearchGenericLookupPojo searchGenericLookupobj) throws Exception


	{		
		resetButton.click();
		
		/*you must fill all mandatory fields to search lookup*/
		
		if(!searchGenericLookupobj.getLookupType_List().isEmpty()) {
			
		Select lookupTypelist = new Select(lookupType_List);
		lookupTypelist.selectByVisibleText(searchGenericLookupobj.getLookupType_List());
		}
		
		//BankCode
		if (searchGenericLookupobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
		}

		else {
			Code_txt.clear();
			Code_txt.sendKeys(searchGenericLookupobj.getCode_txt());
		}
		
		searchButton.click();
		
		
	}
	

}
