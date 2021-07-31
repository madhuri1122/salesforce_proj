package pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import elements.Element_PickList;
import elements.Elements_Import;

public class PickListPage extends Base
{
	HomePage hp = new HomePage();
	public Set<String> s;
	public ArrayList<String> l;
	public List<String> items=new ArrayList<>();
	public List<String> ditems=new ArrayList<>();
	
	public PickListPage()
	{
	    AjaxElementLocatorFactory af = new AjaxElementLocatorFactory(driver, 50);
		PageFactory.initElements(af, plo);
	}
	
	//click on setup symbol
    public Boolean clickOnSetupSymbol()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Element_PickList.setupSymbol)).click();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
    
	//click on setup button
	public Boolean clickOnSetupbutton()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Element_PickList.setUpBtn)).click();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//navigate to setup home page
	public Boolean isNavigateToSetupHomePage()
	{
		try
		{
			s = driver.getWindowHandles();//get all windows
			l = new ArrayList<String>(s);//all windows in to array list
			driver.switchTo().window(l.get(1));
			while(!driver.getTitle().contains("Home"))
			{
				Thread.sleep(1000);
			}
			wait.until(ExpectedConditions.elementToBeClickable(Element_PickList.getstarted)).isDisplayed();
			exttest.log(Status.PASS, "Get Started is visible");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Get Started is not visible");
			return(false);
		}
	}
	//click on object manager
	public Boolean clickOnObjectManager()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(Element_PickList.objectManager)).click();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//click on leads in objectManager
	public Boolean clickOnLeadsInObjectManager()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Element_PickList.leadsOnObjm)).click();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//verify leads details displayed or not
	public boolean isDetailsDisplayed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated
					                  (By.xpath("//div[@role='menu']//li[1]"))).isDisplayed();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//click on fields&Relationship
	public Boolean clickOnFieldsAndRelationship()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Element_PickList.fieldsAndRelationships)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Custom Field']"))).isDisplayed();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//click on Industry item
	public Boolean clickOnIndustryItem()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated
					                       (By.xpath("(//span[text()='Industry'])[1]"))).click();
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//verify Field information is diplyed or not
	public Boolean isFieldInformationIsDisplyed()
	{
		try
		{
			Boolean b = true;
			while(b)
			{
				try
				{
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOf(Element_PickList.filedinformation)).isDisplayed();
					b = false;//break
				}
				catch(Exception ex)
				{
					Thread.sleep(1000);
				}
			}
			return(true);	
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//get picklist values
	public Boolean getPicklistValues()
	{
		try
		{
			WebElement webtable=	wait.until(ExpectedConditions.visibilityOfElementLocated
					                              (By.xpath("(//table[@class='list'])[3]")));
			List<WebElement> lwe= webtable.findElements(By.xpath("//th[@scope='row']"));
			for(WebElement e:lwe)
			{
				String x=(String)driver.executeScript("return arguments[0].textContent;",e);
				items.add(x);
				items.sort(Comparator.comparing( String::toString ));//a to z sorting
				
			}
			    //items.sort(Comparator.comparing( String::toString ));//a to z sorting
                 driver.switchTo().parentFrame();
		          return (true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	//back to salesforce dash board
	public Boolean backToSalesforcedashboard() throws Exception
	{
		try
		{
		driver.close();
		driver.switchTo().window(l.get(0));
		
		Thread.sleep(5000);
		hp.clickLeads();
		Thread.sleep(5000);
		hp.clickNew();
		
		return(true);
		}
		catch(Exception ex)
		{
		return(false);
		}
	}
	//(//input[@role='combobox'])[5]//parent::div
//Read Industry dropdown values
	public void ReadindustryValue() throws Exception
	{
		
		exttest=report.createTest("Read Industry Test");
		try
		{
			Thread.sleep(1000);
			WebElement drpIndustry =wait.until(ExpectedConditions.presenceOfElementLocated
					(By.xpath("(//*[@class='slds-combobox_container'])[4]//child::div[2]")));
			driver.executeScript("arguments[0].scrollIntoView(true);", drpIndustry);
			driver.executeScript("arguments[0].click();",drpIndustry);
			List<WebElement>l=drpIndustry.findElements
	        (By.xpath("child::*[contains(@data-value,'')]/following-sibling::*//*[@class='slds-media__body']//*"));
			for(WebElement ee:l)
			{
				driver.executeScript("arguments[0].scrollIntoView(true);", ee);
				String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
			    x=x.trim();
			    ditems.add(x);
						
			}
			ditems.sort(Comparator.comparing( String::toString ));
			exttest.log(Status.PASS,"Read Industry");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Read Industry");
			takescreenshot();
		}
	}
	public void comparelist() throws Exception
	{
		Thread.sleep(1000);
		exttest=report.createTest("List s compare  Test");
		 if (items.equals(ditems) == true) {
	            exttest.log(Status.PASS,"Both lists are same");
	        }
	        else {
	            System.out.println(" Array List are not equal");
	            
	            List<String> tempitems=items;
	            tempitems.removeAll(ditems);
	            System.out.println(tempitems);
	            exttest.log(Status.FAIL,"Both lists not same missing items are "+tempitems);
	        }
		 try
		 {
		 Thread.sleep(1000);
		 WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated
					(By.xpath("//*[@name='CancelEdit']")));
		  //WebElement e = wait.until(ExpectedConditions.elementToBeClickable(Element_PickList.Cancelbtn));
		  driver.executeScript("arguments[0].click();", e);
		 }
		 catch(Exception ex)
		 {
			 ex.getMessage();
		 }
	}
	
}
