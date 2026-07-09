package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public ManageDeliveryBoyPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add'and @onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@placeholder='Enter the Name']")WebElement name;
	@FindBy(xpath="//input[@name='username']")WebElement username;
	
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement success;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	WaitUtility wait=new WaitUtility();
	PageUtility page=new PageUtility();
	
	public void clickNew()
	{
		newbutton.click();
	}
	public void enterName(String names)
	{
		name.sendKeys(names);
	}
	public void enterEmail(String mail)
	{
		email.sendKeys(mail);
	}
	public void enterPhone(String ph)
	{
		phone.sendKeys(ph);
	}
	public void enterAddress(String adrs)
	{
		address.sendKeys(adrs);
	}
	public void enterUsername(String usr)
	{
		username.sendKeys(usr);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickSave()
	{
		wait.waitForElementToBeClickable(driver, save);
		page.javaScriptExecutorPageScroll(driver, 0, 500);
		page.javaScriptExecutorClick(driver, save);
	}
	public boolean isSuccessDisplayed()
	{
	//	wait.waitForVisibilityOff(driver, success);
		return success.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		//wait.waitForVisibilityOff(driver, alert);
		
		return alert.isDisplayed();
	}
	
	
	

}
