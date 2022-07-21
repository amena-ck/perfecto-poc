package com.classkickWeb.qa.utils;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshots {

	WebDriver webdriver;
	TakesScreenshot scrShot;

	public CaptureScreenshots(WebDriver driver) {
		this.webdriver = driver;
		scrShot = ((TakesScreenshot) webdriver);
	}

	public void takeSnapShot(String fileWithPath) throws Exception {

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(fileWithPath);

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
