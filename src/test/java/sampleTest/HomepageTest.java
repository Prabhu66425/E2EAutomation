package sampleTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomepageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeBrowser();
		log.info("Browser initialized");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getData")
	public void validateUsers(String email, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys(email);
		loginp.getPassword().sendKeys(password);
		loginp.clickLoginButton().click();
		log.info("Clicked on Login button");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "restrictedUser@qw.com";
		data[0][1] = "45523523";

		data[1][0] = "nonRestrictedUser@qw.com";
		data[1][1] = "23412412";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
