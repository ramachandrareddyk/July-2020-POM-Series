package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ElementUtilities;

public class RegisterPage extends BasePage {
	WebDriver driver;
	ElementUtilities utils;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		utils= new ElementUtilities(driver);
	}
	
	private By FirstName=By.id("input-firstname");
	private By LastName=By.id("input-lastname");
	private By Email=By.id("input-email");
	private By Telephone=By.id("input-telephone");
	private By Password=By.id("input-password");
	private By COnformPassword=By.id("input-confirm");
	private By newsLetterYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By NewsLetterNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	private By AgreeCheckBox=By.name("agree");
	private By ContinueBtn= By.xpath("//input[@value='Continue']");
	
	
	public String getPageTitle() {
		return utils.doGetPageTitle();
	}
	
	public void fillRegForm(String fName, String lName, String email, String Mobile, String Pass,String subscribe) {
		utils.doSendKeys(FirstName, fName);
		utils.doSendKeys(LastName, lName);
		utils.doSendKeys(Email, email);
		utils.doSendKeys(Telephone, Mobile);
		utils.doSendKeys(Password, Pass);
		utils.doSendKeys(COnformPassword, Pass);
		if(subscribe.equalsIgnoreCase("yes")) {
			utils.doClick(newsLetterYes);
		} else {
			utils.doClick(NewsLetterNo);
		}
		utils.doClick(AgreeCheckBox);
		utils.doClick(ContinueBtn);
	}

}
