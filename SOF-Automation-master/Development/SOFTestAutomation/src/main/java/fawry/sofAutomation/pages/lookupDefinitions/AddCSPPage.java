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
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.testsActions.BasicDefinitions.AddCSPBTCPoolAccountTest;

public class AddCSPPage extends MainPage {

	WebDriver driver;
	public AddCSPPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addCSP:cspCode")
	WebElement Code_txt;

	@FindBy(id="addCSP:cspName")
	WebElement Name_txt;

	@FindBy(id="addCSP:textareaDescription1")
	WebElement Description_txt;

	@FindBy(id="addCSP:emailNotificationIncreaseTemplate")
	WebElement Email_Increase_txt;

	@FindBy(id="addCSP:emailNotificationDecreaseTemplate")
	WebElement Email_decrease_txt;
	
	@FindBy(id="addCSP:smsNotificationIncreaseTemplate")
	WebElement SMS_Increase_txt;
	
	@FindBy(id="addCSP:smsNotificationDecreaseTemplate")
	WebElement SMS_decrease_txt;
	
	@FindBy(id="addCSP:glAccountCode")
	WebElement Csp_GL_Account_txt;

	@FindBy(id="addCSP:subscribeInbox")
	WebElement Subscribe_CSP_checkbox;
	
	@FindBy(id="addCSP:applyVelocityCheck")
	WebElement ApplyVelocity_checkbox;
	
	
	
	@FindBy(id="addCSP:saveBtn")
	WebElement saveButton;
	
	@FindBy(id="addCSP:resetBtn")
	WebElement resetButton;
	
	@FindBy(id="addCSP:cancelBtn")
	WebElement cancelButton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addCSPdata(AddCSPPojo addcspobj) throws Exception


	{		
		/*you can create CSP with code and name only*/
		
		//BankCode
		if (addcspobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
			Code_txt.sendKeys(timestamp);
		}

		else {
			Code_txt.clear();
			Code_txt.sendKeys(addcspobj.getCode_txt());	
		}
		
		//bank name
				Name_txt.sendKeys(addcspobj.getName_txt());
				
			
		//description
		Description_txt.sendKeys(addcspobj.getDescription_txt());
		
		//Emails
		Email_Increase_txt.sendKeys(addcspobj.getEmail_Increase_txt());
		Email_decrease_txt.sendKeys(addcspobj.getEmail_decrease_txt());
		
		//SMSs
		SMS_Increase_txt.sendKeys(addcspobj.getSMS_Increase_txt());
		SMS_decrease_txt.sendKeys(addcspobj.getSMS_decrease_txt());
		
		Csp_GL_Account_txt.sendKeys(addcspobj.getCsp_GL_Account_txt());
		
		//checkbox
		
		/*Subscribe_CSP_checkbox.click();
		ApplyVelocity_checkbox.click();*/

		}


	public void saveOrCancelOrCancel(AddCSPPojo savecspobj) {

		if (savecspobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
		}
		else if (savecspobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}

}
