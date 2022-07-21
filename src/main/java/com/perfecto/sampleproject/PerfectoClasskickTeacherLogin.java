package com.perfecto.sampleproject;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.perfecto.reportium.client.DigitalZoomClient;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



@SuppressWarnings({"rawtypes","unused","unchecked","deprecation"}) 
public class PerfectoClasskickTeacherLogin {
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static ReportiumClient reportiumClient;
    String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI5MmFjYTc3Zi0xMmFkLTRjMGQtYTZkMC1hMGIzZTQ1Mzk3NDUifQ.eyJpYXQiOjE2NTY2MDkyODcsImp0aSI6IjRiNjk5MTQ0LTg1NTItNDZmNS04N2M4LWRmNzEzZDg1NDFiOSIsImlzcyI6Imh0dHBzOi8vYXV0aDQucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2NsYXNza2ljay1wdWJsaWMtcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoiaHR0cHM6Ly9hdXRoNC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvY2xhc3NraWNrLXB1YmxpYy1wZXJmZWN0b21vYmlsZS1jb20iLCJzdWIiOiI0YThkZGZjNS1hMGIxLTQzNjgtOTk5Yi0xMmVhNWQwMzQzMWIiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJub25jZSI6IjFmM2M4N2RiLTQwY2MtNDcxZi1hNWZmLTg3ZGY2MjNlOGY5OSIsInNlc3Npb25fc3RhdGUiOiJkZDYzZTYxZi02NGI4LTQ4YjEtYjUyMy0yZmY4YThmOWNiYzkiLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIG9mZmxpbmVfYWNjZXNzIGVtYWlsIn0.4mYiLYFkuO-2RqAbyUwUhNlXOJOh58iW8b15HG2yRlE";
    
    

    public static RemoteWebDriver driver;
   
    /*
    public PerfectoClasskickTeacherLogin(RemoteWebDriver driver) {
    	//this.driver = driver;
    	PageFactory.initElements(driver, this);
   
    }
    */

    @BeforeMethod
    public void setupTest() throws MalformedURLException, IOException {

        System.out.println("\n*********************\n    Starting Test    \n*********************\n");
        
        String host = "classkick-public.perfectomobile.com"; //Cloud URL
        final String URL_STRING = "https://" + host + "/nexperience/perfectomobile/wd/hub";
        url = new URL(URL_STRING);
    //    AppiumDriver driver = new AppiumDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub/fast"), capabilities);
        PerfectoLabUtils utils = new PerfectoLabUtils();

//        String browserName = "mobileOS";
//        DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("securityToken", securityToken); //I utilize a construct here to pull my token from another file. However, you can delete the "utils" construct and place you security token in its place. 
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("location", "US East");
        capabilities.setCapability("resolution", "1024x768");

        driver = new RemoteWebDriver(url, capabilities);
     
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("", ""))
                .withJob(new Job("Perfecto Support Test", 0))
                .withContextTags("")
                .withWebDriver(driver)
                .build();
                reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

        System.out.println("\nInstantiated Driver");

    }

    @Test(enabled = true, priority=1)
    public void myTest() throws InterruptedException {
            
    	
    	try {

                reportiumClient.testStart("classkick POC Test", new TestContext("", ""));
                
                //Write Your Test Here

                System.out.println("this is running the test method");
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        	
        		
        		reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        		//reportiumClient.testStart("Perfecto desktop web test", new TestContext("tag2", "tag3")); //Starts the reportium test
        		reportiumClient.stepStart("browser navigate to perfecto"); //Starts a reportium step
        		driver.get("https://staging.classkick.com/#/account/login");
        		reportiumClient.stepEnd();

        		reportiumClient.stepStart("Verify title");
        		String aTitle = driver.getTitle();
        		
        		PerfectoLabUtils.assertTitle(aTitle, reportiumClient); //compare the actual title with the expected title
        		reportiumClient.stepEnd();
        	

                
                reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {
            reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            e.printStackTrace();}
            
    }
    
    @SuppressWarnings("static-access")
	public RemoteWebDriver getDriver(RemoteWebDriver driver1) {
    	driver1=this.driver;
    	return driver1;
    	
    }

    @AfterSuite
    public void endTest() throws InterruptedException {

        try {
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n*********************\n      Run ended      \n*********************\n");

    
    }
}

