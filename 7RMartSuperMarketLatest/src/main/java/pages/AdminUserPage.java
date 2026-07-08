package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

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
	
	public AdminUserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickNewButton()
	{
		newbutton.click();
		
	}
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void enterUserType(String type)
	{
		drop.dropDownVisibleText(usertype,type);
		
	}
	public void enterSave()
	{
		save.click();
	}
	public boolean isSuccessDisplayed()
	{
		return success.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	


}
