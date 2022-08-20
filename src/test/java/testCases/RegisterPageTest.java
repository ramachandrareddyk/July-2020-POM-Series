package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Constents;
import utilities.ExcelUtility;

public class RegisterPageTest extends BaseTest{
	
	@Test
	public void verfyRegisterPageTitle() {
		home.navigateToRegisterPage();
		
		String title=register.getPageTitle();
		Assert.assertEquals(title, Constents.RegisterPageTitle);
	}
	
	@DataProvider
	public Object[][] getRegisterTestData(){
		Object data[][]=ExcelUtility.getTestDataFromExcel("register");
		return data;
	}
	
	@Test(dataProvider = "getRegisterTestData")
	public void registerNewUser(String firstname,String lastname, String email, String telephone,String password,String subscribe) {
		home.navigateToRegisterPage();
		register.fillRegForm(firstname, lastname,email,telephone,password,subscribe);
		Assert.assertTrue(account.verfiySuccessMessageexist());
	}

}
