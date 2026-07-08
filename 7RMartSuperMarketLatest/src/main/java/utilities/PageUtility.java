package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropDownVisibleText(WebElement elementname, String visibletext) {
		Select select = new Select(elementname);
		select.selectByVisibleText(visibletext);

	}

	public void dropDownValue(WebElement elementname, String value) {
		Select select = new Select(elementname);
		select.selectByValue(value);
	}

	public void dropDownIndex(WebElement elementname, int index) {
		Select select = new Select(elementname);
		select.selectByIndex(index);
	}
	public void dradAndDrop(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}
	public void mouseHover(WebDriver driver,WebElement elementname)
	{
		Actions action=new Actions(driver);
		action.moveToElement(elementname).perform();
	}
	public void rightClick(WebDriver driver,WebElement elementname)
	{
		Actions action=new Actions(driver);
		action.contextClick(elementname).perform();
	}
	public void click(WebDriver driver,WebElement elementname)
	{
		Actions action=new Actions(driver);
		action.click(elementname).perform();
	}
	public void doubleClick(WebDriver driver,WebElement elementname)
	{
		Actions action=new Actions(driver);
		action.doubleClick(elementname).perform();
	}
	public void javaScriptExecutorMessage(WebDriver driver,WebElement elementname,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		 js.executeScript("arguments[0].value=arguments[1];", elementname, value);
	}
	public void javaScriptExecutorClick(WebDriver driver,WebElement webelementname)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", webelementname);
	}
	public void javaScriptExecutorPageScroll(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}
	public void javascriptExecutorTotalScroll(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}

}
