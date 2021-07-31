package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Element_PickList 
{
	@FindBy(how=How.XPATH,using="//div[@class='setupGear']")
	public static WebElement setupSymbol;
	@FindBy(how=How.XPATH,using="//div[@role='menu']//li[1]")//(//div[contains(@class,'headerTrigger ')])[2]
	public static WebElement setUpBtn;
	//div[@role='menu']//li[1]
	@FindBy(how=How.XPATH,using="//a[text()='Get Started']")
	public static WebElement getstarted;
	@FindBy(how=How.XPATH,using="(//span[text()='Object Manager'])[1]")
	public static WebElement objectManager;
	@FindBy(how=How.XPATH,using="//a[text()='Lead']")
	public static WebElement leadsOnObjm;
	@FindBy(how=How.XPATH,using="//div[@role='menu']//li[1]")//a[text()='Details']/parent::li[1]
	public static WebElement leadDetails;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Fields &')]")
	public static WebElement fieldsAndRelationships;
	@FindBy(how=How.XPATH,using="//h3[text()='Field Information']")
	public static WebElement filedinformation;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[2]")
	public static WebElement leadslink;
	@FindBy(how=How.XPATH,using="//*[@name='CancelEdit']")
	public static WebElement Cancelbtn;

}//a[text()='Fields & Relationships']//parent::li[1]
