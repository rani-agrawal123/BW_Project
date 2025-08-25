package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactsPage;

public class DataIntegrity {

	
	 @Test
	    public void verifyApiUserVisibleInUI() throws InterruptedException {
	        String expectedUserName = "Rani";

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://adminlte.io/themes/v3/pages/tables/data.html");
	        driver.manage().window().maximize();
	        Thread.sleep(2000);
	        
	        
	        
	        
	        // 🔹 Handle demo alert if it appears
	        try {
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Alert text: " + alert.getText());
	            alert.accept(); // Click OK
	        } catch (Exception e) {
	            System.out.println("No alert present, continue...");
	        }

	        ContactsPage contacts = new ContactsPage(driver);
	        contacts.searchUser(expectedUserName);
	        Thread.sleep(2000);

	        String actualName = contacts.getFirstRowName();
	        Assert.assertEquals(actualName, expectedUserName, "User not found in UI!");

	        driver.quit();
	    }
	 
}
