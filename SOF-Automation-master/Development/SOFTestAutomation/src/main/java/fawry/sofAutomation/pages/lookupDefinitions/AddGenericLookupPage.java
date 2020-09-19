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

public class AddGenericLookupPage extends MainPage {

	WebDriver driver;
	public AddGenericLookupPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addLookup:lookupTypeList")
	WebElement lookupType_List;
	
	
	@FindBy(id="addLookup:Code")
	WebElement Code_txt;

	@FindBy(id="addLookup:Name")
	WebElement Name_txt;

	@FindBy(id="addLookup:textareaDescription1")
	WebElement Description_txt;

	@FindBy(id="addLookup:Default")
	WebElement isDefault_check;
	
	
	
	@FindBy(id="addLookup:saveBtn")
	WebElement saveButton;
	
	@FindBy(id="addLookup:cancelBtn")
	WebElement cancelButton;
	
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addGenericLookupdata(AddGenericLookupPojo addGenericLookupobj) throws Exception


	{		
		/*you must fill all mandatory fields to create lookup*/
		
		if(!addGenericLookupobj.getLookupType_List().isEmpty()) {
			
		Select lookupTypelist = new Select(lookupType_List);
		lookupTypelist.selectByVisibleText(addGenericLookupobj.getLookupType_List());
		}
		
		//BankCode
		if (addGenericLookupobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
			Code_txt.sendKeys(timestamp);
		}

		else {
			Code_txt.clear();
			Code_txt.sendKeys(addGenericLookupobj.getCode_txt());
		}
		
		//bank name
			Name_txt.sendKeys(addGenericLookupobj.getName_txt());
				
			
		//description
		Description_txt.sendKeys(addGenericLookupobj.getDescription_txt());
		
		saveButton.click();
		
		
	}
	

}
