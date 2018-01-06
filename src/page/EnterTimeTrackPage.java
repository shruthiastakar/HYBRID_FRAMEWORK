package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	@FindBy(xpath = "//div[contains(text(),'Help')]")
	private WebElement help;

	//@FindBy(linkText = "About your actiTIME")
	@FindBy(xpath="//a[text()='About your actiTIME']")
	private WebElement aboutActiTIME;

	@FindBy(xpath = "//span[contains(.,'actiTIME 201')]")
	private WebElement version;

	@FindBy(id = "aboutPopupCloseButtonId")
	private WebElement closeBTN;

	@FindBy(id = "logoutLink")
	private WebElement logout;

	// declaration
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public void verifyTitle(WebDriver driver, String eTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Pass: HomePage is displayed");
		} catch (Exception e) {
			Reporter.log("Fail: HomePage is NOT displayed");
			Assert.fail();
		}
	}

	public void clickHelp() {
		help.click();
	}

	public void clickAboutActitime() {
		aboutActiTIME.click();
	}

	public void verifyVersion(String eVersion) {
		String aVersion = version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}

	public void clickClose() {
		closeBTN.click();
	}

	public void logout() {
		logout.click();
	}
}
