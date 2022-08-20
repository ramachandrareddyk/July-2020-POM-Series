package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Constents;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void verifyLoginPageTitleTest() {
		home.navigateToLoginPage();
		String title= login.getLoginPageTitle();
		Assert.assertEquals(title, Constents.LoginPageTitle);
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		home.navigateToLoginPage();
		login.loginToOpenCart(prop.getProperty("validusername"), prop.getProperty("validpassword"));
		String title=myaccount.getMyAccountPageTitle();
		Thread.sleep(10000);
		Assert.assertEquals(title, Constents.MyAccountPageTitle);
	}
	
	@Test
	public void verifyLoginWithInValidCredentialsValidUserNameAndInvalidPassword() throws InterruptedException {
		home.navigateToLoginPage();
		login.loginToOpenCart(prop.getProperty("validusername"), prop.getProperty("invalidPassword"));
		
		Assert.assertTrue(login.warningmessageIsExist());
		
	}
	
	@Test
	public void verifyLoginWithInValidCredentialsInValidUserNameAndValidPassword() throws InterruptedException {
		home.navigateToLoginPage();
		login.loginToOpenCart(prop.getProperty("invalidUsername"), prop.getProperty("validpassword"));
		
		Assert.assertTrue(login.warningmessageIsExist());
		
	}
	
	@Test
	public void verifyLoginWithInValidCredentialsInValidUserNameAndInValidPassword() throws InterruptedException {
		home.navigateToLoginPage();
		login.loginToOpenCart(prop.getProperty("invalidUsername"), prop.getProperty("invalidPassword"));
		
		Assert.assertTrue(login.warningmessageIsExist());
		
	}
	
	@Test
	public void verifyLoginWithInValidCredentialsInValidUserNameSapceAndInValidPasswordSpace() throws InterruptedException {
		home.navigateToLoginPage();
		login.loginToOpenCart("     ","    ");
		login.loginToOpenCart("     ","    ");
		login.loginToOpenCart("     ","    ");
		
		Assert.assertTrue(login.warningmessageIsExist());
		
	}
	
	@Test
	public void verifyForgetPasswordLink() {
		home.navigateToLoginPage();
		login.clickOnForgetPassword();
		String title=forget.getPageTitle();
		
		Assert.assertEquals(title, Constents.ForgetPasswordPageTitle);
	}
	
	

}
