package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import elements.Elements_ContactDelete;

public class ContactDeletePage extends Base
{
	NewLeadFormPage nl = new NewLeadFormPage();
	
	public ContactDeletePage()
	{
		AjaxElementLocatorFactory af = new AjaxElementLocatorFactory(driver, 50);
		PageFactory.initElements(af, contdel);
	}
	//click on contact
	public void clickOnContacts()
	{
		exttest = report.createTest("Click on Contacts Test");
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.contact)).click();
			exttest.log(Status.PASS, "contact is clicked");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "contact is not clicked");
			takescreenshot();
		}
	}
	//verify contact page is displayed or not
	public Boolean isAllContactsVisible()
	{
		exttest = report.createTest("All contact display Test");
		try
		{
			//*****
			wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.contactAfterClick)).isDisplayed();
			exttest.log(Status.PASS, "All contacts are visible");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "All contacts are not visible");
			takescreenshot();
			return(false);
		}
	}
	//read contact table
	public void readContTable()
	{
		int rc = nl.getRowCount();
		for(int i=1;i<=rc;i++)
		{
			//****
			WebElement temp = Elements_ContactDelete.contactsWebTable.findElement
					         (By.xpath("child::tr["+i+"]/th/span/a"));
			String value=(String)driver.executeScript("return arguments[0].textContent;",temp);
			if(value.contains(Base.fname))//*****************
			{
				driver.executeScript("arguments[0].style.border='3px solid red'",temp);
				
				WebElement temp2 = Elements_ContactDelete.contactsWebTable.findElement
						(By.xpath("(//table[@role='grid']/tbody/tr[1]/td[7]/span/div/a/span/span)[1]"));
				temp2.click();
				break;
			}
		}
	}
	//options are visible or not to dalete
	public void isOptionsVisible()
	{
		exttest = report.createTest("options visible Test");
		try
		{
			if(wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.delete)).isDisplayed());
			{
				
				driver.executeScript("arguments[0].style.border='3px solid red'", Elements_ContactDelete.delete);
				exttest.log(Status.PASS, "options are visible");
			}
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "options are not visible");
			takescreenshot();
		}
	}
	//click on delete
	public void clickOnDelete()
	{
		exttest = report.createTest("click on delete Test");
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.delete)).click();
			exttest.log(Status.PASS, "click on delete pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "click on delete fail");
			takescreenshot();
		}
	}
	//delete contact box is displayed or not
	public void isDeleteContactConformatioVisible()
	{
		exttest = report.createTest("delete conformation display Test");
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.deleteBtn)).isDisplayed();
			exttest.log(Status.PASS, "Delete conformation is visible");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Delete conformation is not visible");
			takescreenshot();
		}
		
		
	}
	//click on delete button
	public void clickOnDeleteButton()
	{
		exttest = report.createTest("click delete button test ofter conformation");
		try
		{
		wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.deleteBtn)).click();
		exttest.log(Status.PASS, "Delete button click test pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Delete button click test fail");
		}
	}
	//verify contact is deleted or not
	public Boolean isContactDeleted()
	{
		exttest = report.createTest("Contact Delete Test");
		try
		{
			if(wait.until(ExpectedConditions.visibilityOf(Elements_ContactDelete.statusOfDeleteContact)).isDisplayed());
			{
				driver.executeScript("arguments[0].style.border='3px solid red'", Elements_ContactDelete.statusOfDeleteContact);
				exttest.log(Status.PASS, "Contact delete pass");
			}
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Contact delete failed");
			return(false);
		}
		
	}

}
