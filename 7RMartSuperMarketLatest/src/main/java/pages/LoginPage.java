package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(css="input[placeholder='Username']")WebElement username;
	@FindBy(css="input[placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement alert;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
	}
	public void enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	public void signIn()
	{
		
		signin.click();
	}
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
		
	}
	public HomePage login(String usernamevalue,String passwordvalue)
	{
		enterUserName(usernamevalue);
		enterPassword(passwordvalue);
		signIn();
		return new HomePage(driver);
		
	}
	

}
