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
import fawry.sofAutomation.pojos.lookupDefinitions.SearchPSPPojo;

public class SearchPSPPage extends MainPage {

	WebDriver driver;
	public SearchPSPPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="searchPSP:menu1")
	WebElement status_list;
	
	
	@FindBy(id="searchPSP:PSPCode")
	WebElement Code_txt;

	
	
	
	@FindBy(id="searchPSP:searchBtn")
	WebElement searchButton;
	
	@FindBy(id="searchPSP:resetBtn")
	WebElement resetButton;
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void searchPSPdata(SearchPSPPojo searchpspobj) throws Exception


	{		
		
		resetButton.click();
		
		//BankCode
				if (searchpspobj.getCode_txt().equalsIgnoreCase("new")) {
					
					Code_txt.clear();
					
				}

				else {
					Code_txt.clear();
					Code_txt.sendKeys(searchpspobj.getCode_txt());
				}
		
		
		if(searchpspobj.getStatus_list() != "") {
			
		Select statuslist = new Select(status_list);
		statuslist.selectByVisibleText(searchpspobj.getStatus_list());
		}
		
		searchButton.click();
		
	}
	

	
	/*public void saveOrCancelOrCancel(SearchPSPPojo savepspobj) {

		if (savepspobj.getAction().equalsIgnoreCase("Save")) 
		{
			
			searchButton.click();
		
		}
		else if (savepspobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}*/

}
