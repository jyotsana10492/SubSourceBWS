package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.factory.WebDriverUtil;

public class HomePage
	{
		@FindBy(xpath = "//a[@class='sidebar-toggle']")
		WebElement home_Page;
		
		@FindBy(xpath = "//span[contains(text(),'Preferences')]")
		WebElement settings;
		
		@FindBy(xpath = "//a[contains(text(),'Account Settings')]")
		WebElement account_Settings;
		
		WebDriver driver;
		
		public HomePage(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
	
		public void Clickon_HomePage() throws InterruptedException 
			{
				WebDriverUtil.waitForElementStatus(home_Page);
				WebDriverUtil.waitForElementJavaScript(home_Page);
			}
	
		public void clickon_Settings() throws InterruptedException 
			{
				WebDriverUtil.waitForElementStatus(settings);
				WebDriverUtil.waitForElementJavaScript(settings);
			}
	
		public void clickon_Account_Settings() throws InterruptedException 
			{
				WebDriverUtil.waitForElementStatus(account_Settings);
				WebDriverUtil.waitForElementJavaScript(account_Settings);
			}
	}
