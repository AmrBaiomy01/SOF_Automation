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

public class AddAccountTypeProfilePage extends MainPage {

	WebDriver driver;
	public AddAccountTypeProfilePage(WebDriver driver)
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
	WebElement AddButton;
	
	
	@FindBy(id="form1:button2")
	WebElement Resetbutton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	
	public void addAccTypeProfile(AddAccountTypeProfilePojo addAccountTypeProfileobj) throws Exception


	{		
		
			//account_type
		if (!addAccountTypeProfileobj.getAccountType_List().isEmpty()) {
			
			Select acctype = new Select(accountType_List);
			acctype.selectByVisibleText(addAccountTypeProfileobj.getAccountType_List());
		}

			//customer service provider
		if (!addAccountTypeProfileobj.getCSP_List().isEmpty()) {
			
			Select csp = new Select(CSP_List);
			csp.selectByVisibleText(addAccountTypeProfileobj.getCSP_List());
		}

			
			//Acquire Bank
		if (!addAccountTypeProfileobj.getCSP_List().isEmpty()) {
			
			Select csp = new Select(CSP_List);
			csp.selectByVisibleText(addAccountTypeProfileobj.getCSP_List());
		}
		
			//merchant
		merchantCode_txt.sendKeys(addAccountTypeProfileobj.getMerchantCode_txt());
				
		
		  //External authorizer
		externalAuthorizerSystemCode_txt.sendKeys(addAccountTypeProfileobj.getExternalAuthorizerSystemCode_txt());		
		
			//payment type
		if (!addAccountTypeProfileobj.getPaymentType_List().isEmpty()) {
			
			Select paymentType = new Select(paymentType_List);
			paymentType.selectByVisibleText(addAccountTypeProfileobj.getCSP_List());
			
		}
		
		
		isAutoPayment_check.click();

		
		   //select biller
		if (!addAccountTypeProfileobj.getBiller_List().isEmpty()) {

			Select billerlist = new Select(biller_List);
			billerlist.selectByVisibleText(addAccountTypeProfileobj.getBiller_List());	
			
		}
		
		Select select = new Select(allBillTypes_Move);
		Actions builder = new Actions(driver);
		for(int j=0; j<addAccountTypeProfileobj.getAll_Bill_Types().size();j++)
		{
			for(int i=0 ; i<select.getOptions().size();i++)
			{
				
				if(select.getOptions().get(i).getText().equalsIgnoreCase(addAccountTypeProfileobj.getAll_Bill_Types().get(j)))
				{
					builder.keyDown(Keys.CONTROL).click(select.getOptions().get(i)).keyUp(Keys.CONTROL);
					builder.build().perform();
					allBillTypes_Move.click();
					Thread.sleep(2000);
					break;
				}

			}

		}
		
	}



}
