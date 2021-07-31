package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;

public class NewLeadFormPage extends Base
{
	
	@FindBy(how=How.XPATH,using="//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(how=How.XPATH,using="//input[@name='middleName']")
	private WebElement middleName;
	
	@FindBy(how=How.XPATH,using="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(how=How.XPATH,using="//input[@name='suffix']")
	private WebElement sufix;
	
	@FindBy(how=How.XPATH,using="//input[@name='Website']")
	private WebElement website;
	
	@FindBy(how=How.XPATH,using="//input[@name='Company']")
	private WebElement Company;
	
	@FindBy(how=How.XPATH,using="//input[@name='Email']")
	private WebElement Email;
	
	@FindBy(how=How.XPATH,using="//input[@name='MobilePhone']")
	private WebElement MobilePhone;
	
	@FindBy(how=How.XPATH,using="//input[@name='salutation']")
	private WebElement salutation;
	
	@FindBy(how=How.XPATH,using="//*[@name='SaveEdit']")
	private WebElement saventn;
	
	@FindBy(how=How.XPATH,using="//span[@data-aura-class='forceActionsText']")
	private WebElement newleadStatus;
	
	@FindBy(how=How.XPATH,using="(//button[text()='Edit'])")
	private WebElement Edit_btn;
	
	@FindBy(how=How.XPATH,using="//input[@name='MobilePhone']")
	private WebElement New_Mobile_Number;
	
	@FindBy(how=How.XPATH,using="//button[@title='Select List View']")
	private WebElement recentltViewed;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']/tbody")
	private WebElement leadsTable;
	//table[@role='grid']/tbody
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage')]")
	private WebElement editLeadStatus;
	
	
	//@FindBy(how=How.XPATH,using="(//li[contains(@class,'slds-tabs_default__item slds-is-active')]//a[text()='Chatter'])[3]")
	//private WebElement chatter;
	
	@FindBy(how=How.XPATH,using="(//button[text()='Share'])[4]")
	private WebElement share;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Mark Status as Complete'])")
	private WebElement markStatus;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Mark Status as Complete'])[4]")
	private WebElement convertLead;
	
	@FindBy(how=How.XPATH,using="//span[normalize-space()='Convert']")
	private WebElement converbtn;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Go to Leads']")
	private WebElement gotoLead;
	
	
	
	
	public  NewLeadFormPage()
	{
		AjaxElementLocatorFactory af=new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af, this);
	}
	public void fillFirstName(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(l);
		fname=l;
	}
	public void fillMiddleName(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(middleName)).sendKeys(l);
	}
	public void fillLastName(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(l);
	}
	public void fillSufix(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(sufix)).sendKeys(l);
	
	}
	public void fillWebSite(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(website)).sendKeys(l);
	}
	public void fillCompany(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(Company)).sendKeys(l);
	}
	public void fillEmail(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(l);
	}
	public void fillMobilePhone(String l)
	{
		wait.until(ExpectedConditions.visibilityOf(MobilePhone)).sendKeys(l);
	}
	//salutation drop down
	public void fillSalutation(String y)
	{
		//wait.until(ExpectedConditions.visibilityOf(salutation)).sendKeys(l);
		//Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='salutation']//parent::div"))).click();
				//WebElement e =Wait.until(ExpectedConditions.visibilityOf(drpsalutation));
				WebElement drpsalutation =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='salutation']//parent::div)/following-sibling::div")));
				driver.executeScript("arguments[0].click();",drpsalutation);
						
				//List<WebElement>l=e.findElements(By.xpath("//span[@class='slds-truncate']"));
				List<WebElement>l=drpsalutation.findElements(By.xpath("//*[@class='slds-media__body']//*"));
				for(WebElement ee:l)
				{
					driver.executeScript("arguments[0].scrollIntoView(true);", ee);
					//Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='salutation']//parent::div"))).click();
					String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
						x=x.trim();
						if(x.equalsIgnoreCase(y))
						{
							ee.click();
							break;
							
						}
							
				}
						
			}
	//select industry drop down
	public void Selectindustry(String y) throws Exception
	{
		WebElement drpIndustry =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='slds-combobox_container'])[4]//child::div[2]")));
		driver.executeScript("arguments[0].scrollIntoView(true);", drpIndustry);
		driver.executeScript("arguments[0].click();",drpIndustry);
		
		exttest=report.createTest("Leads click Test");
		exttest.log(Status.PASS,"Leads item clicked");
			
		//List<WebElement>l=e.findElements(By.xpath("//span[@class='slds-truncate']"));
		List<WebElement>l=drpIndustry.findElements(By.xpath("//*[@class='slds-media__body']//*"));
		for(WebElement ee:l)
		{
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			//Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='salutation']//parent::div"))).click();
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				if(x.equalsIgnoreCase(y))
				{
					ee.click();
					break;
					
				}
					
		}
		
	}
	//Lead source Drop down
	public void SelectLeadsource(String y) throws Exception
	{
		WebElement drpLeadsource =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='slds-combobox_container'])[5]//child::div[2]")));
		driver.executeScript("arguments[0].scrollIntoView(true);", drpLeadsource);
		driver.executeScript("arguments[0].click();",drpLeadsource);
		
		exttest=report.createTest("Leads click Test");
		exttest.log(Status.PASS,"Leads item clicked");
			
		//List<WebElement>l=e.findElements(By.xpath("//span[@class='slds-truncate']"));
		List<WebElement>l=drpLeadsource.findElements(By.xpath("//*[@class='slds-media__body']//*"));
		for(WebElement ee:l)
		{
		
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			//Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='salutation']//parent::div"))).click();
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
				x=x.trim();
				System.out.println(x.trim());
				if(x.equalsIgnoreCase(y))
				{
					ee.click();
					break;
					
				}
					
		}
		
	}
	//click save after enter details to create lead
	public void clickSave()
	{
		wait.until(ExpectedConditions.visibilityOf(saventn)).click();
	}
    //verify new lead is created or not("lead was created"message is displayed or not)
	public void isnewleadcreated()
	{
		/*try
		{
			wait.until(ExpectedConditions.visibilityOf(newleadStatus));
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}*/
		
	} 
	//Recently viewed drop down
	public void clickOnRecenltyViewed()
	{ 
		exttest = report.createTest("find and verify saved lead test");
		
		try
		{ 
			
	      Thread.sleep(5000);	
		  wait.until(ExpectedConditions.visibilityOf(recentltViewed)).click();
		
		}
		catch(Exception ex)
		{
			
		}
	}
	//select todayslead
	public void toDaysLeads() throws Exception  
	{
		try
		{ 
			Thread.sleep(5000);	
		    WebElement list = wait.until(ExpectedConditions.presenceOfElementLocated
				       (By.xpath("//ul[@class='slds-dropdown__list slds-show']")));
		    List<WebElement> l = list.findElements(By.xpath
				("//li[contains(@class,'item has-icon')]//span[@class=' virtualAutocompleteOptionText']"));
		for(WebElement ee : l)
		{ 
			driver.executeScript("arguments[0].scrollIntoView(true);", ee);
			String x=(String)driver.executeScript("return arguments[0].textContent;", ee);
			x = x.trim();
			if(x.equalsIgnoreCase("Today's Leads"))
			{
				ee.click();
				
				break;
			}
			
		}
		
		exttest.log(Status.PASS,"find and verify Saved Lead Pass");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, ex.getMessage());
		}
		
	}
	
	//select lead from table
	public void clickOnRequredLead() throws Exception
	{
		Thread.sleep(5000);
		ReadTable(fname);
	
			
		}
		
	public int getRowCount()
	{
		int value =leadsTable.findElements(By.xpath("child::tr")).size();
		return(value);
	}
	public int getColumnCount(int rownum)
	{
		int value =leadsTable.findElements(By.xpath("child::tr["+rownum+"]/td")).size();
		return(value);
		
	}
	public String getCellValue(int rownum,int colnum)
	{
		WebElement temp=leadsTable.findElement(By.xpath("child::tr["+rownum+"]/th["+colnum+"]/span[1]/a[1]"));
		String value=(String)driver.executeScript("return arguments[0].textContent;",temp);
		return(value);
	}
	public void ReadTable(String s) throws Exception
	{
		
int rc=getRowCount();
		
		for(int i=1;i<=rc;i++)
		{
			
				WebElement temp=leadsTable.findElement(By.xpath("child::tr["+i+"]/th[1]/span/a"));
				String value=(String)driver.executeScript("return arguments[0].textContent;",temp);
				if(value.contains(s))
				{
					driver.executeScript("arguments[0].style.border='3px solid red'",temp);
					temp.click();
					break ;
				}
				
				
			
		}
			
	
		}   

	//edit
	public void editLead()
	{ 
		try
		{
			WebElement e = wait.until(ExpectedConditions.visibilityOf(Edit_btn));
			e.click();
			exttest=report.createTest("Lead Edit Test");
			exttest.log(Status.PASS,"Leads Edited");
		}
		catch(Exception ex)
		{
			
			exttest.log(Status.FAIL,"Lead not Edited");
		
		}
	}
	//validate edit lead form is displayed or not
	public void isEditLead_displyed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Edit_btn));
			exttest = report.createTest(" editlead form test");
			exttest.log(Status.PASS, "edit lead form is displyed");
			
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "edit lead form is displyed");
		}
	}
	//edit mobile_number
	public void edit_lead_mobilenumber(String z)
	{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(New_Mobile_Number));
		driver.executeScript("arguments[0].scrollIntoView(true);", e);
		e.clear();
		e.sendKeys(z);
		
		
	}
	public void clickSaveOfterEdit() throws Exception
	{ 
		
		WebElement e= wait.until(ExpectedConditions.visibilityOf(saventn));
		driver.executeScript("arguments[0].scrollIntoView(true);", e);
		driver.executeScript("arguments[0].click();", e);
	}
	
	public Boolean isEditLeadSved()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(editLeadStatus));
			exttest=report.createTest("Edit Lead save Test ");
			exttest.log(Status.PASS,"Saved Edit lead");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,"Not Saved");
			return(false);
		}
		
	} 
	
//convert Lead to contact chatter
	//chatter
	public void clickOnChatter() throws Exception
	{ 

		
		exttest = report.createTest("click chart button Test");
		try
		{
		WebElement e= wait.until(ExpectedConditions.presenceOfElementLocated
				                               (By.xpath("(//li[@class='slds-tabs_default__item']//a[text()='Chatter'])[1]")));
		driver.executeScript("arguments[0].click();", e);
		exttest.log(Status.PASS, "Chatter btn clicked");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Chatter btn not clicked");
		}

	}
	//share
	public void sendupdate()throws Exception  
	{ 
		exttest = report.createTest("click on Share update  btn test");
		try
		{
		Thread.sleep(5000);
		WebElement e= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Share an update...']")));//(//button[@type='button']//span[text()='Share'])[2]
		driver.executeScript("arguments[0].click();", e);
		driver.executeScript("arguments[0].scrollIntoView(true);", e);
		exttest.log(Status.PASS, "Share on update  btn clicked");
	
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Share btn not clicked");
		}
	}
	//share update
	public void clickshareupdatetxt(String x) throws Exception
	{
		exttest=report.createTest(" Send text to  shareupdate  texbox Test");
		try {
		Thread.sleep(5000);
		//Wait.until(ExpectedConditions.visibilityOf(Elements.shareupdatetxt)).sendKeys(x);
		WebElement e =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-clipboard']/preceding-sibling::div)//p")));
		//Driver.executeScript("arguments[0].scrollIntoView(true);", e);
		driver.executeScript("arguments[0].innerHTML='"+x+"';",e);
		exttest.log(Status.PASS," shareupdate text sent ");
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL," shareupdate text not sent ");
		
		}
	}
	
	//final share
	public void clickfinalshare()throws Exception  
	{ 
		exttest = report.createTest("click on Share update  btn test");
		try
		{
		Thread.sleep(5000);
		WebElement e= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@title,'Click')]")));//(//button[@type='button']//span[text()='Share'])[2]
		driver.executeScript("arguments[0].click();", e);
		driver.executeScript("arguments[0].scrollIntoView(true);", e);
		exttest.log(Status.PASS, "Share on update  btn clicked");
	
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL, "Share btn not clicked");
		}
	}

	public void clickOnMarkStatus()
	{ 
		
		try
		{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(markStatus));
		driver.executeScript("arguments[0].click();", e);
		
		}
		catch(Exception ex)
		{
			
		}
	}
	//verify convert lead form is displayed or not
	public Boolean isConvertLeadDisplayed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(convertLead));
			exttest=report.createTest("Convert Lead Test");
			exttest.log(Status.PASS,"Convert Lead form displayed");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.FAIL,ex.getMessage());
			return(true);
		}
	}
	//convert
	public void clickOnConvert() throws Exception
	{
		Thread.sleep(5000);
		WebElement e= wait.until(ExpectedConditions.visibilityOf(converbtn));
		driver.executeScript("arguments[0].click();", e);
	}
	//gotoLead
	public void clickOnGotoLead() throws Exception
	{
		Thread.sleep(5000);
		WebElement e= wait.until(ExpectedConditions.visibilityOf(gotoLead));
		driver.executeScript("arguments[0].click();", e);
	}
	
	
	

	
	
	
			

	}
		
		
		
		
		
		
	


