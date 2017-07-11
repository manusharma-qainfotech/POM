package ActionTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Action.Main;
import static org.assertj.core.api.Assertions.*;

public class GmailTest {
	Main main;
	WebDriver driver;

	@BeforeTest
	public void beforeTest() throws IOException {
		main = new Main();
	}

	@Test
	public void LoginProcess() throws IOException, InterruptedException {
		driver = main.NavigateToSite();

		main.loginStep1(driver);
		Thread.sleep(2000);
		assertThat(main.getWebElement((main.elements.getObjByElement("validate1")), driver).getText())
				.isEqualTo("Welcome");
		Thread.sleep(2000);
	}
	@Test
	public void checkInvalidPass() throws FileNotFoundException, InterruptedException
	{
		main.InvalidPassword(driver);
		Thread.sleep(2000);
		assertThat(main.getWebElement((main.elements.getObjByElement("wrongpassword")), driver).getText())
				.isEqualTo("Wrong password. Try again.");
		Thread.sleep(2000);
		
	}
	@Test
	public void checkLoginHomePage() throws FileNotFoundException, InterruptedException
	{
		main.validPassword(driver);
		Thread.sleep(2000);
		assertThat(main.getWebElement((main.elements.getObjByElement("welcome")), driver).getText())
				.isEqualTo("Welcome, manu shrma");
		Thread.sleep(2000);
		main.logout(driver);
		driver.close();
	}

}
