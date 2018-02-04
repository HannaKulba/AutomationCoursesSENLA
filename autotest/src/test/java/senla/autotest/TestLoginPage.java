package senla.autotest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginPage {
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
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement rememberButtom = driver.findElement(By.id("checkboxesRemember-0"));
		rememberButtom.click();
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		try {
				WebElement someElement = (new WebDriverWait(driver, 20))
						.until(ExpectedConditions.elementToBeClickable(By.className("navbar-header")));
				System.out.println("Login is successful");
				WebElement menuUser = driver
						.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a"));
				menuUser.click();
				WebElement logoutButtom = driver
						.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/ul/li[3]"));
				logoutButtom.click();
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
				System.out.println("Login failed");
				WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
				clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameOnRussian() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("василий");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username is on Russian");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameOnEnglish() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("sanya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username is not found for this password");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void icorrectUsernameWithNumbers() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("123456");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username consists only numbers");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameWithSymbols() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("-=+//%@");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username consists only symbols");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameOnEngWithSymbAndNumb() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("hanna%%-+2017");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username contains numbers and symbols");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordOnRussian() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("пароль");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Password is INCORRECT: password is on Russian");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordOnEnglish() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("passnmi");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Password is INCORRECT: username is not found for this password");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordWithSymbols() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("**()=_$");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Password is INCORRECT: username consists only symbols");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordWithNumbers() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("123456");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {

			System.out.println("Password is INCORRECT: username consists only numbers");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordOnEngWithSymbAndNumb() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("test_-@123456");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {

			System.out.println("Password is INCORRECT: username contains symbols and numbers");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameByCapsLock() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("VASYA");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username entered by Caps Lock");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordByCapsLock() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("EMPL");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Password is INCORRECT: password entered by Caps Lock");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameByCapsLockFirstLetter() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("Vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {

			System.out.println("Login is INCORRECT: the first letter of username entered by Caps Lock");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameIsEmpty() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username field is empty");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordIsEmpty() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Password is INCORRECT: password field is empty");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordAndUsernameAreEmpty() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login and password are INCORRECT: username and password fields are empty");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameSpace() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("    ");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username field contains only space");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectPasswordSpace() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("    ");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Password is INCORRECT: password field contains only space");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameAndPasswordSpace() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("    ");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("    ");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login and password are INCORRECT: username and password fields contain only space");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceBefore() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys(" vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username field contains space before login");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceInTheMiddle() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("va sya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username field contains space in the middle of login");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void incorrectUsernameWithSpaceInTheEnd() {
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya ");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		if (driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/vacation")) {
			try {
				WebElement someElement = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By.className("navbar-header")));
				System.out.println("Login is successful");
			} catch (NoSuchElementException e) {
				System.out.println("No such element");
			}
		} else {
			System.out.println("Login is INCORRECT: username field contains space in the end of login");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@AfterClass
	public void closeWindow() {
		driver.quit();
	}
}
