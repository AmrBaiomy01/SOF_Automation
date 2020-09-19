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
import fawry.sofAutomation.pojos.accounts.AccountPojo;
import fawry.sofAutomation.pojos.acquirerMerchants.AcquirerPojo;

public class AddAcquirerMerchantPage extends MainPage {

	WebDriver driver;
	public AddAcquirerMerchantPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String newacccode;

	@FindBy(id="AddMerchant:textArabicName")
	WebElement arabicname_txt;

	@FindBy(id="AddMerchant:textEnglishName")
	WebElement englishname_txt;

	@FindBy(id="AddMerchant:textMerchantID")
	WebElement merchantID;

	@FindBy(id="AddMerchant:AcquirerList")
	WebElement acquirerbankList;

	@FindBy(id="AddMerchant:PaymentList")
	WebElement paymenttypeList;

	@FindBy(id="AddMerchant:billerList")
	WebElement billerLList;

	@FindBy(id="AddMerchant:btcsList")
	WebElement all_bill_types;

	@FindBy(id="AddMerchant:moveCSpToUser")
	WebElement move_billtype_touser;

	@FindBy(id="AddMerchant:textAccountCode")
	WebElement Account_Code;

	@FindBy(id="AddMerchant:corporate")
	WebElement cspList;

	@FindBy(id="AddMerchant:textbankTerminalID")
	WebElement bank_terminal_id;

	@FindBy(id="AddMerchant:addMerchnat")
	WebElement addMerchant;

	@FindBy(id="AddMerchant:mep:0:key")
	WebElement merchant_paramlist;

	@FindBy(id="AddMerchant:mep:0:value")
	WebElement value;

	@FindBy(id="AddMerchant:save")
	WebElement saveButton;

	@FindBy(id="AddMerchant:resetData")
	WebElement CancelButton;

	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addacquirerdata(AcquirerPojo addacquirerrobj) throws Exception


	{		
		
		CancelButton.click();
		
		Alert alert = driver.switchTo().alert();
        alert.accept();
        
		//Merchant Data

		arabicname_txt.sendKeys(addacquirerrobj.getArabic_Name());
		englishname_txt.sendKeys(addacquirerrobj.getEnglish_Name());

		if (addacquirerrobj.getMerchant_ID().equalsIgnoreCase("new")) {
			
			merchantID.clear();
			merchantID.sendKeys(timestamp);

		}

		else {
			merchantID.clear();
			merchantID.sendKeys(addacquirerrobj.getMerchant_ID());	
		}


		if (!addacquirerrobj.getAcquirer_Bank().isEmpty()) {

			Select acquirerBankList = new Select(acquirerbankList);
			acquirerBankList.selectByVisibleText(addacquirerrobj.getAcquirer_Bank());
		}

		//Payment and Biller Data

		if(!addacquirerrobj.getPayment_Type().isEmpty()) {
			Select paymentType = new Select(paymenttypeList);
			paymentType.selectByVisibleText(addacquirerrobj.getPayment_Type());
		}

		if(!addacquirerrobj.getBiller().isEmpty()) {
			Select billerList = new Select(billerLList);
			billerList.selectByVisibleText(addacquirerrobj.getBiller());
		}

		Select select = new Select( all_bill_types);
		Actions builder = new Actions(driver);
		for(int j=0; j<addacquirerrobj.getAll_Bill_Types().size();j++)
		{
			for(int i=0 ; i<select.getOptions().size();i++)
			{


				if(select.getOptions().get(i).getText().equalsIgnoreCase(addacquirerrobj.getAll_Bill_Types().get(j)))
				{
					builder.keyDown(Keys.CONTROL).click(select.getOptions().get(i)).keyUp(Keys.CONTROL);
					builder.build().perform(); 
					move_billtype_touser.click();
					Thread.sleep(2000);
					break;
				}

			}

		}


		//Account Data

		Account_Code.sendKeys(addacquirerrobj.getAccount_code());

		if (!addacquirerrobj.getCSP().isEmpty()) {

			Select CspList = new Select(cspList);
			CspList.selectByVisibleText(addacquirerrobj.getCSP());
		}

		bank_terminal_id.sendKeys(addacquirerrobj.getBank_Terminal_ID());


		//Data for Manage Merchant Extra Param


		if (!addacquirerrobj.getMerchant_Param().isEmpty() || !addacquirerrobj.getValue().isEmpty()) {

			addMerchant.click();

			if (!addacquirerrobj.getMerchant_Param().isEmpty()) {

				Select merchant_param = new Select(merchant_paramlist);
				merchant_param.selectByVisibleText(addacquirerrobj.getMerchant_Param());
			}

			value.sendKeys(addacquirerrobj.getValue());

		}
	}

	public void saveOrCancel(AcquirerPojo savePojoobj) {

		if (savePojoobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
		}
		else if (savePojoobj.getAction().equalsIgnoreCase("Cancel")) {

			CancelButton.click();
			
			Alert alert = driver.switchTo().alert();
            alert.accept();
		}
	}

}
