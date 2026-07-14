package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot capture the current situation of the
															// browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//capture scrnshot store itas temporaryfile
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//current date fetch cheyyan Date class,date 
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //outputscreenshot folder il file create cheyyyan
		if (!f1.exists()) {
			f1.mkdirs(); // if f1 dir not exists,make it again ie,mkdirs
		}
		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp
				+ ".png"; //decide final scrnshot path
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class and copy method 
	}
}
