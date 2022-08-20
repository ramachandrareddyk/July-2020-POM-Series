package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ElementUtilities;

public class MyAccountPage extends BasePage{
	
	
	WebDriver driver;
	ElementUtilities utils;
	
	public MyAccountPage(WebDriver driver) {
		this.driver= driver;
		utils=new ElementUtilities(driver);
	}
	
	public String getMyAccountPageTitle() {
		
	return	utils.doGetPageTitle();
		
	}

}
