package fawry.sofAutomation.pages.lookupDefinitions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Add;
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
import fawry.sofAutomation.pojos.lookupDefinitions.AddCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.SearchCustomerProfilePojo;

public class SearchCustomerProfilePage extends MainPage {

	WebDriver driver;
	public SearchCustomerProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="editMerchant:textSearchMerchantCode")
	WebElement Customerprofilecode_txt;

	@FindBy(id="editMerchant:textSearchMobileNum")
	WebElement CustomerMobileNumber_txt;

	@FindBy(id="editMerchant:textSearchName")
	WebElement CustomerName_txt;
	
	@FindBy(id="editMerchant:cspSearch")
	WebElement CSPName_List;
	
	
	@FindBy(id="editMerchant:button1")
	WebElement searchButton;
	
	@FindBy(id="editMerchant:resetBtn")
	WebElement resetButton;
	
	
	String timestamp = new SimpleDateFormat("hhssm").format(Calendar.getInstance().getTime());


	//
	public void searchACustomerProfiledata(SearchCustomerProfilePojo searchCustomerprofileobj) throws Exception

	{		
		
		resetButton.click();

		//Customerprofile code
		
		if(searchCustomerprofileobj.getCustomerprofilecode_txt().equalsIgnoreCase("new")) {
			
			Customerprofilecode_txt.clear();
	
		}
		
		else {
			Customerprofilecode_txt.clear();
			Customerprofilecode_txt.sendKeys(searchCustomerprofileobj.getCustomerprofilecode_txt());
		}
		
		if(searchCustomerprofileobj.getCustomerMobileNumber_txt().equalsIgnoreCase("new")) 
			{
			CustomerMobileNumber_txt.clear();	
			}
			
		else {	
				
		     CustomerMobileNumber_txt.sendKeys(searchCustomerprofileobj.getCustomerMobileNumber_txt());
		}
	
		if(searchCustomerprofileobj.getCustomerName_txt().equalsIgnoreCase("new")) 
		{
		CustomerName_txt.clear();	
		}
		
		else {	
			
	     CustomerName_txt.sendKeys(searchCustomerprofileobj.getCustomerMobileNumber_txt());
		}
		
		
		
		if(!searchCustomerprofileobj.getCSPName_List().isEmpty()) {
			
			Select csplist = new Select(CSPName_List);
			csplist.selectByVisibleText(searchCustomerprofileobj.getCSPName_List());
		}
		
		searchButton.click();
		return ;
		
		}

		
		
	}
