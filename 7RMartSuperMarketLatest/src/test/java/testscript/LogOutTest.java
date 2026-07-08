package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class)

	public void verifyUserIsAbleToLogOutSuccessfullyFromDashboard() throws IOException {
		/*String usernamevalue = "admin";
		String passwordvalue = "admin";*/
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
