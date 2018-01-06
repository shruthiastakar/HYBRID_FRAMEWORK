package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {

	// declaration
	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(name = "pwd")
	private WebElement pwTB;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath = "//span[contains(text(),'invalid')]")
	private WebElement errMsg;

	// initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pwd) {
		pwTB.sendKeys(pwd);
	}

	public void clickLogin() {
		loginBTN.click();
	}

	public void verifyErrMsgIsDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Pass : Error msg is displayed", true);
		} catch (Exception e) {
			Reporter.log("Fail : Error msg is NOT displayed", true);
			Assert.fail();
		}
	}
}
