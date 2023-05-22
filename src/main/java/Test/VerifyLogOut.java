package Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.Base;
import Functionality.LogOutPage;

public class VerifyLogOut extends Base{
	

	@Test( dataProvider = "logout", dataProviderClass = LogOutPage.class)
	public void logout(String locatorType, String locatorValue,String keyword, String value) {
		System.out.println(keyword + " " + value + " " );
		
		
		//performing action on logout button
		if (keyword.equalsIgnoreCase("logout")) {
			driver.findElement(By.linkText(locatorValue)).click();
		}
		if(keyword.equalsIgnoreCase("close browser")){
			driver.quit();
		}

	}

}
