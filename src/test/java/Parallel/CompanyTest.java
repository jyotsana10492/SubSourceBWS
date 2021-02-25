package Parallel;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import com.pages.AccountSettings;
import com.pages.CompanyDetailsPage;
import com.pages.HomePage;
import com.pages.LogInPage;
import com.pages.NewCompanyDeatilsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanyTest
	{
		WebDriver driver;
		LogInPage logIn;
		JSONFileClass file;
		JSONObject user;
		HomePage home;
		NewCompanyDeatilsPage employee;
		CompanyDetailsPage companyAccount;
		String CompanyName;
		AccountSettings account;
		ApplicationHooks base;
		
		@Given("user navigate to the company page")
		public void user_navigate_to_the_company_page() throws InterruptedException
			{
				
				account=new AccountSettings(DriverFactory.getDriver());
				account.clickon_company();
				companyAccount = new CompanyDetailsPage(DriverFactory.getDriver());
				companyAccount.clickon_ToggleButton();
				companyAccount.add_NewEmployee();
			}
	
		@When("user enter the valid creadentails")
		public void user_enter_the_valid_creadentails() throws IOException, ParseException, InterruptedException 
			{
				employee = new NewCompanyDeatilsPage(DriverFactory.getDriver());
				file = new JSONFileClass();
				user = file.readJson();
				JSONArray userLogInArray = (JSONArray) user.get("companydetails");
				
				for (int i = 0; i < userLogInArray.size(); i++) 
					{
						JSONObject details = (JSONObject) userLogInArray.get(i);
						CompanyName = (String) details.get("companyname");
						employee.enter_Company_name((String) details.get("companyname"));
						employee.enter_EIN((String) details.get("EIN"));
						employee.enter_Address((String) details.get("Address"));
						employee.enter_Address2((String) details.get("Address2"));
						employee.enter_City((String) details.get("City"));
						employee.select_drop_Down((String) details.get("State"));
						employee.enter_Zip_Code((String) details.get("ZipCode"));
						employee.enter_Contact_Number((String) details.get("PhoneNumber"));
						employee.enter_Email((String) details.get("mail"));
						employee.enter_Pay_Roll((String) details.get("payroll"));
					}
		}
	
		@And("^click on Save Button$")
		public void click_on_save_button() throws Throwable 
			{
				employee.click_Save_Button();
			}
	
		@Then("^user delete the company from subsource$")
		public void user_delete_the_company_from_subsource() throws Throwable 
			{
				companyAccount = new CompanyDetailsPage(DriverFactory.getDriver());
				companyAccount.successfull_Delete();
				companyAccount.findElementUsingText(CompanyName);
				companyAccount.click_delete_Button();
				companyAccount.text_Of_Success_Message();
				companyAccount.successfull_Delete();
			}
	}
