package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import PageObjects.Base;
import PageObjects.Log;
import cucumber.api.Scenario;

public class BaseSteps {
	
	@cucumber.api.java.After
	public void After(Scenario c) throws IOException{
		if (c.getStatus() == "failed"){
			String Temp = Base.GetDateTimeInYYYYMMDDHHMMSS();
			File scrFile = ((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("extentreport/errorScreenshots/" + Temp +  ".jpg"));
			Reporter.addScreenCaptureFromPath("errorScreenshots/" + Temp +  ".jpg", "Test Failure");
		}
		Base.driver.close();
		Base.driver.quit();
		Base.driver = null;
	}
	
	public static void AssertTrue(String FieldName, Object ExpectedValue, Object ActualValue, Boolean Condition){
		Log.info("Expected Value:" + ExpectedValue!=null && ExpectedValue.toString().length() > 0?ExpectedValue.toString():"NULL / Blank");
		Log.info("Actual Value:" + ActualValue!=null && ActualValue.toString().length() > 0?ActualValue.toString():"NULL / Blank");
		Assert.assertTrue(Condition, FieldName + ": Expected Value is " + ExpectedValue!=null && ExpectedValue.toString().length() > 0?ExpectedValue.toString():"NULL / Blank" + ". Actual Value is " + ActualValue!=null && ActualValue.toString().length() > 0?ActualValue.toString():"NULL / Blank");
	}

}
