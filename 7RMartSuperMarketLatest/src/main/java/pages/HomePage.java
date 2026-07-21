package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and @class='dropdown-item' ]")
	WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and @class='small-box-footer']")WebElement managecategorymoreinfo;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenewsmoreinfo;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")WebElement adminusermoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/add-cod' and @class='small-box-footer']") WebElement managecodmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")WebElement managedeliveryboymoreinfo;
	WaitUtility wait=new WaitUtility();
	PageUtility page=new PageUtility();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public HomePage clickOnAdminButton() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogOutButton() {
		logout.click();
		return new LoginPage(driver);
	}
	


	public ManageCategoryPage clickManageCategoryMoreInfo() {
		
		
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageNewsPage clickManageNewsMoreInfo()
	
	{
		wait.waitForElementToBeClickable(driver, managenewsmoreinfo);
		page.javaScriptExecutorClick(driver, managenewsmoreinfo);
		
		return new ManageNewsPage(driver);
		
	}
	
	public AdminUserPage clickAdminUserMoreInfo()
	{
		adminusermoreinfo.click();
		return new AdminUserPage(driver);
	}
	public ManageCODPage clickManageCODMoreInfo()
	{
		managecodmoreinfo.click();
		return new ManageCODPage(driver);
	}
	public ManageDeliveryBoyPage clickManageDeliverBoyMoreInfo()
	{
		managedeliveryboymoreinfo.click();
		return new ManageDeliveryBoyPage(driver);
	}


}
