package Parallel;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import com.pages.AccountSettings;
import com.pages.NewShopDeatilsPage;
import com.pages.ShopDetailsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopTest
	{
		WebDriver driver;
		ShopDetailsPage shop_Details;
		JSONFileClass file;
		JSONObject user;
		String company;
		AccountSettings account;
		ApplicationHooks base;
		NewShopDeatilsPage new_Shop_Details;
		
		@Given("user navigate to the Shop page")
		public void user_navigate_to_the_shop_page() throws InterruptedException
			{
				account=new AccountSettings(DriverFactory.getDriver());
				account.click_Shop();
				shop_Details = new ShopDetailsPage(DriverFactory.getDriver());
				shop_Details.click_Toggle_Button();
				shop_Details.click_AddNew();
			}
	
		@When("user enter the valid creadentails Of Shop page")
		public void user_enter_the_valid_creadentails_of_shop_page() throws IOException, ParseException, InterruptedException 
			{
				new_Shop_Details=new NewShopDeatilsPage(DriverFactory.getDriver());
				file = new JSONFileClass();
				user = file.readJson();
				JSONArray userLogInArray = (JSONArray) user.get("shopDetails");
				
				for (int i = 0; i < userLogInArray.size(); i++) 
					{
						JSONObject details = (JSONObject) userLogInArray.get(i);
						company = (String) details.get("shop");
						new_Shop_Details.enterShop((String) details.get("shop"));
						new_Shop_Details.enterEmail((String)details.get("email"));
						new_Shop_Details.select_Region((String) details.get("region"));
						new_Shop_Details.processHiring();
						new_Shop_Details.automate_BGC();
						new_Shop_Details.automate_Food_Cost();
						new_Shop_Details.store_24_Hours();
						new_Shop_Details.automate_Payroll_Hours();
						new_Shop_Details.enterAddress1((String) details.get("address1"));
						//new_Shop_Details.enterAddress2((String) details.get("address2"));
						new_Shop_Details.enterCity((String) details.get("city"));
						new_Shop_Details.stateDropDown((String) details.get("state"));
						new_Shop_Details.enterZipoCode((String) details.get("zipCode"));
						new_Shop_Details.enterRent((String) details.get("rent"));
						new_Shop_Details.enterAddress1((String) details.get("cost"));
						new_Shop_Details.foodCostDistributorDropDown((String) details.get("food_Cost_Distributor"));
						new_Shop_Details.companyIDDropDown((String) details.get("company"));
						new_Shop_Details.enterNewHire((String) details.get("new_Hire"));
					}
			}
		
		@And("^click on Shop page Save Button$")
		public void click_on_shop_page_save_button() throws Throwable
			{
				new_Shop_Details.click_Save_Button();
			}
	
		@Then("^user delete the Shop from subsource$")
		public void user_delete_the_shop_from_subsource() throws Throwable 
			{
					shop_Details.delete(company);
					Thread.sleep(2000);
			}
	
	}
