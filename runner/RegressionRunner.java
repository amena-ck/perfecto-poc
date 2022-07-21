package com.classkickWeb.qa.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//tags = "@done and not @pending",  

// trigger from command line: mvn verify -DRunnerFileName=SanityRunner.java

@CucumberOptions(
		
		tags = "@regression",
		features = "src//test//resources//scenarios//", 
		glue = "com.classkickWeb.qa.stepDefs", 
		//searchBarFielddryRun = true,
		//dryRun = true,
		stepNotifications = true,
		plugin = { "pretty", "html:target/cucumber-reports/CucumberReport.html",
				"json:target/cucumber-reports/Cucumber.json" },
		monochrome = true	
)

public class RegressionRunner {

}

//import com.classkick.qa.stepDefs.is;
//import com.classkick.qa.stepDefs.verify;