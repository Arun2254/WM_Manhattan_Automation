package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
		System.setProperty("webdriver.gecko.driver", "Dependencies/geckodriver_mac");
		driver = new FirefoxDriver();
	}
	@Test
	public void testEasy(){
		driver.get("https://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html");
		System.out.println("Inside Test");
	}
	@AfterTest
	public void afterTest(){
		System.out.println(driver.getTitle());
		System.out.println("After Test");
		driver.quit();
	}
	
}
