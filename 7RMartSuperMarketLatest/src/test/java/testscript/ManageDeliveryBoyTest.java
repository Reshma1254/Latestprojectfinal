package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage home;
	@Test(description="Verify that the user is able to add the Delivery boy details successfully")
	public void verifyTheUserIsAbleToAddDeliverBoyDetails() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		 home=loginpage.login(usernamevalue, passwordvalue);
		ManageDeliveryBoyPage deliveryboy=home.clickManageDeliverBoyMoreInfo();
		
		String name=ExcelUtility.getStringData(1, 0, "DeliveryBoy");
		String email=ExcelUtility.getStringData(1, 1, "DeliveryBoy");
		String phone=ExcelUtility.getStringData(1, 2, "DeliveryBoy");
		String address=ExcelUtility.getStringData(1, 3, "DeliveryBoy");
		
		FakerUtility data=new FakerUtility();
		String adduser=data.creatARandomFirstName();
		String addpass=data.creatARandomLastName();
		deliveryboy.clickNew().enterName(name).enterEmail(email).enterPhone(phone).enterAddress(address).enterUsername(adduser).enterPassword(addpass).clickSave();
		/*deliveryboy.enterName(name);
		deliveryboy.enterEmail(email);
		deliveryboy.enterPhone(phone);
		deliveryboy.enterAddress(address);
		deliveryboy.enterUsername(adduser);
		deliveryboy.enterPassword(addpass);
		deliveryboy.clickSave();*/
		boolean del=deliveryboy.isSuccessDisplayed();
		Assert.assertTrue(del,Constant.DELIVERYBOYFAIL);
		
	
		
		
		
		
	}

}
