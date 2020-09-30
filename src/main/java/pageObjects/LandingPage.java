package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signIn = By.cssSelector("a[href*='sign_in']");
	By futCourseText=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	public LandingPage(WebDriver driver) {		
		this.driver=driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement verifyFutCorseText() {
		return driver.findElement(futCourseText);
	}
	
	public WebElement verifyNavBar() {
		return driver.findElement(navBar);
	}

}
