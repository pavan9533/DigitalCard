package Utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeyword extends ValidationKeyword{
	
	
		
	
	public ApplicationKeyword() {
		String path = System.getProperty("user.dir")+"\\Properties\\env.properties";
		envprop = new Properties();
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(path);
			envprop.load(file);
			String environment = envprop.getProperty("env")+".properties";
			path =  System.getProperty("user.dir")+"\\Properties\\"+environment;
			file = new FileInputStream(path);
			prop.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//softAssert = new SoftAssert();
	}
	
	
	
	public void setReport(ExtentTest test) {
		this.test = test;
	}
	

	    public void uploadInventory(String uploadLocator) throws InterruptedException, Exception  {
	    	
	        String filePath = System.getProperty("user.dir")+"\\Excel\\sample_inventory.csv";

	        // Click on the upload button to trigger the native file upload dialog
	        WebElement uploadButton = driver.findElement(getLocator(uploadLocator));
	        uploadButton.click();

	        // Wait for the file upload dialog to appear
	        Thread.sleep(2000); // Adjust the wait time as needed

	        // Set the file path to the clipboard
	        StringSelection stringSelection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	        // Simulate keyboard actions to paste the file path and press Enter
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	        // Wait for the file to be uploaded (add appropriate wait time if needed)
	        Thread.sleep(5000); // Example: Wait for 5 seconds after pressing Enter

	        // Continue with any further actions or verifications after the file upload
	    }
	    
}

