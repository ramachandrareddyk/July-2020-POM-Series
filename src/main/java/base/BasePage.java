package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;

	// this method is used to to initialize the driver on the basis of browser name.

	public WebDriver init_driver(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Safari")) {
			WebDriverManager.chromedriver().setup();
			driver = new SafariDriver();

		} else {
			System.out.println("Please pass the correct bowser name.....");
		}

		driver.manage().window().fullscreen();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Gopi\\eclipse-workspace\\july_2022_POM_Series\\src\\main\\java\\configProperties\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
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
