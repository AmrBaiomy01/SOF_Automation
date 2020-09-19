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
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPBranchPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddCSPPojo;
import fawry.sofAutomation.pojos.lookupDefinitions.AddacquirerPojo;
import fawry.sofAutomation.testsActions.BasicDefinitions.AddCSPBTCPoolAccountTest;

public class AddCSPBranchPage extends MainPage {

	WebDriver driver;
	public AddCSPBranchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="addCSPBranch:code")
	WebElement Code_txt;

	@FindBy(id="addCSPBranch:alias")
	WebElement alias_txt;

	@FindBy(id="addCSPBranch:alias")
	WebElement Branchname_txt;

	@FindBy(id="addCSPBranch:address")
	WebElement Branchaddress_txt;

	@FindBy(id="addCSPBranch:selectedCSP")
	WebElement CSPname_list;
	
	@FindBy(id="addCSPBranch:headquarter")
	WebElement headquarter_check;
	
	@FindBy(id="addCSPBranch:status")
	WebElement Active_check;
	
	
	@FindBy(id="addCSPBranch:saveBtn")
	WebElement saveButton;
	
	@FindBy(id="addCSPBranch:resetBtn")
	WebElement resetButton;
	
	@FindBy(id="addCSP:cancelBtn")
	WebElement cancelButton;
	
	
	
	String timestamp = new SimpleDateFormat("hhssmm").format(Calendar.getInstance().getTime());


	//
	public void addCSPbranchdata(AddCSPBranchPojo addcspbranchobj) throws Exception


	{		
		/*you can create CSP with code and name only*/
		
		//BankCode
		if (addcspbranchobj.getCode_txt().equalsIgnoreCase("new")) {
			
			Code_txt.clear();
			Code_txt.sendKeys(timestamp);
		}

		else {
			Code_txt.clear();
			Code_txt.sendKeys(addcspbranchobj.getCode_txt());
		}
		
		//alias_txt
				alias_txt.sendKeys(addcspbranchobj.getAlias_txt());
				
		//Branch name
				
				Branchname_txt.sendKeys(addcspbranchobj.getBranchname_txt());
				
		//Branch address		
				
				Branchaddress_txt.sendKeys(addcspbranchobj.getBranchaddress_txt());
				
		//CSP name		
				if(!addcspbranchobj.getCSPname_list().isEmpty()) {
					
				Select CSPnamelist = new Select(CSPname_list);
				CSPnamelist.selectByVisibleText(addcspbranchobj.getCSPname_list());
				
				}
				
		//checkBoxs				
		//headquarter_check.click();		
		//Active_check.click();
				
				
		}


	public void saveOrReset(AddCSPBranchPojo savecspbranchobj)  {

		if (savecspbranchobj.getAction().equalsIgnoreCase("Save")) {

			saveButton.click();
			
			/*Alert alert = driver.switchTo().alert();
            alert.accept();*/
			
		}
		
		else if (savecspbranchobj.getAction().equalsIgnoreCase("Reset")) {

			resetButton.click();
			
			/*Alert alert = driver.switchTo().alert();
            alert.accept();*/
		}
	}

}
