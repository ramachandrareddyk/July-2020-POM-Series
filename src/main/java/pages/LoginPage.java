package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ElementUtilities;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtilities utils;
	
	private By Username=By.id("input-email");
	private By Password=By.id("input-password");
	private By login= By.xpath("//input[@value='Login']");
	private By FoegetPassword=By.linkText("Forgotten Password");
	private By WarningMessageForInvalidCredentials=By.xpath("//div[text()=' Warning: No match for E-Mail Address and/or Password.']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		utils= new ElementUtilities(driver);
	}
	
	public String getLoginPageTitle() {
		return utils.doGetPageTitle();
	}
	
	public MyAccountPage loginToOpenCart(String username, String password) throws InterruptedException {
		
		utils.doSendKeys(Username, username);
		
		utils.doSendKeys(Password, password);
		Thread.sleep(5000);
		utils.doClick(login);
		
		return new MyAccountPage(driver);
	}
	
	public ForgetYourPasswordPage clickOnForgetPassword() {
		utils.doClick(FoegetPassword);
		
		return new ForgetYourPasswordPage(driver);
	}
	
	public boolean warningmessageIsExist() {
		return utils.doIsDisplayed(WarningMessageForInvalidCredentials);
	}

}
