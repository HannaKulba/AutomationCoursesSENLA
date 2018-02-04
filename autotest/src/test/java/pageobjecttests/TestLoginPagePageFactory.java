package pageobjecttests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.LoginInPageObject;

public class TestLoginPagePageFactory {
	private WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://86.57.161.116:10008/#/login");
		driver.manage().window().maximize();
	}

	@Test
	public void userloginIsCorrect() {
		LoginInPageObject page = PageFactory.initElements(driver, LoginInPageObject.class);
		page.loginUser("vasya", "empl");
		page.conditionSearchElementAfterLogin();
		}

	@Test
	public void incorrectUsernameWithSpaceBefore() {
		LoginInPageObject page = PageFactory.initElements(driver, LoginInPageObject.class);
		page.loginUser("   vasya", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			page.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains space before login");
			page.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceInTheMiddle() {
		LoginInPageObject page = PageFactory.initElements(driver, LoginInPageObject.class);
		page.loginUser("va    sya", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			page.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains space in the middle of login");
			page.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceInTheEnd() {
		LoginInPageObject page = PageFactory.initElements(driver, LoginInPageObject.class);
		page.loginUser("vasya   ", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			page.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains space in the end of login");
			page.clickClearButtom();
		}
	}
	@AfterClass
	public void closeWindow() {
		driver.quit();
	}
}
