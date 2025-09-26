package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

	
	
	 WebDriver driver;

	    By fileInput = By.id("customFile");

	    public void FormsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void uploadFile(String filePath) {
	        driver.findElement(fileInput).sendKeys(filePath);
	    }
	    
}
