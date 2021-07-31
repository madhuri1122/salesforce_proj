package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactDeletePage;
import pages.LoginPage;

public class ContactDeleteStep 
{
	LoginPage lp = new LoginPage();
	ContactDeletePage cdp = new ContactDeletePage();
	@Given("^User is on salesforce Dashboard page$")
    public void user_is_on_salesforce_dashboard_page() throws Throwable 
	{
        lp.isHomeDisplyed();
    }
	 @And("^Click on Contacts$")
	 public void click_on_contacts() throws Throwable 
	 {
	      cdp.clickOnContacts();  
	 }
	 @And("^Recently viewed contacts page will appear$")
	 public void recently_viewed_contacts_page_will_appear() throws Throwable 
	 {
	        cdp.isAllContactsVisible();
	 }
	 @And("^Cross check lead which is Converted As Contact$")
	 public void cross_check_lead_which_is_converted_as_contact() throws Throwable 
	 {
	        
	 }

     @When("^click on Triangle  for options$")
     public void click_on_triangle_for_options() throws Throwable 
     {
        cdp.readContTable();
     }
     @And("^Options will display$")
     public void options_will_display() throws Throwable 
     {
         cdp.isOptionsVisible();
     }
     @And("^click on Delete Option$")
     public void click_on_delete_option() throws Throwable 
     {
         cdp.clickOnDelete();
     }
     @And("^It will ask again Delete Contact for conirmation$")
     public void it_will_ask_again_delete_contact_for_conirmation() throws Throwable 
     {
         cdp.isDeleteContactConformatioVisible();
     }
     @And("^click on Delete button$")
     public void click_on_delete_button() throws Throwable 
     {
         cdp.clickOnDeleteButton();
     }

    @Then("^Contact Deleted status will appear$")
    public void contact_deleted_status_will_appear() throws Throwable 
    {
        cdp.isContactDeleted();
    }

   

    

    

    

    

    

    


}
