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
import fawry.sofAutomation.pojos.lookupDefinitions.AddPSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;

public class AddPSPPage extends MainPage {

	WebDriver driver;
	public AddPSPPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addPSP:pspStatus")
	WebElement status_list;
	
	
	@FindBy(id="addPSP:pspCode")
	WebElement Code_txt;

	@FindBy(id="addPSP:pspName")
	WebElement Name_txt;

	@FindBy(id="addPSP:textareaDescription1")
	WebElement Description_txt;

	
	
	
	@FindBy(id="addPSP:saveBtn")
	WebElement saveButton;
	
	@FindBy(id="addPSP:resetBtn")
	WebElement resetButton;
	
	@FindBy(id="addPSP:cancelBtn")
	WebElement cancelButton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addPSPdata(AddPSPPojo addpspobj) throws Exception


	{		
		/*you can create CSP with code and name only*/
		
		if(addpspobj.getPSP_status().isEmpty()) {
			
		Select statuslist = new Select(status_list);
		statuslist.selectByVisibleText(addpspobj.getPSP_status());
		}
		
		//BankCode
		if (addpspobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
			Code_txt.sendKeys(timestamp);
		}

		else {
			Code_txt.clear();
			Code_txt.sendKeys(addpspobj.getCode_txt());
		}
		
		//bank name
			Name_txt.sendKeys(addpspobj.getName_txt());
				
			
		//description
		Description_txt.sendKeys(addpspobj.getDescription_txt());
		
		
	}
	


	public void saveOrCancelOrCancel(AddPSPPojo savepspobj) {

		if (savepspobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
		}
		else if (savepspobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}

}
