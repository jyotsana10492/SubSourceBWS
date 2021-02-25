package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.WebDriverUtil;

public class NewCompanyDeatilsPage {
	@FindBy(xpath = "//input[@formcontrolname='CompanyName']")
	WebElement company_Name;

	@FindBy(xpath = "//input[@class='ui-inputtext ui-corner-all ui-state-default ui-widget']")
	WebElement eIN;

	@FindBy(xpath = "//input[@formcontrolname='AddressLine1']")
	WebElement address1;

	@FindBy(xpath = "//input[@formcontrolname='AddressLine2']")
	WebElement address2;

	@FindBy(xpath = "//input[@formcontrolname='City']")
	WebElement city;

	@FindBy(css = "select[formcontrolname='StateID']")
	WebElement drop_Down;

	@FindBy(xpath = "//input[@formcontrolname='ZipCode']")
	WebElement zip_Code;

	@FindBy(xpath = "//input[@formcontrolname='ContactNo']")
	WebElement contact_Number;

	@FindBy(xpath = "//input[@formcontrolname='CompanyHREmailID']")
	WebElement e_mail;

	@FindBy(xpath = "//input[@formcontrolname='PayrollID']")
	WebElement pay_roll_Id;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement save_Button;

	WebDriver driver;

	public NewCompanyDeatilsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_Company_name(String companyName) {
		company_Name.sendKeys(companyName);
	}

	public void enter_EIN(String number) {
		WebDriverUtil.waitForElementVisiblity(eIN);
		WebDriverUtil.passTheValueUsingJavaScript(eIN,number);
		eIN.click();
	}

	public void enter_Address(String address) {
		address1.sendKeys(address);
	}

	public void enter_Address2(String address1) {
		address2.sendKeys(address1);
	}

	public void enter_City(String City) {
		city.sendKeys(City);
	}

	public void select_drop_Down(String text) throws InterruptedException {
		WebDriverUtil.waitForElementVisiblity(drop_Down);
		WebDriverUtil.selectText(drop_Down, text);
	}

	public void enter_Zip_Code(String code) {
		zip_Code.sendKeys(code);
	}

	public void enter_Contact_Number(String number) {
		WebDriverUtil.waitForElementVisiblity(contact_Number);
		contact_Number.sendKeys(number);
	}

	public void enter_Email(String mail) {
		e_mail.sendKeys(mail);
	}

	public void enter_Pay_Roll(String payRoll) {
		pay_roll_Id.sendKeys(payRoll);
	}

	public void click_Save_Button() {
		save_Button.click();
	}

}
