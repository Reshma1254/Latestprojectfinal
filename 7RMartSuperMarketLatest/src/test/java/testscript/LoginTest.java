package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;


import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	@Test(groups= {"Regression"},description="verify whether user is able to Login successfully")
	public void verifyTheUserisAbleToLoginWithValidCredentials() throws IOException
	{
		/*String usernamevalue="admin";
		String passwordvalue="admin";*/
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
	
		loginpage.signIn();
		boolean homepage=loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage);
		
		
		
	}
	@Test
	public void verifyTheUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		
		loginpage.signIn();
		boolean homepage=loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage);
		
		
	}
	@Test
	
	public void verifyTheUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(3, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		
		loginpage.signIn();
		boolean homepage=loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage);
		
	}
	@Test
	public void verifyTheUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(4, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(4, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		
		loginpage.signIn();
		boolean homepage=loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage);
		
	}
	

}
