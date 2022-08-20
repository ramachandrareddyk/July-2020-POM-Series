package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ElementUtilities;

public class AccountCreatedPage extends BasePage{
	
	WebDriver driver;
	ElementUtilities utils;
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver=driver;
		utils= new ElementUtilities(driver);
	}
	
	By Successmessage=By.xpath("//h1[text()='Your Account Has Been Created!']");
	
	
	
	public boolean verfiySuccessMessageexist() {
		return utils.doIsDisplayed(Successmessage);
	}

}
