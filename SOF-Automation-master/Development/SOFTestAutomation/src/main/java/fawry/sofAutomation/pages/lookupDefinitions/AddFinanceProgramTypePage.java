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
import fawry.sofAutomation.pojos.basicDefinitions.FinanceProgramPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCustomerProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddFinanceProgramTypePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;

public class AddFinanceProgramTypePage extends MainPage {

	WebDriver driver;
	public AddFinanceProgramTypePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addFinanaceProgramType:fptCode")
	WebElement financeProgram_Code;

	@FindBy(id="addFinanaceProgramType:fptName")
	WebElement financeProgram_Name;

	@FindBy(id="addFinanaceProgramType:textareaDescription1")
	WebElement financeProgram_Description;

	@FindBy(id="addMerchant:textareaDescription1")
	WebElement Description;
	
	
	@FindBy(id="addFinanaceProgramType:menuNature1")
	WebElement nature_List;
	
	
	@FindBy(id="addFinanaceProgramType:textsubAcctNumberLen")
	WebElement subAccountLength_txt;

	@FindBy(id="addFinanaceProgramType:subAcctSupported")
	WebElement subAccountSupported_check;
	
	@FindBy(id="addFinanaceProgramType:billingAcctRequired")
	WebElement billingAccountRequired_check;
	
	@FindBy(id="addFinanaceProgramType:acceptsZeroLimit")
	WebElement acceptZeroPMT_check;
	
	
	@FindBy(id="addFinanaceProgramType:displayInBalanceInq")
	WebElement displayInBalanceInq_check;
	
	@FindBy(id="addFinanaceProgramType:btcRequired")
	WebElement btcRequired_check;
	
	@FindBy(id="addFinanaceProgramType:poolAccMandatory")
	WebElement poolAccMandatory_check;
	
	@FindBy(id="addFinanaceProgramType:periodical")
	WebElement periodical_check;
	
	
	
	@FindBy(id="addFinanaceProgramType:saveBtn")
	WebElement saveButton;
	
	@FindBy(id="addFinanaceProgramType:resetBtn")
	WebElement resetButton;
	
	
	String timestamp = new SimpleDateFormat("hhssm").format(Calendar.getInstance().getTime());


	//
	public void addFinanceprogram(AddFinanceProgramTypePojo addFinanceProgramobj) throws Exception


	{		
		resetButton.click();

		//financeprogram code accept only 5 digits
		
		if(addFinanceProgramobj.getFinanceProgram_Code().equalsIgnoreCase("empty")) {
			
			financeProgram_Code.clear();
		}
		
		else {
			financeProgram_Code.clear();
			financeProgram_Code.sendKeys(addFinanceProgramobj.getFinanceProgram_Code());
		}
		
		//finance_program name
		
		financeProgram_Name.sendKeys(addFinanceProgramobj.getFinanceProgram_Name());
		
		//Description
		
		if(addFinanceProgramobj.getFinanceProgram_Description().equalsIgnoreCase("checkbillingaccount")) {
			
			billingAccountRequired_check.click();
		}
		
		else if(addFinanceProgramobj.getFinanceProgram_Description().equalsIgnoreCase("check sub-account supported")){
			
			subAccountLength_txt.click();
		}
		
		else {
			
			financeProgram_Description.sendKeys(addFinanceProgramobj.getFinanceProgram_Description());
		}
		
		//NatureList
		
		if(!addFinanceProgramobj.getNature_List().isEmpty()) {
			
			Select naturelist = new Select(nature_List);
			naturelist.selectByVisibleText(addFinanceProgramobj.getNature_List());
		}
				
		saveButton.click();
		
	}

		//Data for Manage Merchant Extra Param

	public void saveOrCancel(FinanceProgramPojo financeProgramobj) {
	 if (financeProgramobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
		}
		else if (financeProgramobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
		}
	}

	}
	

