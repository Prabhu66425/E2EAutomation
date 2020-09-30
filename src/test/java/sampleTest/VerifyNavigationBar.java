package sampleTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import base.Base;
import pageObjects.LandingPage;

public class VerifyNavigationBar extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeBrowser();
		log.info("Launched browser");		
	}

	@Test()
	public void verifyNavigationBar1() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.verifyNavBar().isDisplayed());
		log.info("Navigation bar is present");
		

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
