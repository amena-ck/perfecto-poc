package com.classkickWeb.qa.stepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import com.classkickWeb.qa.utils.CaptureScreenshots;
import com.classkickWeb.qa.utils.DriverUtils;
import com.classkickWeb.qa.utils.PropertiesUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void beforeScenario() {
		DriverUtils.createBrowserDriver();
		DriverUtils.getDriver().get(PropertiesUtils.loadProperty("BaseURL"));

	}

//	@Before
//	public void beforeScenario() {
//		DriverUtils.createiOSDriver();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	@After
	public void afterScenario(Scenario scenario) throws Exception {
		// ScreenShots
		CaptureScreenshots screenshots = new CaptureScreenshots(DriverUtils.getDriver());
		String completePath = System.getProperty("user.dir") + "/ScreenShots/"+getDate();
		System.out.println("Screenshot path is : " + completePath);
		
		screenshots.takeSnapShot(completePath + "New.png");

		scenario.attach(((TakesScreenshot)DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES),
		"image/png", "Scenario End Screenshot");
		
		DriverUtils.getDriver().quit();
	}

	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String current_time = dtf.format(now);
		System.out.println(current_time);
		return current_time;
	}

}