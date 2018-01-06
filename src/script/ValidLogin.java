package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {

	@Test(priority = 1, groups = { "login", "smoke" })
	public void testValidLogin() {
		String sheet = "ValidLogin";
		String un = XL.getCellValue(XL_PATH, sheet, 1, 0);
		String pwd = XL.getCellValue(XL_PATH, sheet, 1, 1);
		String eTitle = XL.getCellValue(XL_PATH, sheet, 1, 2);
		Reporter.log(un+"-"+pwd+"-"+eTitle);

		// 1.Enter valid user name
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);

		// 2.Enter valid Password
		l.setPassword(pwd);

		// 3.Click on login
		l.clickLogin();

		// 4.Verify if Home Page id displayed
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.verifyTitle(driver, eTitle);

	}

}
