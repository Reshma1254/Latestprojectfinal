package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @onclick='click_button(1)']")WebElement newbutton;

	@FindBy(xpath="//textarea[@id='news']")WebElement news;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement success;
	WaitUtility wait=new WaitUtility();
	
	
	public ManageNewsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewButton()
	{
		wait.waitForElementToBeClickable(driver, newbutton);
		newbutton.click();
		
	}
	public void enterNews(String report)
	{
		news.sendKeys(report);
	}
	public void clickSave()
	{
		save.click();
	}
	public boolean isSuccessDisplayed()
	{
		return success.isDisplayed();
	}
	
	
}
