package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.factory.WebDriverUtil;

public class ShopDetailsPage 
	{
		@FindBy(css = "button[class = 'btn dropdown-toggle act']")
		WebElement toggle_Button;
	
		@FindBy(xpath = "//*[@id='accordion']/li[2]/div/ul/li[1]/a")
		WebElement add_New_Button;
		
		@FindBy(xpath = "//span[@class = 'ui-button-icon-left ui-clickable pi pi-check']")
		WebElement delete_Button;
		
		WebDriver driver;
		
		public ShopDetailsPage(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
	
		public void click_Toggle_Button() throws InterruptedException
			{
				WebDriverUtil.waitForElementStatus(toggle_Button);
				WebDriverUtil.waitForElementJavaScript(toggle_Button);
			}
	
		public void click_AddNew() throws InterruptedException 
			{
				WebDriverUtil.waitForElementVisiblity(add_New_Button);
				add_New_Button.click();
			}
	
		public void delete(String Shop) throws InterruptedException 
			{
				WebElement element = driver.findElement(By.xpath("//a[text() ='" + Shop + "']/parent::span/parent::div/following::td[9]"));
				WebDriverUtil.waitForElementVisiblity(element);
				element.click();
				delete_Button.click();
			}
	}
