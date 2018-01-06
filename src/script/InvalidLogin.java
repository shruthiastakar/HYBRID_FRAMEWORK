package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority = 2, groups = { "login" })
	public void testInvalidLogin() {
		String sheet = "InvalidLogin";
		String un = XL.getCellValue(XL_PATH, sheet, 1, 0);
		String pwd = XL.getCellValue(XL_PATH, sheet, 1, 1);
		
		LoginPage l = new LoginPage(driver);
		
		//1. enter invalid user name		
		l.setUserName(un);
		
		// 2.enter invalid password
		l.setPassword(pwd);

		// 3.click login
		l.clickLogin();

		// 4.verify err msg is displayed or not
		l.verifyErrMsgIsDisplayed(driver);
	}

}
