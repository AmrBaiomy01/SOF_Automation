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
import fawry.sofAutomation.pojos.lookupDefinitions.AddBillerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.testsActions.BasicDefinitions.AddCSPBTCPoolAccountTest;

public class AddBillerPage extends MainPage {

	WebDriver driver;
	public AddBillerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addBiller:billerCode")
	WebElement Code_txt;

	@FindBy(id="addBiller:billerName")
	WebElement Name_txt;

	@FindBy(id="addBiller:textareaDescription1")
	WebElement Description_txt;

	
	
	@FindBy(id="addBiller:saveBtn")
	WebElement saveButton;
	
	@FindBy(id="addBiller:resetBtn")
	WebElement resetButton;
	
	@FindBy(id="addBiller:cancelBtn")
	WebElement cancelButton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addBillerdata(AddBillerPojo addbillerobj) throws Exception


	{		
		
		resetButton.click();

		//BankCode
		if (addbillerobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
			Code_txt.sendKeys(timestamp);
		}

		else {
			
			Code_txt.clear();
			Code_txt.sendKeys(addbillerobj.getCode_txt());	
		}
		
		//bank name
		
		if(addbillerobj.getName_txt().equalsIgnoreCase("new")) {
			
			Name_txt.clear();
		}
		
		else {
			Name_txt.sendKeys(addbillerobj.getName_txt());
		}
				
		//description
		Description_txt.sendKeys(addbillerobj.getDescription_txt());
		
		saveButton.click();
	
		}


	/*public void saveOrCancelOrCancel(AddBillerPojo savebillerobj) {

		if (savebillerobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
		}
		else if (savebillerobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}*/

}
