package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;


import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage home;
	 
		@Test(description="verify whether the user is able to add AdminUser details successfully")
		public void verifyTheUserIsAbleToAddAdminUsers() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "Loginpage");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "Loginpage");

			LoginPage loginpage = new LoginPage(driver);
			 home = loginpage.login(usernamevalue, passwordvalue);
			AdminUserPage info = home.clickAdminUserMoreInfo();
			info.clickNewButton();
			
			FakerUtility faker = new FakerUtility();
			String usernameval=faker.creatARandomFirstName();
			String passwordvalu = ExcelUtility.getStringData(1, 0, "AdminUser");
			
			
			String usertype1 = ExcelUtility.getStringData(1, 1, "AdminUser");
			

			info.enterUsername(usernameval);

			info.enterPassword(passwordvalu);

			info.enterUserType(usertype1);
			info.enterSave();
			
			boolean admin=info.isSuccessDisplayed();
			Assert.assertTrue(admin);

			

		}


}
