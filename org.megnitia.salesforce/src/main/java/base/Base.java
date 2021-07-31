package base;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import elements.Element_LogOut;
import elements.Element_PickList;
import elements.Elements_ContactDelete;
import elements.Elements_Import;
import elements.Elements_WebtoLead;
import utilities.PropertiesFileUtility;
import utilities.WebsiteUtility;

public class Base
{
    public static RemoteWebDriver driver;
    //public static Properties prop;
    public static String fname=null;
    public static ExtentHtmlReporter exthtml;
    public static ExtentTest exttest;
    public static ExtentReports report;
    public static FluentWait<RemoteWebDriver> wait;
	public static WebsiteUtility su;
	public static Elements_WebtoLead weblead = new Elements_WebtoLead();
	public static Elements_Import importt = new Elements_Import();
	public static Element_PickList plo = new Element_PickList();
	public static Element_LogOut logout = new Element_LogOut();
	public static Elements_ContactDelete contdel = new Elements_ContactDelete();
	
   @BeforeSuite
    public void setUp() throws Exception
    {
    	/*prop=new Properties();
    	try{prop.load(new FileInputStream("src/main/java/config/config.properties"));}catch(Exception e) {}
    	if(prop.getProperty("browsername").matches("firefox"))
    	{
    		driver=new FirefoxDriver();
    	}
    	if(prop.getProperty("browsername").matches("chrome"))
    	{
    		driver=new ChromeDriver();
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/
	    //String bn=PropertiesFileUtility.getValueInPropertiesFile("browsername");
    	String bn = PropertiesFileUtility.getValueInPropertiesFile("browsername");
		System.out.println(bn);

    	//String bn= "chrome";
		su=new WebsiteUtility();
		driver=su.openBrowser(bn);
		wait=su.defineWait(driver);
		su.launchSite(driver);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    
    	//wait=new WebDriverWait(driver, 120);
    	   exthtml = new ExtentHtmlReporter(PropertiesFileUtility.getValueInPropertiesFile("reportlocation"));
		   report = new ExtentReports();
	 	   report.attachReporter(exthtml);
	 	   report.setSystemInfo("Host Name", "LAPTOP-DCCOGBUJ");  //name of thesystem
	 	   report.setSystemInfo("Environment", "Test Env");
	 	   report.setSystemInfo("User Name", "maduri");
	 	   
	 	   exthtml.config().setDocumentTitle("Salceforce");
	 	   exthtml.config().setReportName("Salseforce Functional Testing");
	 	   exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
	 	   exthtml.config().setTheme(Theme.STANDARD);
    }
    
    public void takescreenshot()
    {
    	try
    	{
    		String path = su.captureScreenshot(driver);
    		exttest.addScreenCaptureFromPath(path);
    	}
    	catch(Exception e)
    	{
    		
    	}
		
    }
    
    @AfterSuite
    public void teadDown()
    {
    	//su.closeSite(driver);
    	report.flush();
		//try {
		//Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		//Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");}catch(Exception e) {}
    }
    
}

