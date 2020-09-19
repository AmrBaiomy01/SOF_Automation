package fawry.sofAutomation.pages.acquirerMerchants;

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
import fawry.sofAutomation.pojos.accounts.AccountPojo;
import fawry.sofAutomation.pojos.acquirerMerchants.AcquirerPojo;
import fawry.sofAutomation.pojos.acquirerMerchants.SearchPojo;

public class SearchAcquirerMerchantPage extends MainPage {

	WebDriver driver;
	public SearchAcquirerMerchantPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String newacccode;

	@FindBy(id="searchMerchant:AcquirerList")
	WebElement acquirerBank_List;

	@FindBy(id="searchMerchant:PaymentList")
	WebElement paymentType_List;
	
	@FindBy(id="searchMerchant:billerList")
	WebElement biller_List;
	
	@FindBy(id="searchMerchant:billTypeList")
	WebElement billType_List;

	@FindBy(id="searchMerchant:textmerchantID")
	WebElement merchantID_Txt;
	
	@FindBy(id="searchMerchant:textretailerCode")
	WebElement retailerCode_Txt;
	
	
	@FindBy(id="searchMerchant:searchBtn")
	WebElement SearchButton;
	
	@FindBy(id="searchMerchant:resetBtn")
	WebElement Reset_button;
	
	@FindBy(id="searchMerchant:cancelBtn")
	WebElement Cancel_button;
	
	
	
	@FindBy(xpath="//*[@id=\"searchMerchant:profilesResultsTable:0:merchantID\"]")
	WebElement SearchResult;
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void searchMerchant(SearchPojo searchacquirerrobj) throws Exception


	{		
		
		Reset_button.click();
		
		//Alert alert = driver.switchTo().alert();
        //alert.accept();
        
		//Search Merchant Data

        if (!searchacquirerrobj.getAcquirer_Bank().isEmpty()) {

			Select acquirerbank_List = new Select(acquirerBank_List);
			acquirerbank_List.selectByVisibleText(searchacquirerrobj.getAcquirer_Bank());
		}
        
        
        if (!searchacquirerrobj.getPayment_Type().isEmpty()) {
			
        	Select paymenttypelist = new Select(paymentType_List);
        	paymenttypelist.selectByVisibleText(searchacquirerrobj.getPayment_Type());
		}
        
        
        if (!searchacquirerrobj.getBiller().isEmpty()) {
			
        	Select biller = new Select(biller_List);
        	biller.selectByVisibleText(searchacquirerrobj.getBiller());
		}
        
        if (!searchacquirerrobj.getBill_type().isEmpty()) {
			
        	Select bill_type = new Select(billType_List);
        	bill_type.selectByVisibleText(searchacquirerrobj.getBill_type());
		}
        
        
		if (searchacquirerrobj.getMerchant_ID().equalsIgnoreCase("notexist")) {
			
			merchantID_Txt.clear();
			merchantID_Txt.sendKeys(timestamp);
		}

		else {
			merchantID_Txt.clear();
			merchantID_Txt.sendKeys(searchacquirerrobj.getMerchant_ID());
		}

		retailerCode_Txt.sendKeys(searchacquirerrobj.getRetailer_code());
		
	}
	

	public void saveOrCancel(SearchPojo savePojoobj) {

		if (savePojoobj.getAction().equalsIgnoreCase("Search")) {

			SearchButton.click();
		}
		else if (savePojoobj.getAction().equalsIgnoreCase("Reset")) {

			Reset_button.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}

}
