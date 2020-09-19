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
import fawry.sofAutomation.pojos.lookupDefinitions.SearchCSPPojo;
import fawry.sofAutomation.testsActions.BasicDefinitions.AddCSPBTCPoolAccountTest;

public class SearchCSPPage extends MainPage {

	WebDriver driver;
	public SearchCSPPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="searchCSP:CSPCode")
	WebElement Code_txt;
	
	
		
	
	@FindBy(id="searchCSP:searchBtn")
	WebElement searchButton;
	
	@FindBy(id="searchCSP:resetBtn")
	WebElement resetButton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public String SearchCSPdata(SearchCSPPojo srchCspObj) throws Exception


	{		
		resetButton.click();
		
		//BankCode
		if (srchCspObj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
		}

		else {
			Code_txt.clear();
			Code_txt.sendKeys(srchCspObj.getCode_txt());
		}
		
		searchButton.click();
		return "success";
		
		}

	
}
