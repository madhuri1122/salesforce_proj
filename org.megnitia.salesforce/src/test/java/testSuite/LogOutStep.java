package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LOgOutPage;

public class LogOutStep 
{
	LOgOutPage lo = new LOgOutPage();
	
	@Given("^user is on salesforce dashboard page$")
    public void user_is_on_salesforce_dashboard_page() throws Throwable 
	{
        
    }
	@And("^click on profile pic$")
    public void click_on_profile_pic() throws Throwable 
    {
    	lo.clickOnprofile();
    }

    @When("^click on Logout button$")
    public void click_on_logout_button() throws Throwable 
    {
    	lo.clickOnLogoutBtn();
        
    }
    

    @Then("^Login page is displayed$")
    public void login_page_is_displayed() throws Throwable 
    {
        lo.isLoginPageIsDisplayed();
    }

    


}
