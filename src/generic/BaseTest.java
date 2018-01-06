package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst {
	public WebDriver driver;
	static {
		System.setProperty(CHOME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)

	public void openApp(@Optional("chrome") String browser) {
		if (browser.equals(browser)) {
			driver = new ChromeDriver();

		} else {
			driver = new FirefoxDriver();
		}
		String url = AL.getProperty(SETTINGS_PATH, "URL");
		driver.get(url);
		String strITO = AL.getProperty(SETTINGS_PATH, "ITO");
		long ITO = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closeApp(ITestResult res) {
		String name = res.getName();
		int status = res.getStatus();
		if (status == 2) {
			String imgPath = AL.getPhoto(driver, PHOTO_PATH, name);
			Reporter.log("imgPath : " + imgPath, true);
		}
		driver.quit();
	}
}
