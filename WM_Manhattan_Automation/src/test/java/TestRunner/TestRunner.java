package TestRunner;

import java.io.File;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.Reporter;
import PageObjects.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(
		features="features", 
		glue={"stepDefinition"}, 
		tags={}, 

		
		//format={"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{	
	@BeforeClass
	public static void setup() {
		System.setProperty("cucumberReportPath", "extentreport/TestExecution-" + Base.GetDateTimeInYYYYMMDDHHMMSS() + ".html");
		
	}
	
	@AfterClass
	public void teardown(){
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", Base.OS);
        Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}