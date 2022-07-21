package com.classkickWeb.qa.utils;

import static com.classkickWeb.qa.utils.CommonUtils.verifyElementVisible;

import java.util.List;
import java.util.Random;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.classkick.qa.utils.DriverUtils;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.perfecto.sampleproject.PerfectoClasskickTeacherLogin;

public class CommonUtils extends Base {

	public static WebDriverWait wait = new WebDriverWait(PerfectoClasskickTeacherLogin.driver, 20);

	/**
	 * This method will perform the click, clear & sendKeys operation to the element
	 * 
	 * @param ele        - Text field element
	 * @param textToSend - Text to send to Element
	 */
	public static void sendKeysToElement(WebElement ele, String textToSend) {

		clickUsingJS(ele);
		ele.clear();
		ele.sendKeys(textToSend);
	}

	public static void CheckFirfoxPopup(WebElement continueToClasskick) throws InterruptedException {
		Thread.sleep(3000);
		if (System.getProperty("is_firefox", "false").equals("true")) {
			if (CommonUtils.isElementDisplayed(continueToClasskick)) {
				System.out.println("launched firefox");
				verifyElementVisible(continueToClasskick);
				CommonUtils.clickElement(continueToClasskick);
				Thread.sleep(3000);
			}

		}

	}

	public static void waitForElementPresence(By locator) {

		WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// dropdown code
	public static void dropDownHandle(List<WebElement> ele, String str) throws Throwable {
		int ddSize = ele.size();

		for (int i = 0; i < ddSize; i++) {
			System.out.println("Values available on dropdown are: " + ele.get(i).getText());
			Thread.sleep(1000);
			if (ele.get(i).getText().equalsIgnoreCase(str)) {
				System.out.println("Clicking on dropdown value: " + ele.get(i).getText());
				ele.get(i).click();
				break;
			}
		}
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}

	/**
	 * select value from drop down manue
	 */

	public static void selectByValue(WebElement ele, String dropDownValue) {
		Select s = new Select(ele);
		s.selectByValue(dropDownValue);
	}

	/**
	 * This method will verify text field is empty
	 */
	public static void verifyTextFieldIsEmpty(WebElement ele) {
		System.out.println("verifying element is empty==>" + ele.toString());
		String elementText = ele.getAttribute("value");
		Assert.assertTrue(elementText.isEmpty());

	}

	/**
	 * This method will perform the swipe through page
	 * 
	 * @param ele        -
	 * @param textToSend -
	 */
//	public static void SwipeElementDirection(WebElement ele) {
//		ele.scrollTo(ele);
//	}

	/**
	 * This method will verify the visibility of the target element
	 * 
	 * @param ele - Target Element
	 * @throws InterruptedException
	 */
	public static void verifyElementVisible(WebElement ele) throws InterruptedException {
		Assert.assertEquals(ele.isDisplayed(), true);
	}
	

	public static void verifyElementVisible(By locator) {

		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
		Assert.assertEquals(DriverUtils.driver.findElement(locator).isDisplayed(), true);
	}

	/**
	 * This method will verify that the target element is not visible. This method
	 * works only for @Findby elements
	 * 
	 * @param ele - Target Element
	 */
	public static void verifyElementNotVisible(WebElement ele) {
		try {
			Assert.assertEquals(ele.isDisplayed(), false);
		} catch (Exception e) {
			Assert.assertEquals(true, true);
		}
	}

	/**
	 * This method will verify the presence of the element in the view hierarchy
	 * (DOM structure) but will not validate the element's visibility
	 * 
	 * @param xpath - xpath string of the target element
	 */
	public static void verifyElementPresent(String xpath) {
		boolean flag = false;
		try {
			WebDriverWait w = new WebDriverWait(DriverUtils.getDriver(), 3);
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			flag = true;
		} catch (Exception ex) {
			flag = false;
			System.out.println("Message ==>" + ex);
		}

		Assert.assertEquals(flag, true);
	}

	public static void verifyElementPresent(WebElement ele, String text) {
		boolean flag = false;
		try {
			WebDriverWait w = new WebDriverWait(DriverUtils.getDriver(), 20);

			// w.until(ExpectedConditions.visibilityOf(ele));
			w.until(ExpectedConditions.textToBePresentInElementValue(ele, text));
			flag = true;
		} catch (Exception ex) {
			flag = false;
			System.out.println("Message ==>" + ex);
		}

		Assert.assertEquals(flag, true);
	}

	public static void verifyElementPresent(WebElement ele) {
		boolean flag = false;
		try {
			WebDriverWait w = new WebDriverWait(PerfectoClasskickTeacherLogin.driver, 20);

			w.until(ExpectedConditions.visibilityOf(ele));
			// w.until(ExpectedConditions.textToBePresentInElementValue(ele, text));
			flag = true;
		} catch (Exception ex) {
			flag = false;
			System.out.println("Message ==>" + ex);
		}

		Assert.assertEquals(flag, true);
	}

	/**
	 * This method will verify the element NOT presence in the view hierarchy (DOM
	 * structure) but will not validate the element's visibility
	 * 
	 * @param xpath - xpath string of the target element
	 */
	public static void verifyElementNotPresent(String xpath) {
		boolean flag = true;
		try {
			WebDriverWait w = new WebDriverWait(DriverUtils.getDriver(), 30);
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			flag = true;
		} catch (Exception ex) {
			flag = false;
		}

		Assert.assertEquals(flag, false);
	}

	/**
	 * This method will return boolean flag for the visibility of the target
	 * element.
	 * 
	 * @param ele - target element
	 * @return - Returns true of the element was visible and false if the element
	 *         was not visible.
	 */
	public static boolean isElementDisplayed(WebElement ele) {
		try {
			return ele.isDisplayed();
		} catch (Exception ex) {
			System.out.println("Element was not present in DOM, returning false.");
			return false;
		}
	}

	/**
	 * This method will verify the Text of the element matches to the expected text.
	 * (Ignoring case)
	 * 
	 * @param ele                 - Target Element
	 * @param expectedTextToMatch - Expected text of the element
	 */
	public static void verifyElementTextEqualsIgnoreCase(WebElement ele, String expectedTextToMatch) {
		Assert.assertEquals(ele.getText().equalsIgnoreCase(expectedTextToMatch), true);
	}

	/**
	 * This method will verify the Text of the element matches to the expected text.
	 * (Exact String Match)
	 * 
	 * @param ele                 - Target Element
	 * @param expectedTextToMatch - Expected text of the element
	 */
	public static void verifyElementTextEquals(WebElement ele, String expectedTextToMatch) {
		System.out.println("Element text is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ele.getText());
		Assert.assertEquals(ele.getText().equals(expectedTextToMatch), true);
	}

	/**
	 * This method will verify that the element text is not equal to the expected
	 * text.
	 * 
	 * @param ele                    - Target element
	 * @param expectedTextToNotMatch - Expected text to not match the element text
	 */
	public static void verifyElementTextNotEquals(WebElement ele, String expectedTextToNotMatch) {
		Assert.assertEquals(!ele.getText().equalsIgnoreCase(expectedTextToNotMatch), true);
	}

	/**
	 * This method will return a web element based on the visible text.
	 * 
	 * @param txt - text inside the element
	 */
	public static WebElement getElementBasedOnVisibleTxt(String txt) {
		return DriverUtils.getDriver().findElement(By.xpath("//*[text()='" + txt + "']"));
	}

	public static WebElement getElementBasedOnContainsVisibleTxt(String txt) {
		return DriverUtils.getDriver().findElement(By.xpath("//*[contains(text(),'" + txt + "')]"));
	}

	public static WebElement getBtnElementBasedOnVisibleTxt(String txt) {
		return DriverUtils.getDriver().findElement(By.xpath("//button[text()='" + txt + "']"));
	}

	public static void clickUsingJS(WebElement ele) {
		((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].click();", ele);
	}

	public static void clickUsingJS(String preExistingAssignmentXpath) {
		((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].click();",
				preExistingAssignmentXpath);
	}

	public static WebElement getElementBasedOnContainsVisibleNumber(String num) {
		return DriverUtils.getDriver().findElement(By.xpath("//div[contains(text(), '" + num + "')]"));
	}

	public static WebElement getElementBasedOnContainsVisibleNumberRosterPage(String num) {
		return DriverUtils.getDriver().findElement(By.xpath("//span[contains(text(), '" + num + "')]"));
	}

	// input[@value='HPOLK']
	public static WebElement getElementBasedOnContainsVisibleClassCodePlanPage(String num) {
		return DriverUtils.getDriver().findElement(By.xpath("//input[@value='" + num + "']"));
	}

	public static void clickElement(WebElement ele) {
		try {
			verifyElementClickable(ele);
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyElementClickable(WebElement ele) {
		boolean flag = false;
		try {
			WebDriverWait w = new WebDriverWait(DriverUtils.getDriver(), 20);

			w.until(ExpectedConditions.elementToBeClickable(ele));

			System.out.println("Message ==>" + ele);
			// w.until(ExpectedConditions.textToBePresentInElementValue(ele, text));
			flag = true;
			System.out.println("Message ==>" + ele);
		} catch (Exception ex) {
			flag = false;
			System.out.println("Message ==>" + ex);
		}

		Assert.assertEquals(flag, true);

	}

	/**
	 * 
	 * Below code will first identify the element before peforming any action
	 * 
	 */
	public static void waitForElement(WebElement ele) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			System.out.println("wait for element ele value" + ele);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Element doesn't exist verify it...!!!");
		}
	}

	public static String generateRandomEmail(String randomEmail) {
		Random rnd = new Random();
		int randomNumber = 100000 + rnd.nextInt(900000);
		String randomEmailTxt = randomEmail + randomNumber + "@mailnator.com";
		return randomEmailTxt;
	}

	public static void scrollToElement(WebElement ele) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("scroll(250, 0)", ele);
		Thread.sleep(2000);
	}

	/**
	 * 
	 * This method will generate random text name for student and teacher Example:
	 * assignment name for pro and non pro teacher.
	 * 
	 * @param randomNameLength - length to create randome text
	 * 
	 */

	public static String generateRandomText(int randomNameLength) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk" + "lmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(7);
		for (int i = 0; i < randomNameLength; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public static String generateRandomeNumbers() {
		String num = "9" + (int) (Math.random() * (9999999 - 1000000 + 1) + 1000000);
		return num;
	}
}
