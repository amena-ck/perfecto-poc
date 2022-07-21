package com.classkickWeb.qa.runner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.classkickWeb.qa.utils.DriverUtils;

//@Test(Cucumber.class)

//tags = "@done and not @pending",  

//mvn verify -DRunnerFileName=DemoRunner.java 

/*
@CucumberOptions(
		
		//tags = "@CancelOrResolveHelpRequest",
		tags = "@NonProTeacherRosterListCreateRoster",
		features = "src//test//resources//scenarios//", 
		glue = "com.classkickWeb.qa.stepDefs", 
		//searchBarFielddryRun = true,
		//dryRun = true,
		stepNotifications = true,
		plugin = { "pretty", "html:target/cucumber-reports/CucumberReport.html",
				"json:target/cucumber-reports/Cucumber.json"
				},
		monochrome = true	
)
*/


public class DemoRunner {

	

	private WebDriver driver;
	public String baseUrl = "http://demo.guru99.com/test/newtours/";

	@Test
	public void verifyHomepageTitle() {

		driver = DriverUtils.getDriver();
		driver.get(baseUrl);
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}


//import com.classkick.qa.stepDefs.is;
//import com.classkick.qa.stepDefs.verify;
//