package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCODPage;
import utilities.ExcelUtility;


public class ManageCODTest extends Base {
	@Test(description="verify the user is able to select the respective radiobutton according to their payment preferences")
	public void VerifyWhetherTheUserIsAbleToSelectTheRadioButton() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage home=loginpage.login(usernamevalue, passwordvalue);
		ManageCODPage cod=home.clickManageCODMoreInfo();
		cod.clickFirstRadioButton();
		cod.clickSave();
		boolean cash=cod.isSuccessDisplayed();
		Assert.assertTrue(cash);
	}

}
