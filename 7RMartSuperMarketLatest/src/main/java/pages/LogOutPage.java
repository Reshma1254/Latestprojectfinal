package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and @class='dropdown-item' ]")
	WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement alert;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public void clickOnAdminButton() {
		admin.click();
	}

	public void clickOnLogOutButton() {
		logout.click();
	}
	public boolean isSignInisDisplayed()
	{
		return signin.isDisplayed();
		
	}

}
