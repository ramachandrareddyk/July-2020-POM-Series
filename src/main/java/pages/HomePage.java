package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ElementUtilities;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtilities utils;
	
	private By SearchBox=By.name("search");
	private By SearchButton= By.xpath("//button[@type='button' and @class='btn btn-light btn-lg']");
	private By MyAccount= By.xpath("//span[text()='My Account']");
	private By Register= By.xpath("//a[text()='Register']");
	private By Login = By.xpath("//a[text()='Login']");
	private By TopMenu= By.id("menu");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		utils= new ElementUtilities(driver);
	}
	
	public String getHomePageTitle() {
		return utils.doGetPageTitle();
	}
	
	public boolean IsSearchBoxExixt() {
		return utils.doIsDisplayed(SearchBox);
	}
	
	public boolean isTopMenuExist() {
		return utils.doIsDisplayed(TopMenu);
	}
	
	public boolean isMyAccountExist() {
		return utils.doIsDisplayed(MyAccount);
	}
	
	public void navigateToLoginPage() {
		utils.doClick(MyAccount);
		utils.doClick(Login);
	}
	
	public void navigateToRegisterPage() {
		utils.doClick(MyAccount);
		utils.doClick(Register);
	}

}
