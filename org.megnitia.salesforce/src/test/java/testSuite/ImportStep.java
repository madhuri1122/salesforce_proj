package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ImportPage;

public class ImportStep 
{ 
	  HomePage hp;
	  ImportPage im;
	 @Given("^user is on Lead section$")
	    public void user_is_on_lead_section() throws Throwable 
	    {
		    hp = new HomePage();
	        hp.clickLeads();
	        hp.isLeadsVisible();
	        
	    }

	    @When("^click on Import it will navigete to Iport your Data into Salesforce page$")
	    public void click_on_import_it_will_navigete_to_iport_your_data_into_salesforce_page() throws Throwable 
	    {
	        im = new ImportPage();
	        im.clickOnImport();
	    }

	    @And("^click on Leads on standard object$")
	    public void click_on_leads_on_standard_object() throws Throwable 
	    {
	    	im = new ImportPage();
	        im.isGetStartedpageVisible();
	        im.clickOnLeadsOnStandardObject();
	        im.isMarkStatusDisplayed();
	    }

	    @And("^click on Add new record$")
	    public void click_on_add_new_record() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.clickOnAddNewRecord();
	    }

	    @And("^click on CSV to uploas csv file$")
	    public void click_on_csv_to_uploas_csv_file() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.clickOncsv();
	    }

	    @And("^click on Choose file$")
	    public void click_on_choose_file() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.clickOnCooseFile();
	    }
	    @And("^CSV file selector box will open$")
	    public void csv_file_selector_box_will_open() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.isfileselectordisplayed();
	    }

	    @And("^Send valid file path into text box$")
	    public void send_valid_file_path_into_text_box() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.automateWindow();
	    }

	    @And("^click on Open button$")
	    public void click_on_open_button() throws Throwable 
	    {
	    	//im = new ImportPage();
	    	//open not required 
	    }

	    @And("^click on Next button$")
	    public void click_on_next_button() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.clickOnNext();
	    }

	    @And("^click on Startimport button$")
	    public void click_on_startimport_button() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.clickOnStartImport();
	    	
	    }
	   
	    @Then("^it will shows like Congratulations your import has started$")
	    public void it_will_shows_like_congratulations_your_import_has_started() throws Throwable 
	    {
	    	im = new ImportPage();
	    	
	    }
	    @When("click on ok")
	    public void click_on_ok() throws Throwable 
	    {
	    	im = new ImportPage();
	    	im.clickOnOkBtn();
	     
	    }


}
