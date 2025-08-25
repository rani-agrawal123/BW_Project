package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage {


	 WebDriver driver;

	    By searchBox = By.xpath("//input[@type='search']");
	    By firstRowName = By.xpath("//table/tbody/tr[1]/td[1]");

	    public ContactsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void searchUser(String name) {
	        driver.findElement(searchBox).sendKeys(name);
	    }

	    public String getFirstRowName() {
	        return driver.findElement(firstRowName).getText();
	    }
	
}
