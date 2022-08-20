package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ElementUtilities;

public class ForgetYourPasswordPage extends BasePage{
	
	WebDriver driver;
	
	ElementUtilities utls;
	
	public ForgetYourPasswordPage(WebDriver driver) {
		this.driver=driver;
		utls= new ElementUtilities(driver);
		
	}
	
	public String getPageTitle() {
		return utls.doGetPageTitle();
	}

}
