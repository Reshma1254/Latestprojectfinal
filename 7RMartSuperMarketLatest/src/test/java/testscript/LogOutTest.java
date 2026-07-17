package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import pages.HomePage;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
HomePage home;
LoginPage loginpage;
	
	@Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"},description="verify the user is abe to Log out successfully")

	public void verifyUserIsAbleToLogOutSuccessfullyFromDashboard() throws IOException {
		
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		
		home=loginpage.signIn();
	    loginpage=home.clickOnAdminButton().clickOnLogOutButton();
	
		
	
		
		boolean statuse=loginpage.isSignInisDisplayed();
		Assert.assertTrue(statuse);
		

	}

}
