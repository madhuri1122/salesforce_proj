package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements_Import 
{
	@FindBy(how=How.XPATH,using="//div[text()='Import']")
	public static WebElement importLink;
	@FindBy(how=How.XPATH,using="//a[text()='Get Started']")
	public static WebElement getstarted;
	@FindBy(how=How.LINK_TEXT,using="Leads")
	public static WebElement impLeads;
	@FindBy(how=How.XPATH,using="(//div[@class='progress-marker-caption-content'])[2]")
	public static WebElement progressGoodJob;
	@FindBy(how=How.LINK_TEXT,using="Add new records")
	public static WebElement addnewrecords;
	@FindBy(how=How.XPATH,using="//span[text()='CSV']")
	public static WebElement csv;
	@FindBy(how=How.XPATH,using="//a[text()='Help for this page']")
	public static WebElement helpForThispage;
	@FindBy(how=How.XPATH,using="//input[@type='file']/parent::*")
	public static WebElement chooseFile;
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement Nextbtn;
	@FindBy(how=How.LINK_TEXT,using="Start Import")
	public static WebElement startimport;
	@FindBy(how=How.LINK_TEXT,using="OK")
	public static WebElement okbtn;
	
	
	

}
