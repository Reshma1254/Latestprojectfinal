package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtility;

public class Base {
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("Browser")
	public void initialiseBrowser(String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome"))
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}

}
