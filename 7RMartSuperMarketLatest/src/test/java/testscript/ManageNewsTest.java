package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;


import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(groups={"Regression"})
	public void verifyTheUserCanAddNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Loginpage");

		LoginPage loginpage = new LoginPage(driver);
		HomePage home = loginpage.login(usernamevalue, passwordvalue);
		ManageNewsPage newsinfo = home.clickManageNewsMoreInfo();
		newsinfo.clickNewButton();

		String newsreport = ExcelUtility.getStringData(1, 0, "NewsInfo");
		newsinfo.enterNews(newsreport);
		newsinfo.clickSave();
		boolean newsre = newsinfo.isSuccessDisplayed();
		Assert.assertTrue(newsre);
		

	}

}
