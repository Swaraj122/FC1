package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.Base;

public class VerifyLogin extends Base {
	
	WebElement element;

	@Test(dataProvider = "login", dataProviderClass = loginpage.class)
	public void executeLogin(String locatorType, String locatorValue, String keyword, String value) {
		
		// browser actions
		switch (keyword) {
		case "open browser":
			driver.get(value);
			break;

		case "close browser":
			driver.quit();

		default:
			break;
		}

		// other actions
		switch (locatorType) {
		case "name":
			element = driver.findElement(By.name(locatorValue));
			if (keyword.equalsIgnoreCase("enter")) {
				element.sendKeys(value);
			} else {
				element.click();
			}
			break;

		default:
			break;
		}

	}

}
