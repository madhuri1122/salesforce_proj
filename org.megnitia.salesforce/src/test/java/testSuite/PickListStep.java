package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PickListPage;

public class PickListStep 
{
	PickListPage plp = new PickListPage();
	LoginPage lp = new LoginPage();
	
	@Given("^User is on salesforce dashboard page$")
    public void user_is_on_salesforce_dashboard_page() throws Throwable 
	{
		lp.isHomeDisplyed();
    }
	@And("^click on Setup symbol$")
    public void click_on_setup_symbol() throws Throwable 
	{ 
		//plp.clickonGearSymbol();
        plp.clickOnSetupSymbol();
        
    }
	@And("^click on Setup button$")
    public void click_on_setup_button() throws Throwable 
	{
		plp.clickOnSetupbutton();
    }
	@And("^It should navigate to Setup Home page$")
    public void it_should_navigate_to_setup_home_page() throws Throwable 
	{
        plp.isNavigateToSetupHomePage();
    }

    @When("^Click on Object Manager$")
    public void click_on_object_manager() throws Throwable 
    {
        plp.clickOnObjectManager();
        
    }
    @And("^It will open New tab with Object Managet Title$")
    public void it_will_open_new_tab_with_object_managet_title() throws Throwable 
    {
        
    }
    @And("^click on Module Which we want to Test$")
    public void click_on_module_which_we_want_to_test() throws Throwable 
    {
        plp.clickOnLeadsInObjectManager();
    }
    @And("^It will disply Module details with with title of module Name$")
    public void it_will_disply_module_details_with_with_title_of_module_name() throws Throwable 
    {
        plp.isDetailsDisplayed();
    }
    @And("^Click on Fields and Relationships$")
    public void click_on_fields_and_relationships() throws Throwable 
    {
        plp.clickOnFieldsAndRelationship();
    }

    @When("^Click on Requred item$")
    public void click_on_requred_item() throws Throwable 
    {
        plp.clickOnIndustryItem();
    }
    @And("^All items in Module will appear here$")
    public void all_items_in_module_will_appear_here() throws Throwable 
    {
        
    }
    @And("^it will Opens with picklist values$")
    public void it_will_opens_with_picklist_values() throws Throwable 
    {
        plp.isFieldInformationIsDisplyed();
    }
    @And("^Read table of list of item values$")
    public void read_table_of_list_of_item_values() throws Throwable 
    {
        plp.getPicklistValues();
        
    }
    
    @And("^close the tab and move to salesforce dashboard page open new lead form$")
    public void close_the_tab_and_move_to_salesforce_dashboard_page_open_new_lead_form() throws Throwable 
    {
    	plp.backToSalesforcedashboard();
    }
    @And("^Read list from Form$")
    public void read_list_from_form() throws Throwable 
    {
        plp.ReadindustryValue();
    }
    @And("^compare both list after Sort$")
    public void compare_both_list_after_sort() throws Throwable 
    {
        plp.comparelist();
    }

    

    

    

    

    

    

   

   

   

    

    

    

    


}
