package pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.Base;
import elements.Elements_WebtoLead;
import utilities.PropertiesFileUtility;

public class WebtoLeadPage extends Base 
{ 
	
	public Set<String> s;
	public ArrayList<String> a;
	
	
	public WebtoLeadPage()
	{
		AjaxElementLocatorFactory af = new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af,weblead );
	}
	//enter this url into new window
	public void navigateurl() throws Exception
	{
		String url = PropertiesFileUtility.getValueInPropertiesFile("webtoleadurl");
		driver.switchTo().newWindow(WindowType.TAB);
		s = driver.getWindowHandles();//get all windows(2)
		a = new ArrayList<String>(s);
		driver.switchTo().window(a.get(1));
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	//verify wether details form is displayed or not
	public Boolean isFormDisplayed()//***********
	{
		try
		{
			if(wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.fname)).isDisplayed());
			{
				
			}
			return(true);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return(false);
		}
	}
	public Boolean fillForm(String salutation,String firstname,String lastname,String email,String company,String city,String state)
	{
		try
		{
			WebElement drp=wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.salutation));
			Select s=new Select(drp);
			s.selectByVisibleText(salutation);
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.fname)).sendKeys(firstname);
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.lname)).sendKeys(lastname);
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.email)).sendKeys(email);
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.cname)).sendKeys(company);
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.cityName)).sendKeys(city);
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.stateName)).sendKeys(state);
			return(true);
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return(false);
		}
	}	
		//click on submit
		public Boolean clicksubmit()
		{
			try
			{
			wait.until(ExpectedConditions.visibilityOf(Elements_WebtoLead.submitBtn)).click();
			return(true);
			}
			catch(Exception ex)
			
			{
				System.out.println(ex.getMessage());
				return (false);
			}
			
		}
		
		
		public Boolean afterSubmitNavigation()
		{
			try
			{
				String s = driver.getTitle();
				if(!s.equalsIgnoreCase("webtolead"))
				{
					driver.close();
					driver.switchTo().window(a.get(0));
					driver.navigate().refresh();
				}
				return(true);
			}
			catch(Exception ex)
			{
				return(false);
			}
		}
	}
		
		

