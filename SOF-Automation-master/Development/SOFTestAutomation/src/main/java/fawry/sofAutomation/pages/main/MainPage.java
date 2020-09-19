package fawry.sofAutomation.pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import fawry.sofAutomation.constants.accounts.Constants;
import fawry.sofAutomation.pojos.admin.LoginPojo;

public class MainPage {


	public void moveToPage(String tab , String field , WebDriver driver)
    {
        WebElement element = driver.findElement(By.linkText(tab));

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();

        WebElement subElement = driver.findElement(By.linkText(field));

        action.moveToElement(subElement);

        action.click();

        action.perform();

 

    }
	

}
