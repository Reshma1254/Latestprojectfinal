package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;


import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	 
		@Test //test
		public void verifyTheUserIsAbleToAddAdminUsers() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "Loginpage");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "Loginpage");

			LoginPage loginpage = new LoginPage(driver);
			HomePage home = loginpage.login(usernamevalue, passwordvalue);
			AdminUserPage info = home.clickAdminUserMoreInfo();
			info.clickNewButton();
			

			String usernameval = ExcelUtility.getStringData(1, 0, "AdminUser");
			String passwordvalu = ExcelUtility.getStringData(1, 1, "AdminUser");
			String usertype1 = ExcelUtility.getStringData(1, 2, "AdminUser");
			

			info.enterUsername(usernameval);

			info.enterPassword(passwordvalu);

			info.enterUserType(usertype1);
			info.enterSave();
			
			boolean admin=info.isAlertDisplayed();
			Assert.assertTrue(admin);

			

		}


}
