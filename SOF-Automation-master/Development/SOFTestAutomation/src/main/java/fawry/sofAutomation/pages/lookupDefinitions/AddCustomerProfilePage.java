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

public class AddCustomerProfilePage extends MainPage {

	WebDriver driver;
	public AddCustomerProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addMerchant:textMerchantID1")
	WebElement CustomerProfile_Code;

	@FindBy(id="addMerchant:textPosid1")
	WebElement CustomerProfile_Name;

	@FindBy(id="addMerchant:corporate")
	WebElement CSPName_List;

	@FindBy(id="addMerchant:textareaDescription1")
	WebElement Description;
	
	
	@FindBy(id="addMerchant:customerCategoryList")
	WebElement CustomerCategory_List;
	
	
	@FindBy(id="addMerchant:customerTypeList")
	WebElement CustomerProfiletype_List;

	@FindBy(id="addMerchant:textCustContactVal")
	WebElement MobileNumber;
	
	@FindBy(id="addMerchant:button1")
	WebElement saveButton;
	
	@FindBy(id="addMerchant:ResetBtn")
	WebElement resetButton;
	
	
	String timestamp = new SimpleDateFormat("hhssm").format(Calendar.getInstance().getTime());


	//
	public void addACustomerProfiledata(AddCustomerProfilePojo addCustomerprofileobj) throws Exception


	{		
		
		//Customerprofile code
		
		if(addCustomerprofileobj.getCustomerProfile_Code().equalsIgnoreCase("fivedigits")) {
			
			CustomerProfile_Code.clear();
			CustomerProfile_Code.sendKeys(timestamp);
		}
		else {
			CustomerProfile_Code.clear();
			CustomerProfile_Code.sendKeys(addCustomerprofileobj.getCustomerProfile_Code());	
		}
		
		//Customerprofile name
		CustomerProfile_Name.sendKeys(addCustomerprofileobj.getCustomerProfile_Name());
		
		//CSPList
		
		if(!addCustomerprofileobj.getCSPName_List().isEmpty()) {
			
			Select csplist = new Select(CSPName_List);
			csplist.selectByVisibleText(addCustomerprofileobj.getCSPName_List());	
		}
				
		//description
		Description.sendKeys(addCustomerprofileobj.getDescription());

		if(!addCustomerprofileobj.getCustomerCategory_List().isEmpty()) {
			
			Select csplist = new Select(CustomerCategory_List);
			csplist.selectByVisibleText(addCustomerprofileobj.getCustomerCategory_List());	
		}
		
		if(!addCustomerprofileobj.getCustomerProfiletype_List().isEmpty()) {
			
			Select csplist = new Select(CustomerProfiletype_List);
			csplist.selectByVisibleText(addCustomerprofileobj.getCustomerProfiletype_List());	
		}
		
		if(addCustomerprofileobj.getMobileNumber().isEmpty())
		{
			MobileNumber.clear();
		}
		else {
			MobileNumber.sendKeys(addCustomerprofileobj.getMobileNumber());
		}
		
		}

		//Data for Manage Merchant Extra Param

	public void saveOrCancel(AddCustomerProfilePojo savecustomerprofileobj) {

		if (savecustomerprofileobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
		}
		else if (savecustomerprofileobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			/*Alert alert = driver.switchTo().alert();
            alert.accept();*/
		}
	}

}
