package testscript;

import org.testng.annotations.Test;

import constant.Constant;

import java.io.IOException;

import org.testng.Assert;


import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage home;
	@Test(groups={"Regression"},description="Verify that a user can add a news item successfully")
	public void verifyTheUserCanAddNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Loginpage");

		LoginPage loginpage = new LoginPage(driver);
		 home = loginpage.login(usernamevalue, passwordvalue);
		ManageNewsPage newsinfo = home.clickManageNewsMoreInfo();
		

		String newsreport = ExcelUtility.getStringData(1, 0, "NewsInfo");
		
		newsinfo.clickNewButton().enterNews(newsreport).clickSave();
		boolean newsre = newsinfo.isSuccessDisplayed();
		Assert.assertTrue(newsre,Constant.NEWSADDFAILURE);
		

	}

}
