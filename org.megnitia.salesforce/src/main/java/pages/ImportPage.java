package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.Screen;

import com.aventstack.extentreports.Status;

import base.Base;
import elements.Elements_Import;

public class ImportPage extends Base
{
	public ImportPage()
	{
		AjaxElementLocatorFactory af = new AjaxElementLocatorFactory(driver, 50);
		PageFactory.initElements(af, importt);
	}
	//1.click on import
	public Boolean clickOnImport()
	{
		exttest = report.createTest("import button test");
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.importLink)).click();
			exttest.log(Status.PASS, "click on import button clicked");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "click on import button not clicked");
			return(true);
		}
	}
	//2.Get started is visible
	public Boolean isGetStartedpageVisible()
	{
		exttest = report.createTest("Get Started is visible to click lead");
		try
		{
			while(!driver.getTitle().contains("Home"))//*****
			{
				Thread.sleep(1000);
			}
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.getstarted)).isDisplayed();
			exttest.log(Status.PASS, "Get Started is visible");
			return(true);
			
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Get Started is not visible");
			return(false);
		}
	}
	//3.click on leads 
	public Boolean clickOnLeadsOnStandardObject()
	{
		exttest = report.createTest("click on leads btn test on standard object");
		try
		{
			driver.switchTo().frame(0);//switch to frame****
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.impLeads)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS, "clicked on leads");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "not clicked on leads");
			return(true);
		}
	}
	//4.is displayed Getjob
	public Boolean isMarkStatusDisplayed()
	{
		exttest = report.createTest("Mark status visible test");
		try
		{
			driver.switchTo().frame(0);//switch to frame****
			wait.until(ExpectedConditions.visibilityOf(Elements_Import.progressGoodJob)).isDisplayed();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"mark status visible");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"mark status not visible");
			return(false);
		}
	}
	//5.click on add new record
	public Boolean clickOnAddNewRecord()
	{
		exttest = report.createTest("Add new record test");
		try
		{
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.addnewrecords)).click();
		driver.switchTo().defaultContent();
		exttest.log(Status.PASS,"Add new record is clicked");
		return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Add new record is not clicked");
			return(false);
		}
	}
	//6.click on CSV
	public Boolean clickOncsv()
	{
		exttest = report.createTest("CSV Test");
		try
		{
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.csv)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS, "CSV  is clicked");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "CSV  is not clicked");
			return(false);
		}
	}
	//7.choose file
	public Boolean clickOnCooseFile()
	{
		exttest = report.createTest("Choose file test");
		try
		{ 
			//identify ans scrolling "help for this page"
			driver.switchTo().frame(0);
			driver.executeScript("arguments[0].scrollIntoView(true);", Elements_Import.helpForThispage);
			//identify choose file
			//driver.executeScript("arguments[0].style.display='block';", Elements_Import.chooseFile);
			//driver.executeScript("arguments[0].style.border='3px solid red'",Elements_Import.chooseFile);
			Elements_Import.chooseFile.click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS, "choose file is clicked");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "choose file is not clicked");
			return(false);
		}
		/*exttest=report.createTest("Click on Choose file  Test");
		try {
			
		driver.switchTo().frame(0);
		driver.executeScript("arguments[0].scrollIntoView(true);", Elements_Leads.helplink);
			driver.executeScript("arguments[0].style.display='block';",Elements_Leads.choosefile);
		//	Elements_Leads.choosefile.sendKeys("C:\\Users\\veeresh\\git\\repository\\Saleforce\\src\\test\\resources\\Datafiles\\importlead.csv");
			driver.executeScript("arguments[0].style.border='3px solid red'",Elements_Leads.choosefile);
			Elements_Leads.choosefile.click();
			//driver.executeScript("arguments[0].click;",Elements_Leads.choosefile);
			//act.moveToElement(Elements_Leads.choosefile).click();
			//wait.until(ExpectedConditions.elementToBeClickable(Elements_Leads.choosefile)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"click on Choose file  pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"click on Choose file  failed");
			takescreenshot();
			return(false);
		} */
	}
	//8.verify choose file is displayed
	public Boolean isfileselectordisplayed() throws Exception
	{
		exttest=report.createTest("File selector visible  Test");
		try {
			driver.switchTo().frame(0);
		
			wait.until(ExpectedConditions.visibilityOf(Elements_Import.chooseFile)).isDisplayed();
			
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"File selector visible  pass");
			return(true);
			}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"File selector visible failed");
			//takescreenshot();
			return(false);
		}
	}
	//9.Automate window
	public Boolean automateWindow() throws Exception
	{
		exttest=report.createTest("Open Window Dialouge  Automation   Test");
		try {
			Screen s=new Screen();
			if(s.exists("src\\test\\resources\\testimg\\filename.PNG",10)!=null)
			{
				s.click("src\\test\\resources\\testimg\\filename.PNG");
				String path=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\import.csv";
				s.type(path);
				s.click("src\\test\\resources\\testimg\\open.PNG");
			exttest.log(Status.PASS,"Open Window Dialouge  Automation Test  pass");
			}
			
			return(true);
		
			
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Open Window Dialouge  Automation Test failed");
			takescreenshot();
			return(false);
		}
	}
	
	//10.click on next
	public void clickOnNext()
	{
		exttest = report.createTest("click on next Test");
		try
		{
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.Nextbtn)).click();
			//Elements_Import.Nextbtn.click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS,"next btn is clicked");
			
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"next btn is  not clicked");
			
		}
	}
	//11.click on start import
	public void clickOnStartImport()
	{
		exttest = report.createTest("click Start Import btn test");
		try
		{
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.startimport)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS, "start import is clicked");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "start import is not clicked");
		}
	}
	//12.click on Ok button
	public void clickOnOkBtn()
	{
		exttest = report.createTest("Ok button test");
		try
		{
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.elementToBeClickable(Elements_Import.okbtn)).click();
			driver.switchTo().defaultContent();
			exttest.log(Status.PASS, "ok button is clicked");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "ok button is not clicked");
		}
	}

}
