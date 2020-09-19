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
import fawry.sofAutomation.pojos.lookupDefinitions.AddAccountTypeProfilePojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.ManageAccountTypeProfilePojo;

public class ManageAccountTypeProfilePage extends MainPage {

	WebDriver driver;
	public ManageAccountTypeProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="form1:accountType")
	WebElement accountType_List;

	@FindBy(id="form1:csp")
	WebElement CSP_List;

	@FindBy(id="form1:acquireBank")
	WebElement acquirerBank_List;

	@FindBy(id="addBank:status")
	WebElement status_List;

	@FindBy(id="form1:merchantCode")
	WebElement merchantCode_txt;
	
	@FindBy(id="form1:externalAuthorizerSystemCode")
	WebElement externalAuthorizerSystemCode_txt;

	@FindBy(id="form1:paymentType")
	WebElement paymentType_List;
	
	@FindBy(id="form1:isAutoPayment")
	WebElement isAutoPayment_check;
	
	
	@FindBy(id="form1:billerList")
	WebElement biller_List;
	
	@FindBy(id="form1:moveCSpToUser")
	WebElement allBillTypes_Move;
	
	
	@FindBy(id="form1:button1")
	WebElement searchButton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	
	public void manageAccTypeProfile(ManageAccountTypeProfilePojo manageAccountTypeProfileobj) throws Exception


	{		
		
			//account_type
		if (!manageAccountTypeProfileobj.getAccountType_List().isEmpty()) {
			
			Select acctype = new Select(accountType_List);
			acctype.selectByVisibleText(manageAccountTypeProfileobj.getAccountType_List());
		}

			//customer service provider
		if (!manageAccountTypeProfileobj.getCSP_List().isEmpty()) {
			
			Select csp = new Select(CSP_List);
			csp.selectByVisibleText(manageAccountTypeProfileobj.getCSP_List());
			
		}

			//Acquire Bank
		if (!manageAccountTypeProfileobj.getAcquirerBank_List().isEmpty()) {
			
			Select acquirerbank = new Select(acquirerBank_List);
			acquirerbank.selectByVisibleText(manageAccountTypeProfileobj.getAcquirerBank_List());
		}
		
			//merchant
			merchantCode_txt.sendKeys(manageAccountTypeProfileobj.getMerchantCode_txt());
					
			//payment type
		if (!manageAccountTypeProfileobj.getPaymentType_List().isEmpty()) {
			
			Select paymentType = new Select(paymentType_List);
			paymentType.selectByVisibleText(manageAccountTypeProfileobj.getPaymentType_List());
			
		}
		
			isAutoPayment_check.click();

		
		   //External authorizer
			externalAuthorizerSystemCode_txt.sendKeys(manageAccountTypeProfileobj.getExternalAuthorizerSystemCode_txt());		
		
		
		   //select biller
		if (!manageAccountTypeProfileobj.getBiller_List().isEmpty()) {

			Select billerlist = new Select(biller_List);
			billerlist.selectByVisibleText(manageAccountTypeProfileobj.getBiller_List());		
		}
		
		
		Select select = new Select(allBillTypes_Move);
		Actions builder = new Actions(driver);
		for(int j=0; j<manageAccountTypeProfileobj.getAll_Bill_Types().size();j++)
		{
			for(int i=0 ; i<select.getOptions().size();i++)
			{				
				if(select.getOptions().get(i).getText().equalsIgnoreCase(manageAccountTypeProfileobj.getAll_Bill_Types().get(j)))
				{
					builder.keyDown(Keys.CONTROL).click(select.getOptions().get(i)).keyUp(Keys.CONTROL);
					builder.build().perform();
					allBillTypes_Move.click();
					Thread.sleep(2000);
					break;
				}
			}
		}
		
		searchButton.click();
	}



}
