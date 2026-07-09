package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;


import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"})

	public void verifyUserIsAbleToLogOutSuccessfullyFromDashboard() throws IOException {
		
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		LogOutPage logoutpage = new LogOutPage(driver);
		logoutpage.clickOnAdminButton();
		logoutpage.clickOnLogOutButton();
		boolean statuse=logoutpage.isSignInisDisplayed();
		Assert.assertTrue(statuse);

	}

}
