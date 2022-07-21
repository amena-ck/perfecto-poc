package com.classkickWeb.qa.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils<WebElement> {
	
	public static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DriverUtils.createBrowserDriver();
	}
	/**
	 * Webdrivermanager downloads binanries/executables in an automated way
	 * Dependency added through Maven to download all the necessary drivers. 
	 * //button[contains(text(), 'Continue to Classkick')]
	 */

	public static void createBrowserDriver() {
		if (System.getProperty("is_firefox", "false").equals("true")) {
			DriverUtils.createWebFirefoxDriver();
			System.out.println("launched firefox" );
		}
		else {
			DriverUtils.createWebChromeDriver();
			System.out.println("launched chrome" );
		}
	}

	public static void createWebChromeDriver() { 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--window-size=1325x744");
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		if (System.getProperty("headless", "false").equals("true")) {
			options.addArguments("--headless");
		}
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	public static void createWebFirefoxDriver() {
			
		PropertiesUtils.loadPropTestData();
		FirefoxOptions firefoxDockerOptions = new FirefoxOptions();
		
		if (System.getProperty("is_local_run", "false").equals("true")) {
			System.setProperty("webdriver.gecko.driver", PropertiesUtils.getProperty("webdriver.gecko.driver").toString());
		} else {
			// docker firefox installation settings
			System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
			firefoxDockerOptions.setBinary("/usr/bin/firefox");
		}

		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		if (System.getProperty("headless", "false").equals("true")) {
			firefoxDockerOptions.addArguments("--headless");
		}
		firefoxDockerOptions.addArguments("--no-sandbox");
		firefoxDockerOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

		driver = new FirefoxDriver(firefoxDockerOptions);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	/**
	 * iOS code being called from the framework 
	 * at the time of launching the scenario 
	 */
	@SuppressWarnings("rawtypes")
	public static void createiOSDriver() { //method called to create the iOS driver
		PropertiesUtils.loadPropTestData();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", PropertiesUtils.getProperty("capability.platformName"));
		capabilities.setCapability("platformVersion", PropertiesUtils.getProperty("capability.platformVersion"));
		capabilities.setCapability("deviceName", PropertiesUtils.getProperty("capability.deviceName"));
		capabilities.setCapability("automationName", PropertiesUtils.getProperty("capability.automation"));
		capabilities.setCapability("app", PropertiesUtils.getProperty("capability.app"));
		capabilities.setCapability("bundleId", PropertiesUtils.getProperty("capability.bundleId"));
		capabilities.setCapability("noReset",
				Boolean.valueOf(PropertiesUtils.getProperty("capability.noReset").toString()));
		capabilities.setCapability("udid", PropertiesUtils.getProperty("capability.udid"));
		
		try {
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); //apm server path
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
