package pages;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
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
import utilities.PropertiesFileUtility;

public class LoginPage  extends Base
{
	//private RemoteWebDriver Driver;
	//private FluentWait<RemoteWebDriver> Wait;
	
	@FindBy(how=How.NAME,using="username")
	private WebElement uid;
	@FindBy(how=How.NAME,using="pw")
	private WebElement pwd;
	@FindBy(how=How.ID,using="Login")
	private WebElement loginbtn;
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[1]")
	private WebElement leadslink;
	@FindBy(how=How.XPATH,using="(//*[text()='Leads'])[2]")
	private WebElement afterclick;
	@FindBy(how=How.XPATH,using="//*[text()='New']")
	private WebElement newlead;
	@FindBy(how=How.XPATH,using="//*[text()='New Lead']")
	private WebElement newleadform;
	
	
	
	/*public InitialPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> Wait)
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
		this.driver=driver;
		this.Wait=Wait;
	}
	*/
	public LoginPage()
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
	//	this.Driver=driver;
		//this.Wait=wait;
	}
	
	
	
	public void uidFill() throws Exception
	{
		String x = PropertiesFileUtility.getValueInPropertiesFile("uid");
		wait.until(ExpectedConditions.visibilityOf(uid)).sendKeys(x);
		exttest=report.createTest("Login-UID Test");
		exttest.log(Status.PASS,"Uid Entering Working Properly");
	}
	public void pwdFill() throws Exception
	{
		String x = PropertiesFileUtility.getValueInPropertiesFile("pwd");
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(x);
		exttest=report.createTest("Login-PWD Test");
		exttest.log(Status.PASS,"Password Entering Working Properly");
	}
	public void clicklogintbn()
	{
		wait.until(ExpectedConditions.visibilityOf(loginbtn)).click();
		exttest=report.createTest("Login-Button click Test");
		exttest.log(Status.PASS,"Login Button Working Properly");
	}
	
	public String validateurl() throws Exception
	{
		String x = PropertiesFileUtility.getValueInPropertiesFile("url");
		URL u=new URL(x);
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		con.connect();
		if(con.getResponseMessage().equalsIgnoreCase("OK"))
		{
			exttest=report.createTest("Validate Url");
			exttest.log(Status.PASS,"Url Working Properly");
		return "Working";
		}
		else
		{
			exttest=report.createTest("Validate Url");
			exttest.log(Status.FAIL,"Url Not Working Properly");
			return "Not Working";
		}
	}
	public Boolean isHomeDisplyed() throws Exception
	{
		Thread.sleep(5000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Home'])[1]")));
			exttest=report.createTest("Home Page Display Test");
			exttest.log(Status.PASS,"Home Page Displayed");
			notification();
			return(true);
			}
		catch(Exception ex)
		{
			return(false);
		}
	}
	public Boolean notification()
	{
		try
		{
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']"))).isDisplayed())
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']"))).click();
				
			}
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	
	
	}

	
	


