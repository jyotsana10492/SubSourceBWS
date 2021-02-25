package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.factory.WebDriverUtil;

public class AccountSettings 
	{
		@FindBy(xpath = "//h2[contains(text(),'Company')]")
		WebElement company_Link;
		
		@FindBy(xpath = "//h2[contains(text(),'Shops')]")
		WebElement shop_Link;
		
		WebDriver driver;
		
		public AccountSettings(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
	
		public void clickon_company() throws InterruptedException
			{
				WebDriverUtil.waitForElementStatus(company_Link);
				WebDriverUtil.waitForElementJavaScript(company_Link);
			}
	
		public void click_Shop() throws InterruptedException 
			{
				WebDriverUtil.waitForElementStatus(shop_Link);
				WebDriverUtil.waitForElementJavaScript(shop_Link);
			}
	}
