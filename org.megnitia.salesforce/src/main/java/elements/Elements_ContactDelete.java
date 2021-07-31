package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_ContactDelete 
{
	@FindBy(how=How.XPATH,using="//*[@data-id='Contact']")
	public static WebElement contact;
    //span[text()='Contacts']
	//(//*[text()='Contacts'])[2]
	@FindBy(how=How.XPATH,using="(//*[text()='Contacts'])[2]")
	public static WebElement contactAfterClick;
	@FindBy(how=How.XPATH,using="//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]")
	//table[@role='grid']/tbody
	public static WebElement contactsWebTable;
	@FindBy(how=How.XPATH,using="(//a[@title='Delete'])[1]")
	public static WebElement delete;
	@FindBy(how=How.XPATH,using="//button[@title='Delete']")
	public static WebElement deleteBtn;
	@FindBy(how=How.XPATH,using="//span[@data-aura-class='forceActionsText']")
	public static WebElement statusOfDeleteContact;
	
}
