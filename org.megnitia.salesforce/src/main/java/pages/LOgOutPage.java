package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.Base;
import elements.Element_LogOut;

public class LOgOutPage extends Base
{
	public LOgOutPage()
	{
		AjaxElementLocatorFactory af = new AjaxElementLocatorFactory(driver, 50);
		PageFactory.initElements(af, logout);
	}
	public Boolean clickOnprofile() throws Exception
	{
		
		exttest = report.createTest("profile pic click Test");
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(Element_LogOut.profile)).click();
			exttest.log(Status.PASS, "Profile click test pass");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.PASS, "Profile click test failed");
			return(false);
		}
	}
	public Boolean clickOnLogoutBtn()
	{
		exttest = report.createTest("Logout click Test");
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(Element_LogOut.logoutbtn)).click();
			exttest.log(Status.PASS, "Logout click test pass");
			return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.PASS, "Logout click test faled");
			takescreenshot();
			return(false);
		}
	}
	//verify the login page is diplaed or not to check logout is don or not
	public Boolean isLoginPageIsDisplayed()
	{
		exttest = report.createTest("Login page displayed test");
		try
		{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(Element_LogOut.loginbtn)).isDisplayed();
		exttest.log(Status.PASS, "LoginPage is displayed");
		return(true);
		}
		catch(Exception ex)
		{
			exttest.log(Status.PASS, "LoginPage is not displayed");
			takescreenshot();
			return(false);
		}
	}

}
