package Action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import Readers.ConfigReader;
import Readers.CredentialsReader;
import Readers.SpecsReader;
import model.locators;

public class Main {

	public ConfigReader browserNam;
	public CredentialsReader info;
	public SpecsReader elements;
	public WebDriver driver;
	public Main() throws IOException {

		browserNam = new ConfigReader();
		info = new CredentialsReader();
		elements = new SpecsReader();
	}

	public WebDriver NavigateToSite() throws IOException, InterruptedException {

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\manusharma\\Downloads\\geckodriver-v0.17.0-win64 (1)\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\manusharma\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
			String browse = browserNam.browser;

		if (browse.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		 


	//	File pathToBinary = new File("C:\\user\\Programme\\FirefoxPortable\\App\\Firefox\\firefox.exe");
		//FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		//FirefoxProfile firefoxProfile = new FirefoxProfile();       
	//	WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);


		driver.manage().deleteAllCookies();
		driver.get(info.url());

		return driver;
	}

	public void loginStep1(WebDriver driver) throws FileNotFoundException {
		locators loc = elements.getObjByElement("identifierId");
		WebElement element = getWebElement(loc, driver);
		element.sendKeys(info.credentials().get(0).getUserName());
		loc = elements.getObjByElement("identifierNext");
		(getWebElement(loc, driver)).click();
	}

	public void InvalidPassword(WebDriver driver) throws FileNotFoundException {
		locators loc = elements.getObjByElement("password");
		WebElement element = getWebElement(loc, driver);
		element.sendKeys(info.credentials().get(0).getpassword());
		loc = elements.getObjByElement("next");
		getWebElement(loc, driver).click();
	}

	public void validPassword(WebDriver driver) throws FileNotFoundException {
		locators loc = elements.getObjByElement("password");
		WebElement element = getWebElement(loc, driver);
		element.sendKeys(info.credentials().get(1).getpassword());
		loc = elements.getObjByElement("next");
		getWebElement(loc, driver).click();
	}

	public void logout(WebDriver driver) throws InterruptedException {
		locators loc = elements.getObjByElement("click");
		WebElement element = getWebElement(loc, driver);
		element.click();
		Thread.sleep(2000);
		loc = elements.getObjByElement("logout");
		getWebElement(loc, driver).click();
	}

	public static WebElement getWebElement(locators loc, WebDriver driver) {
		WebElement element;
		String type = loc.getLocatorType();
		if (type.equals("css")) {
			element = driver.findElement(By.cssSelector(loc.getLocatorValue()));
		} else {

			element = driver.findElement(By.xpath(loc.getLocatorValue()));
		}
		return element;

	}

}
