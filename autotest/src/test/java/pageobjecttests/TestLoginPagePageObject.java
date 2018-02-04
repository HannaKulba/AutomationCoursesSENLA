package pageobjecttests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.LoginInPageObject;

public class TestLoginPagePageObject {
	private WebDriver driver;
	LoginInPageObject loginIn;

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
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "empl");
		loginIn.conditionSearchElementAfterLogin();
	}

	@Test
	public void incorrectUsernameOnRussian() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("Василий", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username is on Russian");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameOnEnglish() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("sanya", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username is not found for this password");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void icorrectUsernameWithNumbers() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("12343567", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username consists only numbers");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameWithSymbols() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("%^(_&$#", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username consists only symbols");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameOnEngWithSymbAndNumb() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("hanna%%-+2017", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username contains numbers and symbols");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordOnRussian() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "пароль");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: password is on Russian");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordOnEnglish() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "hfhfyruro");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: username is not found for this password");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordWithSymbols() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "*(&^%$#&_");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: username consists only symbols");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordWithNumbers() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "987654");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: username consists only numbers");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordOnEngWithSymbAndNumb() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "yfhfjlk+)(987654");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: username contains symbols and numbers");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameByCapsLock() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("VASYA", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username entered by Caps Lock");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordByCapsLock() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "EMPL");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: password entered by Caps Lock");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameByCapsLockFirstLetter() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("Vasya", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: the first letter of username entered by Caps Lock");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameIsEmpty() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field is empty");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordIsEmpty() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: password field is empty");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordAndUsernameAreEmpty() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("", "");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login and password are INCORRECT: username and password fields are empty");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameSpace() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("    ", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains only space");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectPasswordSpace() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya", "   ");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Password is INCORRECT: password field contains only space");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameAndPasswordSpace() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("     ", "   ");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login and password are INCORRECT: username and password fields contain only space");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceBefore() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser(" vasya", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains space before login");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceInTheMiddle() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("va  sya", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains space in the middle of login");
			loginIn.clickClearButtom();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceInTheEnd() {
		loginIn = new LoginInPageObject(driver);
		loginIn.loginUser("vasya  ", "empl");
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			loginIn.conditionSearchElementAfterLogin();
		} else {
			System.out.println("Login is INCORRECT: username field contains space in the end of login");
			loginIn.clickClearButtom();
		}
	}

	@AfterClass
	public void closeWindow() {
		driver.quit();
	}
}
