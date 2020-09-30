package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Prabhugouda R\\eclipse-workspace\\E2EAutomation\\src\\main\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("FF")) {

			System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", "E:\\Softwares\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshotPath(String testCaseName, WebDriver driver) throws Throwable {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destFile));
		
		
	}

}
