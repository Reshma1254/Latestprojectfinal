package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	@Test
	public void verifyUserCanAddCategories() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage home=loginpage.login(usernamevalue, passwordvalue);
		ManageCategoryPage add=home.clickManageCategoryMoreInfo();
		add.clickNewButton();
		String addcategory=ExcelUtility.getStringData(1, 0, "AddCategory");
		add.selectGroup();
		
		add.enterCategory(addcategory);
		
		add.uploadFile(Constant.IMAGE2);
	
		add.clickSave();
		boolean category=add.isAlertDisplayed();
		Assert.assertTrue(category);
	}

}
