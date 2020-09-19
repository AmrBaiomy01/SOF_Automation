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
import fawry.sofAutomation.pojos.lookupDefinitions.SearchFinanceProgramTypePojo;

public class SearchFinanceProgramTypePage extends MainPage {

	WebDriver driver;
	public SearchFinanceProgramTypePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="searchFinanceProgramTypes:financeProgTypeCode")
	WebElement financeProgramcode_txt;


	
	@FindBy(id="searchFinanceProgramTypes:searchBtn")
	WebElement searchButton;
	
	@FindBy(id="searchFinanceProgramTypes:resetBtn")
	WebElement resetButton;
	
	
	String timestamp = new SimpleDateFormat("hhssm").format(Calendar.getInstance().getTime());


	//
	public void searchFinanceCustomerTypedata(SearchFinanceProgramTypePojo SearchFinanceProgramTypeobj) throws Exception

	{		
		
		resetButton.click();

		//financeprogram code
		
		if(SearchFinanceProgramTypeobj.getFinanceProgramcode_txt().equalsIgnoreCase("no_result")) {
			
			financeProgramcode_txt.clear();
			financeProgramcode_txt.sendKeys(timestamp);
	
		}
		
		else {
			financeProgramcode_txt.clear();
			financeProgramcode_txt.sendKeys(SearchFinanceProgramTypeobj.getFinanceProgramcode_txt());
		}
		
		
		searchButton.click();
		return ;
		
		}

		
		
	}
