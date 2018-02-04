package database;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindInfoOnWebPage {

	private WebDriver driver;

	By nameField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[1]/h4");
	By emailField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]");
	By phoneField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[2]/td[2]");
	By skypeField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[3]/td[2]");
	By unitField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[1]/td[2]");
	By locationField = By.cssSelector(".ng-binding");
	By countryField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[3]/td[2]");
	By cityField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[4]/td[2]");
	By officceField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[5]/td[2]");
	By specializationField = By
			.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[3]/td[2]");
	By workStationField = By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[6]/td[2]");
	By commentField = By.cssSelector(".ng-binding");

	public FindInfoOnWebPage(WebDriver driver) {
		this.driver = driver;
	}

	public By getNameField() {
		return nameField;
	}

	public FindInfoOnWebPage setName(String name) {
		driver.findElement(nameField).sendKeys(name);
		return this;
	}

	public By getEmailField() {
		return emailField;
	}

	public FindInfoOnWebPage setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
		return this;
	}

	public By getPhoneField() {
		return phoneField;
	}

	public FindInfoOnWebPage setPhone(String phone) {
		driver.findElement(phoneField).sendKeys(phone);
		return this;
	}

	public By getSkypeField() {
		return skypeField;
	}

	public FindInfoOnWebPage setSkype(String skype) {
		driver.findElement(skypeField).sendKeys(skype);
		return this;
	}

	public By getUnitField() {
		return unitField;
	}

	public FindInfoOnWebPage setUnit(String unit) {
		driver.findElement(unitField).sendKeys(unit);
		return this;
	}

	public By getLocationField() {
		return locationField;
	}

	public FindInfoOnWebPage setLocation(String location) {
		driver.findElement(locationField).sendKeys(location);
		return this;
	}

	public By getCountryField() {
		return countryField;
	}

	public FindInfoOnWebPage setCountry(String country) {
		driver.findElement(countryField).sendKeys(country);
		return this;
	}

	public By getCityField() {
		return cityField;
	}

	public FindInfoOnWebPage setCity(String city) {
		driver.findElement(cityField).sendKeys(city);
		return this;
	}

	public By getOfficceField() {
		return officceField;
	}

	public FindInfoOnWebPage setOfficceField(String officce) {
		driver.findElement(officceField).sendKeys(officce);
		return this;
	}

	public By getSpecializationField() {
		return specializationField;
	}

	public FindInfoOnWebPage setSpecializationField(String specialization) {
		driver.findElement(specializationField).sendKeys(specialization);
		return this;
	}

	public By getWorkStationField() {
		return workStationField;
	}

	public FindInfoOnWebPage setWorkStationField(String workStation) {
		driver.findElement(workStationField).sendKeys(workStation);
		return this;
	}

	public By getCommentField() {
		return commentField;
	}

	public FindInfoOnWebPage setCommentField(String comment) {
		driver.findElement(commentField).sendKeys(comment);
		return this;
	}

}
