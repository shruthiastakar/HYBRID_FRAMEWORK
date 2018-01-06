package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest_Grid implements IAutoConst {
	WebDriver driver;
	static {
		System.setProperty(CHOME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@Parameters({ "browser", "ip" })
	@BeforeMethod(alwaysRun = true)
	public void openApp(@Optional("chrome") String browser, @Optional("localhost") String ip)
			throws MalformedURLException {
		URL ra = new URL("http://" + ip + ":4444/wb/hub");
		DesiredCapabilities dc;
		if (browser.equals("chrome")) {
			dc = DesiredCapabilities.chrome();
		} else {
			dc = DesiredCapabilities.firefox();
		}
		driver = new RemoteWebDriver(ra, dc);
		// URL
		String url = AL.getProperty(SETTINGS_PATH, "URL");
		driver.get(url);
		String strITO = AL.getProperty(SETTINGS_PATH, "ITO");
		long ITO = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);

	}

}
