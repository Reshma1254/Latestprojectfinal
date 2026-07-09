package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCODPage {
	
	public WebDriver driver;
	@FindBy(xpath="//input[@value='yes']")WebElement yesbutton;
	@FindBy(xpath="//input[@value='no']")WebElement nobutton;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement success;
	public ManageCODPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickFirstRadioButton()
	{
	if(yesbutton.isSelected())
	{
		System.out.println("YES IS ALREADY SELECTED");
	}
	else
	{
		yesbutton.click();
	}
	}
	public void clickSecondRadioButton()
	{
	if(nobutton.isSelected())
	{
		System.out.println("NO IS ALREADY SELECTED");
	}
	else
	{
		nobutton.click();
	}
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
