package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageDeliveryBoyTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAddDeliverBoyDetails() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage home=loginpage.login(usernamevalue, passwordvalue);
		ManageDeliveryBoyPage deliveryboy=home.clickManageDeliverBoyMoreInfo();
		String name=ExcelUtility.getStringData(1, 0, "DeliveryBoy");
		String email=ExcelUtility.getStringData(1, 1, "DeliveryBoy");
		String phone=ExcelUtility.getStringData(1, 2, "DeliveryBoy");
		String address=ExcelUtility.getStringData(1, 3, "DeliveryBoy");
		FakerUtility data=new FakerUtility();
		String adduser=data.creatARandomFirstName();
		String addpass=data.creatARandomLastName();
		deliveryboy.clickNew();
		deliveryboy.enterName(name);
		deliveryboy.enterEmail(email);
		deliveryboy.enterPhone(phone);
		deliveryboy.enterAddress(address);
		deliveryboy.enterUsername(adduser);
		deliveryboy.enterPassword(addpass);
		deliveryboy.clickSave();
		boolean del=deliveryboy.isSuccessDisplayed();
		Assert.assertTrue(del);
		
	
		
		
		
		
	}

}
