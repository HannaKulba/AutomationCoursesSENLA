package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginInPageObject {
	private WebDriver driver;

	By usernameField = By.cssSelector("#logininput");
	By passwordField = By.cssSelector("#passwordinput");
	By rememberMeButtom = By.cssSelector("#checkboxesRemember-0");
	By loginButtom = By.cssSelector("#buttonLogin");
	By clearButtom = By.cssSelector("#buttonReset");
	By logoutButtom = By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/ul/li[3]");

	public LoginInPageObject(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals("http://86.57.161.116:10008/#/login")) {
			throw new IllegalStateException("This is not the login page");
		}
	}

	public LoginInPageObject setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
		return this;
	}

	public LoginInPageObject setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		return this;
	}

	public LoginInPageObject clickRememberMeButtom() {
		driver.findElement(rememberMeButtom).click();
		return this;
	}

	public LoginInPageObject clickLoginButtom() {
		driver.findElement(loginButtom).click();
		return this;
	}

	public LoginInPageObject clickClearButtom() {
		driver.findElement(clearButtom).click();
		return this;
	}
	
	public LoginInPageObject clickLogOutButtom() {
		driver.findElement(logoutButtom).click();
		return this;
	}

	public void loginUser(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickRememberMeButtom();
		this.clickLoginButtom();
	}

	public void conditionSearchElementAfterLogin() {
		try {
			WebElement menuUser = (new WebDriverWait(driver, 20)).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")));
			System.out.println("Login is successful");
			menuUser.click();
			this.clickLogOutButtom();
		} catch (NoSuchElementException e) {
			System.out.println("No such element");
			System.out.println("Login failed");
			this.clickClearButtom();
		}
	}
}
