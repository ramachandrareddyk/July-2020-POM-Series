package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtilities(WebDriver driver) {
		this.driver=driver;
		wait= new WebDriverWait(driver, 20);
	}
	
	public WebElement getElement(By Locater) {
		WebElement element= driver.findElement(Locater);
		
		return element;
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
	
	public void doClick(By Locater) {
		getElement(Locater).click();
	}
	
	public void doSendKeys(By Locater,String... text) {
		getElement(Locater).clear();
		getElement(Locater).sendKeys(text);
	}
	
	public void selectValueFromDropdownWithSelectByVisbleText(By Locater, String value) {
		Select slect= new Select(getElement(Locater));
		slect.selectByVisibleText(value);
	}
	
	public void selectValueFromDropdownWithSelectByIndex(By Locater, int value) {
		Select slect= new Select(getElement(Locater));
		slect.selectByIndex(value);
	}
	
	public void selectValueFromDropdownWithSelectByvalue(By Locater, String value) {
		Select slect= new Select(getElement(Locater));
		slect.selectByValue(value);
	}
	
	public String doGetText(By Loacter) {
		return getElement(Loacter).getText();
	}
	
	public String doGetPageTitle() {
		return driver.getTitle();
	}
	
	public boolean doIsDisplayed(By Locater) {
		return getElement(Locater).isDisplayed();
	}
	
	public String doGetAttribute(By Locater, String attribute) {
		return getElement(Locater).getAttribute(attribute);
	}

}
