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

public class VerifyPageTitle extends Base {
	public static  Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeBrowser();
		
	}
	
	@Test()
	public void verifyFeatureText() throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);		
		Assert.assertEquals(lp.verifyFutCorseText().getText(), "FEATURED COURSES");
		log.info("Featured text is validated");
		
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	

}
