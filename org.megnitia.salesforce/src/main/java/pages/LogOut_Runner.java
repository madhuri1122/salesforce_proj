package pages;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//smoke testing
@CucumberOptions(
		
		features= {"src\\test\\java\\testSuite"},
		glue= {"testSuite","pages"},
		tags="@Logout",
		monochrome=true,
		plugin= {"pretty","html:target/smoketesters.html","rerun:target/failedsmoketestscenarios.txt"}
		
		)

public class LogOut_Runner extends AbstractTestNGCucumberTests
{

}
