package script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.LoginPage;

public class invalidLogin_MultipleData extends BaseTest {
	@Test(priority = 2, groups = { "login" })
	public void testInvalidLogin() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		String sheet = "InvalidLogin";
		int rc = XL.getRowCount(XL_PATH, sheet);
		for (int i = 0; i <= rc; i++) {
			String un = XL.getCellValue(XL_PATH, sheet, i, 0);
			String pwd = XL.getCellValue(XL_PATH, sheet, i, 1);

			// 1.enter invalid username
			LoginPage l = new LoginPage(driver);
			l.setUserName(un);

			// 2.enter invalid password
			l.setPassword(pwd);

			// 3.click login
			l.clickLogin();
		}
	}
}
