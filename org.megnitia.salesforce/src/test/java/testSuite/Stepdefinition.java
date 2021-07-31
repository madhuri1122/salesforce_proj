package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.NewLeadFormPage;
//login
public class Stepdefinition 
{
	LoginPage lp;
	HomePage hp;
	NewLeadFormPage nlhp;
	@Given("^user is on salseforce dashboard page$")
    public void user_is_on_salseforce_dashboard_page() throws Throwable 
	{
		//lp = new LoginPage();
		//lp.validateurl();
		//lp.uidFill();
		//lp.pwdFill();
		//lp.clicklogintbn();
		//lp.isHomeDisplyed();
        
    }

    @When("^click lead object and click new lead$")
    public void click_lead_object_and_click_new_lead() throws Throwable 
    {
    	hp = new HomePage();
        hp.clickLeads();
        hp.isLeadsVisible();
        hp.clickNew();
        
    }

    @Then("^lead form should be displayed$")
    public void lead_form_should_be_displayed() throws Throwable 
    { 
    	hp =new HomePage();
    	hp.isNewleadFormDisplyed();
    	
    }
    
    
    
   //create new lead 
    @Given("^user is on load form page$")
    public void user_is_on_load_form_page() throws Throwable 
    {
    	hp =new HomePage();
    	hp.isNewleadFormDisplyed(); 
    }

    @When("^enter firstName as \"([^\"]*)\" middliName as \"([^\"]*)\" lastName as \"([^\"]*)\" salutation as \"([^\"]*)\" website as \"([^\"]*)\" sufix as \"([^\"]*)\" Company as \"([^\"]*)\" Email as \"([^\"]*)\" MobilePhone as \"([^\"]*)\" industry as \"([^\"]*)\" Leadsource as \"([^\"]*)\" details to fill$")
    public void fillLeadForm(String firstname, String middlename, String lastname, String salutation, String website, String sufix, String company, String email, String mobilephone, String industry, String leadsource) throws Throwable 
    {
    	nlhp = new NewLeadFormPage();
    	nlhp.fillFirstName(firstname);
    	nlhp.fillMiddleName(middlename);
    	nlhp.fillLastName(lastname);
    	nlhp.fillSufix(sufix);
    	nlhp.fillWebSite(website);
    	nlhp.fillCompany(company);
    	nlhp.fillEmail(email);
    	nlhp.fillMobilePhone(mobilephone);
    	nlhp.fillSalutation(salutation);
    	//nlhp.fillSalutation(salutation);
    	nlhp.Selectindustry(industry);
    	nlhp.SelectLeadsource(leadsource);
    }

    
    @And("^click save$")
    public void click_save() throws Throwable 
    {
    	nlhp = new NewLeadFormPage();
    	nlhp.clickSave();
    }
    @Then("^new lead should be created$")
    public void new_lead_should_be_created() throws Throwable 
    { 
    	nlhp = new NewLeadFormPage();
        nlhp.isnewleadcreated();
    }
    
    
    
    //select required lead to edit
    @Given("^User is on Leads section$")
    public void user_is_on_leads_section() throws Throwable 
    {
    	hp = new HomePage();
        hp.clickLeads();
    }

    @When("^Click on Recently viewed$")
    public void click_on_recently_viewed() throws Throwable 
    { 
    	nlhp = new NewLeadFormPage();
    	nlhp.clickOnRecenltyViewed();
    	
        
    }
    @And("^Click on Todays Leads in the list$")
    public void click_on_todays_leads_in_the_list() throws Throwable 
    {
    	nlhp = new NewLeadFormPage();
    	nlhp.toDaysLeads();
    }
    @And("^click on required lead$")
    public void click_on_required_lead() throws Throwable 
    {
        nlhp=new NewLeadFormPage();
        nlhp.clickOnRequredLead();
    }

    @Then("Requred Lead details will be opend")
    public void required_lead_will_be_open() throws Throwable 
    {
    	
        
    }
    
    
    
    //edit lead
    @Given("^User is on present saved Lead details page$")
    public void user_is_on_present_saved_lead_details_page() throws Throwable 
    { 
    	nlhp = new NewLeadFormPage();
        nlhp.isnewleadcreated();
        
    }
    @And("^click on Edit$")
    public void click_on_edit() throws Throwable 
    {
    	nlhp = new NewLeadFormPage();
    	nlhp.editLead();
    	nlhp.isEditLead_displyed();
        
    }
    @And("^change phoneNumber as per \"([^\"]*)\"$")
    public void change_phone_number_as_per_something(String newmobilenumber) throws Throwable 
    {
    	nlhp = new NewLeadFormPage();
    	nlhp.edit_lead_mobilenumber(newmobilenumber);
    }
    @When("^click Save_button$")
    public void click_savebutton() throws Throwable 
    {
    	nlhp = new NewLeadFormPage();
    	nlhp.clickSaveOfterEdit();
    }
    @Then("^mobile number upated$")
    public void mobile_number_upated() throws Throwable 
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.isEditLeadSved();
    }
    
    //convert lead to contact
    @Given("^user is on present saved Lead Details page$")
    public void user_is_on_present_saved_lead_details_page1() throws Throwable 
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.isEditLeadSved();
    }
    @And("^clickChatter$")
    public void clickchatter() throws Throwable 
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.clickOnChatter();
    }
    @And("click on share")
    public void click_on_share() throws Exception
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.sendupdate();
    }
    @And("send update about lead {string}")
    public void share_on_update_about_lead_something(String update) throws Throwable 
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.clickshareupdatetxt(update);
    	
    	
    }
    @And("click on finalshare")
    public void click_on_finalshare() throws Exception
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.clickfinalshare();
    }
    @And("^click on MarkStatus$")
    public void click_on_markstatus() throws Throwable 
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.clickOnMarkStatus();
    }
    @Then("^Convert lead form will displayed$")
    public void convert_lead_form_will_displayed() throws Throwable 
    {
    	//nlhp=new NewLeadFormPage();
    	//nlhp.isConvertLeadDisplayed();
    }

    @When("^click on Conver button$")
    public void click_on_conver_button() throws Throwable 
    {
    	
    	nlhp=new NewLeadFormPage();
    	nlhp.clickOnConvert();
    }
    @And("^click on Goto Leads button$")
    public void click_on_goto_leads_button() throws Throwable 
    {
    	nlhp=new NewLeadFormPage();
    	nlhp.clickOnGotoLead();
    }

    @Then("^Recently viewed lead page will appear$")
    public void recently_viewed_lead_page_will_appear() throws Throwable 
    {
        
    }
    
    

    





    

    


    


    

    
    


    
    

   

    

    



}
