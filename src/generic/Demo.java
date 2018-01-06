package generic;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
	@BeforeMethod
	public void openApp() {
		Reporter.log("open App", true);
	}

	@Test
	public void testA() {
		Reporter.log("testA", true);
	}

	@Test
	public void testB() {
		Reporter.log("testB", true);
		Assert.fail();
	}

	@AfterMethod
	public void closeApp(ITestResult res) {
		String name = res.getName();
		int status = res.getStatus();
		Reporter.log("Close App : " + name + "; Status= " + status, true);
	}

}
