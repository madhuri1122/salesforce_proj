package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public  class Elements_WebtoLead 
{
	@FindBy(how=How.NAME,using="salutation")
	public static WebElement salutation;
	@FindBy(how=How.NAME,using="first_name")
	public static WebElement fname;
	@FindBy(how=How.NAME,using="last_name")
	public static WebElement lname;
	@FindBy(how=How.NAME,using="email")
	public static WebElement email;
	@FindBy(how=How.NAME,using="company")
	public static WebElement cname;
	@FindBy(how=How.NAME,using="city")
	public static WebElement cityName;
	@FindBy(how=How.NAME,using="state")
	public static WebElement stateName;
	@FindBy(how=How.NAME,using="submit")
	public static WebElement submitBtn;
	
	
	

}
