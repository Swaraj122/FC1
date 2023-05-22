package Functionality;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import Base.Base;

public class LoginPage extends Base {
	

	@DataProvider(name = "login")
	public Object[][] login() throws Exception {
		
		driver.navigate().to("https://demo.guru99.com/test/newtours/login.php");

		// workbook initialization
		FileInputStream fis = new FileInputStream(
				new File("/Users/SW20466288/eclipse-workspace/HybridDataDriven/src/main/java/Utilities/LoginInfo.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		Object[][] data = new Object[sheet.getLastRowNum()][4];

		// actions
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			String locatorValue = "";
			String locatorType = "";
			String locator = sheet.getRow(i + 1).getCell(1).toString().trim();
			if (!locator.equalsIgnoreCase("NA")) {
				String[] locatorArr = locator.split("=");
				locatorType = locatorArr[0].trim();
				locatorValue = locatorArr[1].trim();
			}
			String keyword = sheet.getRow(i + 1).getCell(2).toString().trim();
			String value = sheet.getRow(i + 1).getCell(3).toString().trim();

			data[i][0] = locatorType;
			data[i][1] = locatorValue;
			data[i][2] = keyword;
			data[i][3] = value;
		}
		return data;
	}

}
