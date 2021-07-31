package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.aventstack.extentreports.Status;

import base.Base;


public class HomePage extends Base 
{
	//private RemoteWebDriver Driver;
	//private FluentWait<RemoteWebDriver> Wait;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[1]")
	private WebElement leadslink;
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[2]")
	private WebElement leadsafterclick;
	@FindBy(how=How.XPATH,using="//*[text()='New']")
	private WebElement newlead;
	@FindBy(how=How.XPATH,using="//*[text()='New Lead']")
	private WebElement newleadform;
	
	/*public HomePage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> Wait)
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
		this.driver=driver;
		this.Wait=Wait;
	}
	*/
	
	public HomePage()
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
		//this.Driver=driver;
		//this.Wait=wait;
	}
	public void clickLeads() throws Exception
	{
		WebElement e =wait.until(ExpectedConditions.visibilityOf(leadslink));
		driver.executeScript("arguments[0].click();",e);
		exttest=report.createTest("Leads Test");
		exttest.log(Status.PASS,"Leads item clicked");
	}
	public Boolean isLeadsVisible() throws Exception
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(leadsafterclick));
		exttest=report.createTest("Leads Test");
		exttest.log(Status.PASS,"All Leads are Visabled");
		return(true);
		}
		catch(Exception ex)
		{
			exttest=report.createTest("Leads Test");
			exttest.log(Status.FAIL,"All Leads are Not Visabled");
			return(false);
		}
	}
	public void clickNew() throws Exception
	{
		
		wait.until(ExpectedConditions.visibilityOf(newlead)).click();
		exttest=report.createTest("Leads Test");
		exttest.log(Status.PASS,"New Test is clicked");
	}
	
	public Boolean isNewleadFormDisplyed() throws Exception
	{
		Thread.sleep(5000);
		try {
			wait.until(ExpectedConditions.visibilityOf(newleadform));
			exttest=report.createTest("Leads Test");
			exttest.log(Status.PASS,"Leads Form Visable");
			return(true);
			}
		catch(Exception ex)
		{
			exttest=report.createTest("Leads Test");
			exttest.log(Status.FAIL,"Leads Form Not Visable");
			return(false);
		}
	}
	
	


}
