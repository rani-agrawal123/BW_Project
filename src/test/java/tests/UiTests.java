package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UiTests {
		 WebDriver driver;

		    @BeforeMethod
		    public void setup() {
		        // Start browser before each test
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://adminlte.io/themes/v3/pages/tables/data.html");
		    }

		    @Test
		    public void testTableSearch() {
		        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Bradley");
		        String text = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
		        System.out.println("First row text: " + text);
		    }

		    @AfterMethod
		    public void tearDown() throws InterruptedException {
		        // Close browser after each test
		        if (driver != null) {
		        	Thread.sleep(3000);
		            driver.quit();
		        }
		    }
}
