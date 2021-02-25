package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.factory.WebDriverUtil;

public class CompanyDetailsPage 
	{
		@FindBy(xpath = "//i[@class='fa fa-ellipsis-v']")
		WebElement toggle_Button;
		
		@FindBy(xpath = "//a[contains(text(),'Add New')]")
		WebElement add_New;
		
		@FindBy(xpath = "//button[@type='button']/span[contains(text(),'Yes')]/parent::button")
		WebElement delete_Button;
		
		@FindBy(xpath = "//div[@class='ui-growl-message']")
		WebElement successfull_Message;
		
		@FindBy(xpath = "//div[@class='ui-growl-icon-close pi pi-times']")
		WebElement successfull_Delete_Message;
		
		WebDriver driver;
		
		public CompanyDetailsPage(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
		
		public void clickon_ToggleButton() throws InterruptedException 
			{
				WebDriverUtil.waitForElementStatus(toggle_Button);
				WebDriverUtil.waitForElementJavaScript(toggle_Button);
			}
	
		public void add_NewEmployee() throws InterruptedException 
			{
				WebDriverUtil.waitForElementStatus(add_New);
				WebDriverUtil.waitForElementJavaScript(add_New);
	
			}
	
		public void findElementUsingText(String searccompany_Name) 
			{
				WebElement company_Name = driver.findElement(
						By.xpath("//a[contains(text(),'" + searccompany_Name + "')]/parent::div/following::td[6]"));
				company_Name.click();
			}
	
		public void click_delete_Button() 
			{
				WebDriverUtil.waitForElementVisiblity(delete_Button);
				delete_Button.click();
			}
	
		public void text_Of_Success_Message()
			{
				System.out.println("Success full message : " + successfull_Message.getText());
			}
	
		public void successfull_Delete() 
			{
				WebDriverUtil.waitForElementVisiblity(successfull_Delete_Message);
				successfull_Delete_Message.click();
			}
	
	}
