package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class AL {
	public static String getPhoto(WebDriver driver, String folder, String name) {
		TakesScreenshot t = (TakesScreenshot) driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		String date = new Date().toString().replaceAll(":", "-");
		String path = folder + "./" + name + date + ".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {

		}
		return path;

	}

	public static String getProperty(String path, String key) {
		String value = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			value = p.getProperty(key);
			Reporter.log(value,true);
		} catch (Exception e) {

		}
		return value;

	}
}
