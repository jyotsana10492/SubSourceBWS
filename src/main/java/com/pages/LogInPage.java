package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage 
	{
		@FindBy(id="inputEmail")
		WebElement txt_Username;
		
		@FindBy(id="inputPassword")
		WebElement txt_Password;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement login;
		
		WebDriver driver;
		
		public LogInPage(WebDriver driver) 
			{
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
		
		public void enterUserName(String username) 
			{
				txt_Username.sendKeys(username);
			}
		
		public void enterPassword(String password) 
			{
				txt_Password.sendKeys(password);
			}
		
		public void clickOnLogin()
			{
				login.click();
			}
	
	}
