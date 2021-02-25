package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.factory.WebDriverUtil;

public class NewShopDeatilsPage 
	{
		@FindBy(css = "input[formcontrolname = 'DisplayStoreNumber']")
		WebElement shop_Text;
	
		@FindBy(css = "input[formcontrolname = 'EmailID']")
		WebElement email_Text;
		
		@FindBy(css = "select[formcontrolname = 'RegionID']")
		WebElement region_Drop_Down;
	
		@FindBy(xpath = "//p-inputswitch[@name = 'isElectronicHiring']/div/span")
		WebElement process_Hiring_Slider;
	
		@FindBy(xpath = "//p-inputswitch[@name = 'isAutomateBGC']/div/span")
		WebElement automate_BGC_Slider;
		
		@FindBy(xpath = "//p-inputswitch[@name = 'isAutomateFoodCost']/div/span")
		WebElement automate_Food_Cost_Slider;
	
		@FindBy(xpath = "//p-inputswitch[@name = 'is24Hours']/div/span")
		WebElement store_24_Hours_Slider;
		
		@FindBy(xpath = "//p-inputswitch[@name = 'isPayrollHours']/div/span")
		WebElement automate_Payroll_Hours_Slider;
		
		@FindBy(css = "input[formcontrolname = 'AddressLine1']")
		WebElement address_Text1;
	
		@FindBy(css = "input[formcontrolname = 'AddressLine2']")
		WebElement address_Text2;
	
		@FindBy(css = "input[formcontrolname = 'City']")
		@CacheLookup
		WebElement city_Text;
		
		@FindBy(css = "select[formcontrolname = 'StateID']")
		WebElement state_Drop_Down;
		
		@FindBy(css = "input[formcontrolname = 'ZipCode']")
		@CacheLookup
		WebElement zip_Text;
	
		@FindBy(css = "input[formcontrolname = 'RentRoyality']")
		@CacheLookup
		WebElement rent_Text;
	
		@FindBy(css = "input[formcontrolname = 'Cost']")
		@CacheLookup
		WebElement cost_Text;
		
		@FindBy(css = "select[formcontrolname = 'DistributorID']")
		WebElement food_Cost_Distributor_Drop_Down;
		
		@FindBy(css = "select[formcontrolname = 'CompanyID']")
		WebElement company_ID_Drop_Down;
		
		@FindBy(xpath = "//tag-input[@id = 'New Hire']/div/div/tag-input-form/form/input")
		WebElement new_Hire_Email;
		
		@FindBy(xpath = "//tag-input[@id = 'Weekly Schedule']/div/div/tag-input-form/form/input")
		WebElement weekly_Schedule_Email;
		
		@FindBy(xpath = "//tag-input[@id = 'Engagement']/div/div/tag-input-form/form/input")
		WebElement engagement_Email;
		
		@FindBy(xpath = "//tag-input[@id = 'BGC']/div/div/tag-input-form/form/input")
		WebElement BGC_Email;
		
		@FindBy(xpath = "//tag-input[@id = 'E-Verify']/div/div/tag-input-form/form/input")
		WebElement E_Verify_Email;
		
		@FindBy(xpath = "//tag-input[@id = 'Applicant']/div/div/tag-input-form/form/input")
		WebElement applicant_Email;
		
		@FindBy(css = "button[class = 'btn-custom orange-button ng-star-inserted']")
		WebElement save_Button;
	
		@FindBy(xpath = "//div[@class='ui-growl-message']")
		WebElement message;
	
		WebDriver driver;
		
		public NewShopDeatilsPage(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
		
		public void enterShop(String shop) 
			{
				shop_Text.sendKeys(shop);
			}
	
		public void enterEmail(String email) 
			{
				email_Text.sendKeys(email);
			}
	
		public void select_Region(String region) throws InterruptedException
			{
				WebDriverUtil.selectText(region_Drop_Down, region);
			}
		
		public void processHiring() 
			{
				process_Hiring_Slider.click();
			}
	
		public void automate_BGC() 
			{
				automate_BGC_Slider.click();
			}
	
		public void automate_Food_Cost()
			{
				automate_Food_Cost_Slider.click();
			}
	
		public void store_24_Hours() 
			{
				store_24_Hours_Slider.click();
			}
		
		public void automate_Payroll_Hours() 
			{
				automate_Payroll_Hours_Slider.click();
			}
		
		public void enterAddress1(String address1)
			{
				address_Text1.sendKeys(address1);
			}
		
		public void enterAddress2(String address2)
			{
				address_Text2.sendKeys(address2);
			}
		
		public void enterCity(String city) 
			{
				city_Text.sendKeys(city);
			}
		
		public void stateDropDown(String state) 
			{
				WebDriverUtil.selectText(state_Drop_Down, state);
			}
		
		public void enterZipoCode(String zip) 
			{
				zip_Text.sendKeys(zip);
			}
		
		public void enterRent(String rent)
			{
				rent_Text.clear();
				rent_Text.sendKeys(rent);
			}
		
		public void enterCost(String cost) 
			{
				cost_Text.clear();
				cost_Text.sendKeys(cost);
			}
		
		public void foodCostDistributorDropDown(String food) 
			{
				WebDriverUtil.selectText(food_Cost_Distributor_Drop_Down, food);
			}
		
		public void companyIDDropDown(String id) 
			{
				WebDriverUtil.selectText(company_ID_Drop_Down, id);
			}
		
		public void enterNewHire(String email) 
			{
				new_Hire_Email.sendKeys(email);
			}
		
		public void enterWeeklyScheduleEmail(String email) 
			{
				weekly_Schedule_Email.sendKeys(email);
			}
		
		public void enterEngagementEmail(String email)
			{
				engagement_Email.sendKeys(email);
			}
		
		public void enterBGCEmail(String email) 
			{
				BGC_Email.sendKeys(email);
			}
		
		public void enterE_Verify(String email)
			{
				E_Verify_Email.sendKeys(email);
			}
		
		public void click_Save_Button() 
			{
				save_Button.click();
			}
	
	}
