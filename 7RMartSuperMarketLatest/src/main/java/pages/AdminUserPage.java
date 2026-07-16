package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	
	@FindBy(xpath="//input[@id='username']")WebElement username;
			
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name=\"Create\"]")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement success;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	PageUtility drop= new PageUtility();//test
	WaitUtility wait=new WaitUtility();
	
	public AdminUserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUserPage clickNewButton()
	{
		newbutton.click();
		return this;
		
	}
	public AdminUserPage enterUsername(String user)
	{
		username.sendKeys(user);
		return this;
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public AdminUserPage enterUserType(String type)
	{
		drop.dropDownVisibleText(usertype,type);
		return this;
		
	}
	public AdminUserPage enterSave()
	{
		save.click();
		return this;
	}
	public boolean isSuccessDisplayed()
	{
		wait.waitForVisibilityOff(driver, success);
		return success.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	


}
