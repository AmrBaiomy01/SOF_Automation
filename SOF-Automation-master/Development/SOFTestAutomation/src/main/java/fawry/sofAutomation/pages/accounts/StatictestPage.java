package fawry.sofAutomation.pages.accounts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.microsoft.schemas.office.visio.x2012.main.PageType;

import fawry.sofAutomation.constants.accounts.Constants;
import fawry.sofAutomation.pojos.accounts.Tetspagepojo;


public class StatictestPage {
	WebDriver driver;

	public StatictestPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="pageNameEn")
	public WebElement pageNameEn;

	@FindBy(id="form1:checkAccount")
	public WebElement pageNameAr;

	@FindBy(id="form1:resetAccount")
	public WebElement createpagebtn;

	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElement merchantname;

	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[2]")
	WebElement merchantcode;

	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[5]/td[2]")
	WebElement PageType;

	

	String actualmoveaccount;
	String errorMsgs;
	public String newCsp;
	public String newMercahnt;


	public String userActions(Tetspagepojo stobj) throws Exception 
	{
		String output =null;
		
		if(stobj.getAction().contains("create")) 
		{
			create(stobj);
		}
			
		else if(stobj.getAction().contains("update"))
		{
			update(stobj);
		}
		else if(stobj.getAction().contains("delete")) {
			delete(stobj);
		}
		
		
	return output;
	
	}

	public void create(Tetspagepojo obj) throws Exception 
	{
		
		createpagebtn.click();
		pageNameEn.clear();
		pageNameEn.sendKeys(obj.getPageNameEn());
		pageNameAr.clear();
		pageNameAr.sendKeys("Arabic test");
		PageType.sendKeys(obj.getPagetype());
	}
	
	public void delete(Tetspagepojo obj) throws Exception 
	{
		
		System.out.println("deleted");
		
	}
	
	public void update(Tetspagepojo obj) throws Exception 
	{
		
		System.out.println("updated");
		
	}
	
}
