package databasetests;

import java.sql.Connection;
import java.sql.SQLException;
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

import database.FindInfoInDB;
import database.FindInfoOnWebPage;

public class TestProfilWithDB {
	private WebDriver driver;
	FindInfoOnWebPage pageUI;
	FindInfoInDB pageDB;
	Connection getConnection;

	@BeforeClass
	public void setupProfile() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://86.57.161.116:10008/#/login");
		driver.manage().window().maximize();
		WebElement usernameField = driver.findElement(By.cssSelector("#logininput"));
		usernameField.sendKeys("vasya");
		WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
		passwordField.sendKeys("empl");
		WebElement rememberButtom = driver.findElement(By.cssSelector("#checkboxesRemember-0"));
		rememberButtom.click();
		WebElement loginButtom = driver.findElement(By.cssSelector("#buttonLogin"));
		loginButtom.click();
		try {
			WebElement menuUser = (new WebDriverWait(driver, 10)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")));
			System.out.println("Login is correct");
			menuUser.click();
			WebElement profilButtom = driver
					.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/ul/li[1]"));
			profilButtom.click();
		} catch (NoSuchElementException e) {
			System.out.println("No such element");
			System.out.println("Login failed");
			WebElement clearFieldButtom = driver.findElement(By.cssSelector("#buttonReset"));
			clearFieldButtom.click();
		}
	}

	@Test
	public void emailValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement emailField = driver.findElement(pageUI.getEmailField());
		if (emailField.getText().equals(pageDB.getEmail())) {
			System.out.println("Emails are equal");
		} else {
			System.out.println("Emails are not equal");
		}
	}

	@Test
	public void nameValidationByFirstName() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement nameField = driver.findElement(pageUI.getNameField());
		if (nameField.getText().contains(pageDB.getName())) {
			System.out.println("First names are equal");
		} else {
			System.out.println("First names are not equal");
		}
	}

	@Test
	public void nameValidationByLastName() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement nameField = driver.findElement(pageUI.getNameField());
		if (nameField.getText().contains(pageDB.getName2())) {
			System.out.println("Last names are equal");
		} else {
			System.out.println("Last are not equal");
		}
	}

	@Test
	public void phoneValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement phoneField = driver.findElement(pageUI.getPhoneField());
		if (phoneField.getText().equals(pageDB.getPhone())) {
			System.out.println("Phones are equal");
		} else {
			System.out.println("Phones are not equal");
		}
	}

	@Test
	public void skypeValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement skypeField = driver.findElement(pageUI.getSkypeField());
		if (skypeField.getText().equals(pageDB.getSkype())) {
			System.out.println("Skypes are equal");
		} else {
			System.out.println("Skypes are not equal");
		}
	}

	@Test
	public void unitValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement unitField = driver.findElement(pageUI.getUnitField());
		if (unitField.getText().equals(pageDB.getUnit())) {
			System.out.println("Units are equal");
		} else {
			System.out.println("Units are not equal");
		}
	}

	@Test
	public void locationValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement locationField = driver.findElement(pageUI.getLocationField());
		if (locationField.getText().equals(pageDB.getLocation())) {
			System.out.println("Locations are equal");
		} else {
			System.out.println("Locations are not equal");
		}
	}

	@Test
	public void countryValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement countryField = driver.findElement(pageUI.getCountryField());
		if (countryField.getText().equals(pageDB.getCountry())) {
			System.out.println("Countries are equal");
		} else {
			System.out.println("Countries are not equal");
		}
	}

	@Test
	public void cityValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement cityField = driver.findElement(pageUI.getCityField());
		if (cityField.getText().equals(pageDB.getCity())) {
			System.out.println("Cities are equal");
		} else {
			System.out.println("Cities are not equal");
		}
	}

	@Test
	public void officeValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement officceField = driver.findElement(pageUI.getOfficceField());
		if (officceField.getText().equals(pageDB.getOfficce())) {
			System.out.println("Offices are equal");
		} else {
			System.out.println("Offices are not equal");
		}
	}

	@Test
	public void specializationValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement specializationField = driver.findElement(pageUI.getSpecializationField());
		if (specializationField.getText().equals(pageDB.getSpecialization())) {
			System.out.println("Specializations are equal");
		} else {
			System.out.println("Specializations are not equal");
		}
	}

	@Test
	public void workstationValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement workstationField = driver.findElement(pageUI.getWorkStationField());
		if (workstationField.getText().equals(pageDB.getWorkStation())) {
			System.out.println("Workstations are equal");
		} else {
			System.out.println("Workstations are not equal");
		}
	}

	@Test
	public void commentValidation() throws SQLException {
		pageUI = new FindInfoOnWebPage(driver);
		pageDB = new FindInfoInDB();
		WebElement commentField = driver.findElement(pageUI.getCommentField());
		if (commentField.getText().equals(pageDB.getComment())) {
			System.out.println("Comments are equal");
		} else {
			System.out.println("Comments are not equal");
		}
	}

	@AfterClass
	public void closeWindow() {
		driver.quit();
	}
}
