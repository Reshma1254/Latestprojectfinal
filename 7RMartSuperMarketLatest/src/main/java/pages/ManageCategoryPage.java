package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='2-selectable']")
	WebElement group;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement file;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement success;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
FileUploadUtility obj=new FileUploadUtility();
PageUtility page=new PageUtility();
WaitUtility wait=new WaitUtility();
	
	public ManageCategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickNewButton()
	{
		newbutton.click();
		
	}
	public void enterCategory(String addcategory) {
		category.sendKeys(addcategory);
	}

	public void selectGroup() {
		group.click();
	}

	public void uploadFile() {
		obj.fileUploadUsingSendKeys(file, Constant.IMAGE2);

	}
	

	public void clickSave() {
		
		page.javaScriptExecutorClick(driver, save);
		
	}
	public boolean isSuccessDisplayed()
	{
		wait.waitForVisibilityOff(driver, success);
		return success.isDisplayed();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}


}
