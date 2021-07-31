package testSuite;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSep 
{
	LoginPage lp;
	@Given("^User is on Salesforce Login page$")
    public void user_is_on_salesforce_login_page() throws Throwable 
	{
        
    }
	@And("^Enter username$")
    public void enter_username() throws Throwable 
	{
		lp = new LoginPage();
		lp.uidFill();
    }
	@And("^Enter password$")
    public void enter_password() throws Throwable 
	{
		lp = new LoginPage();
		lp.pwdFill();
    }

    @When("^click on login button$")
    public void click_on_login_button() throws Throwable 
    {
    	lp = new LoginPage();
    	lp.clicklogintbn();
    }
    @Then("^Home page displayed$")
    public void home_page_displayed() throws Throwable 
    {
    	lp = new LoginPage();
    	lp.isHomeDisplyed();
    }

   

    

    

}
