package base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AccountCreatedPage;
import pages.ForgetYourPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;

public class BaseTest {
	
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public HomePage home;
	public LoginPage login;
	public MyAccountPage myaccount;
	public ForgetYourPasswordPage forget;
	public RegisterPage register;
	public AccountCreatedPage account;

	
	@BeforeMethod
	public void setUp() {
		ITestResult result;
		
		basepage = new BasePage();
		prop=basepage.init_properties();
		driver=basepage.init_driver(prop.getProperty("bowser"));
		home=new HomePage(driver);
		login= new LoginPage(driver);
		myaccount=new MyAccountPage(driver);
		forget= new ForgetYourPasswordPage(driver);
		register= new RegisterPage(driver);
		account=new AccountCreatedPage(driver);
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void terDown() {
		driver.quit();
	}
	public String getScreenshot() {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Gopi\\eclipse-workspace\\july_2022_POM_Series\\Scressnshots\\"+System.currentTimeMillis()+".png";
	try {
		FileUtils.copyFile(src, new File(path));
	}catch(IOException e) {
		e.printStackTrace();
	}
	return path;
	}
	
	
	
	
}
