package utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement elementname,String filepath)
	{
		elementname.sendKeys(filepath);
	}
	public void fileUploadUsingRobotClass(WebElement elementname,String filepath) throws AWTException
	{
		StringSelection obj=new StringSelection("/Users/reshmaunniktrishnan/Downloads/ASSIGNMENT_33684428.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj,null);
        Robot r=new Robot();
        
     
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;//horizontalsize
        int centerY = (int) screenSize.getHeight() / 2;//vertical

        r.mouseMove(centerX, centerY);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

     // Wait after click
        r.delay(3000);

       /// Cmd + Shift + Goo   to folder
        r.keyPress(KeyEvent.VK_META);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_G);

        r.keyRelease(KeyEvent.VK_G);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_META);

        r.delay(3000); 

        // Cmd + V
        r.keyPress(KeyEvent.VK_META);
        r.keyPress(KeyEvent.VK_V);

        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_META);

        r.delay(3000);

        // First Enter - confirm path
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        r.delay(3000);

        
     // Move focus to Open button(tab plus enter,normal enter was not working for open button so tab plus enter)
        r.keyPress(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_TAB);
		
		
	}

}
