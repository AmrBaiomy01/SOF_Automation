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
import fawry.sofAutomation.pojos.lookupDefinitions.SearchBillerPojo;
import fawry.sofAutomation.testsActions.BasicDefinitions.AddCSPBTCPoolAccountTest;

public class SearchBillerPage extends MainPage {

	WebDriver driver;
	public SearchBillerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="searchBiller:code")
	WebElement Code_txt;

		
	
	@FindBy(id="searchBiller:searchBtn")
	WebElement searchButton;
	
	@FindBy(id="searchBiller:resetBtn")
	WebElement resetButton;
		
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void searchBillerdata(SearchBillerPojo searchbillerobj) throws Exception


	{		
		
		resetButton.click();

		//BankCode
		if (searchbillerobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
			Code_txt.sendKeys(timestamp);
		}

		else {
			
			Code_txt.clear();
			Code_txt.sendKeys(searchbillerobj.getCode_txt());	
		}
		
		searchButton.click();
	
		}


}
