package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import base.BaseTest;
import utilities.Constents;

public class HomePageTest extends BaseTest{
	
	
	@Test
	public void verifyHomePageTitle() {
		//String title=home.getHomePageTitle();
		
		Assert.assertEquals("", Constents.HomePageTitle);
	}
	
	@Test
	public void verifyTopNavigationBar() {
		Assert.assertTrue(home.isTopMenuExist());
	}
	
	@Test
	public void verifyMyAccount() {
		Assert.assertTrue(home.IsSearchBoxExixt());
	}
	
	@Test
	public void verifySearchButton() {
		Assert.assertTrue(home.IsSearchBoxExixt());
	}
	
	

}
