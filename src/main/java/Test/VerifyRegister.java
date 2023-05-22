package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.Base;
import Functionality.Registration;

public class VerifyRegister extends Base {
	

	public WebElement element;

	@Test(dataProvider = "register",dataProviderClass =Registration.class)
	public void verifyingregister(String locatorType, String locatorValue, String keyword, String value) {

		// browser actions
		switch (keyword) {
		case "open browser":
			driver.get(value);
			break;

		case "close browser":
			driver.quit();
			break;

		default:
			break;
		}

		switch (locatorType) {

		
		case "name":
			element = driver.findElement(By.name(locatorValue));
			if (keyword.equalsIgnoreCase("enter")) { 
				element.sendKeys(value);
			} else if (keyword.equalsIgnoreCase("click")) {
				element.click(); 
			} else {
				Select sel = new Select(element);
				sel.selectByVisibleText(value); 
			}
			break;

		
		default:
			break;
		}

	}

}
