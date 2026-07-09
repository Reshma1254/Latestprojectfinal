package testscript;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {
	@Test(groups= {"Regression"})
	public void verifyUserCanAddCategories() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Loginpage");

		LoginPage loginpage = new LoginPage(driver);
		HomePage home = loginpage.login(usernamevalue, passwordvalue);
		ManageCategoryPage add = home.clickManageCategoryMoreInfo();
		add.clickNewButton();
		
		// String addcategory=ExcelUtility.getStringData(1, 0, "AddCategory"),category only fakerutility;
		FakerUtility faker = new FakerUtility();
		String categoryname = faker.generateCategory();
		add.enterCategory(categoryname);

		add.selectGroup();

		add.uploadFile();

		add.clickSave();
		boolean category = add.isSuccessDisplayed();
		Assert.assertTrue(category);
	}

}
