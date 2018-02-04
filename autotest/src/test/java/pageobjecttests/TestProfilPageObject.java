package pageobjecttests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.LoginInPageObject;

public class TestProfilPageObject {
	private WebDriver driver;
	LoginInPageObject loginIn;

	@BeforeClass
	public void setupProfile() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://86.57.161.116:10008/#/login");
		driver.manage().window().maximize();
		loginIn.loginUser("vasya", "empl");
		loginIn.conditionSearchElementAfterLogin();
		}

	@Test
	public void nameValidation() {
		WebElement nameField = driver.findElement(By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[1]/h4"));
		if (nameField.getText().equals("Vasilij Vasilev")) {
			System.out.println("Name is correct");
		} else {
			System.out.println("Name is INCORRECT");
		}
	}

	@Test
	public void emailValidation() {
		WebElement emailField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]"));
		if (emailField.getText().equals("vasia@mail.ru")) {
			System.out.println("Email is correct");
		} else {
			System.out.println("Email is INCORRECT");
		}
	}

	@Test
	public void phoneValidation() {
		WebElement phoneField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[2]/td[2]"));
		if (phoneField.getText().equals("8-029-2583645")) {
			System.out.println("Phone is correct");
		} else {
			System.out.println("Phone is INCORRECT");
		}
	}

	@Test
	public void skypeValidation() {
		WebElement skypeField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[3]/td[2]"));
		if (skypeField.getText().equalsIgnoreCase("vasia.tut")) {
			System.out.println("Skype is correct");
		} else {
			System.out.println("Skype is INCORRECT");
		}
	}

	@Test
	public void unitValidation() {
		WebElement unitField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[1]/td[2]"));
		if (unitField.getText().equalsIgnoreCase("unit1")) {
			System.out.println("Unit is correct");
		} else {
			System.out.println("Unit is INCORRECT");
		}
	}

	@Test
	public void locationValidation() {
		WebElement locationField = driver.findElement(By.cssSelector(".ng-binding"));
		if (locationField.getText().equalsIgnoreCase("BLR_GRO")) {
			System.out.println("Location is correct");
		} else {
			System.out.println("Location is INCORRECT");
		}
	}

	@Test
	public void countryValidation() {
		WebElement countryField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[2]"));
		if (countryField.getText().equalsIgnoreCase("BLR")) {
			System.out.println("Country is correct");
		} else {
			System.out.println("Country is INCORRECT");
		}
	}

	@Test
	public void cityValidation() {
		WebElement cityField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[4]/td[2]"));
		if (cityField.getText().equalsIgnoreCase("GRO")) {
			System.out.println("City is correct");
		} else {
			System.out.println("City is INCORRECT");
		}
	}

	@Test
	public void officceValidation() {
		WebElement officceField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[5]/td[2]"));
		if (officceField.getText().equals("1")) {
			System.out.println("Officce is correct");
		} else {
			System.out.println("Officce is INCORRECT");
		}
	}

	@Test
	public void calendarValidation() {
		WebElement calendarButtom = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[6]/td[2]/a/span[2]"));
		if (calendarButtom.getText().equalsIgnoreCase("показать календарь")) {
			calendarButtom.click();
			System.out.println("Calendar is correct");
		} else {
			System.out.println("Calendar is INCORRECT");
		}
	}

	@Test
	public void dateOfBirthValidation() {
		WebElement dateOfBirthField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[1]/td[2]"));
		if (dateOfBirthField.getText().equals("")) {
			System.out.println("Date is correct");
		} else {
			System.out.println("Date is INCORRECT");
		}
	}

	@Test
	public void specializationValidation() {
		WebElement specializationField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[2]/td[2]"));
		if (specializationField.getText().equalsIgnoreCase("QA")) {
			System.out.println("Specialization is correct");
		} else {
			System.out.println("Specialization is INCORRECT");
		}
	}

	@Test
	public void dateOfReceiptValidation() {
		WebElement dateOfReceiptField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[3]/td[2]"));
		if (dateOfReceiptField.getText().equalsIgnoreCase("5.02.2018")) {
			System.out.println("Date of receipt is correct");
		} else {
			System.out.println("Date of receipt is INCORRECT");
		}
	}

	@Test
	public void dateOfProbationValidation() {
		WebElement dateOfProbationField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[4]/td[2]"));
		if (dateOfProbationField.getText().equalsIgnoreCase("7.03.2018")) {
			System.out.println("Date of probation is correct");
		} else {
			System.out.println("Date of probation is INCORRECT");
		}
	}

	@Test
	public void probationPeriodPassedValidation() {
		WebElement probationPeriodPassedField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[5]/td[2]"));
		if (probationPeriodPassedField.getText().equalsIgnoreCase("yes")) {
			System.out.println("Probation Period Passed is correct");
		} else {
			System.out.println("Probation Period Passed is INCORRECT");
		}
	}

	@Test
	public void workStationValidation() {
		WebElement workStationField = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[6]/td[2]"));
		if (workStationField.getText().equalsIgnoreCase("wert34etwert53434")) {
			System.out.println("Work station is correct");
		} else {
			System.out.println("Work station is INCORRECT");
		}
	}

	@Test
	public void commentValidation() {
		WebElement commentField = driver.findElement(By.cssSelector(".ng-binding"));
		if (commentField.getText().equalsIgnoreCase("comment3")) {
			System.out.println("Comment is correct");
		} else {
			System.out.println("Comment is INCORRECT");
		}
	}

	@AfterClass
	public void closeWindow() {
		driver.quit();
	}
}
