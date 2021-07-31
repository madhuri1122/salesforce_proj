package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebtoLeadPage;

public class WebtoLeadStep 
{
	WebtoLeadPage wtol = new WebtoLeadPage();
	
	@Given("^user is navigate to url$")
    public void user_is_navigate_to_url() throws Throwable 
	{
        wtol.navigateurl();
    }
	@And("^webtolead form should be displayed$")
    public void webtolead_form_should_be_displayed() throws Throwable 
	{
       wtol.isFormDisplayed();
    }

    @When("^enter salutation as \"([^\"]*)\" firstName as \"([^\"]*)\" lastName as \"([^\"]*)\" email as \"([^\"]*)\" company as \"([^\"]*)\" city as \"([^\"]*)\" satae as \"([^\"]*)\" details to fill$")
    public void fillform(String sal, String f, String l, String email, String comp, String city, String state) throws Throwable 
    {
       wtol.fillForm(sal, f, l, email, comp, city, state);
    }
    @And("^click on submit$")
    public void click_on_submit() throws Throwable 
    {
    	wtol.clicksubmit();
    }


    @Then("^it will automatically navigate to salseforce$")
    public void it_will_automatically_navigate_to_salseforce() throws Throwable 
    {
    	wtol.afterSubmitNavigation();
        
    }

    

    

}
