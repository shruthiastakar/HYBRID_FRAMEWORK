package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest {
	@Test(priority = 2, groups = { "login" })
	public void testCheckProductVersion() {
		String sheet = "CheckProductVersion";
		String un = XL.getCellValue(XL_PATH, sheet, 1, 0);
		String pwd = XL.getCellValue(XL_PATH, sheet, 1, 1);
		String eVersion = XL.getCellValue(XL_PATH, sheet, 1, 2);

		// 1.enter valid user name
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);

		// 2.enter valid password
		l.setPassword(pwd);

		// 3.click login
		l.clickLogin();

		// 4.click Help
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickHelp();

		// 5.click about your actiTIME
		e.clickAboutActitime();

		// 6.verify Product version
		e.verifyVersion(eVersion);
	}
}
