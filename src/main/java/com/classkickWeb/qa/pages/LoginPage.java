package com.classkickWeb.qa.pages;

import static com.classkickWeb.qa.utils.CommonUtils.sendKeysToElement;
import static com.classkickWeb.qa.utils.CommonUtils.verifyElementVisible;
import static com.classkickWeb.qa.utils.CommonUtils.verifyTextFieldIsEmpty;

import java.io.IOException;
import java.util.Random;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.classkickWeb.qa.utils.CommonUtils;
import com.classkickWeb.qa.utils.DriverUtils;
import com.classkickWeb.qa.utils.PropertiesUtils;
import com.perfecto.sampleproject.PerfectoClasskickTeacherLogin;

public class LoginPage extends PerfectoClasskickTeacherLogin {

	public LoginPage() {
		super.getDriver(driver);
		PageFactory.initElements(driver, this);
	}

//	Landing Page Elements WEB
	@FindBy(xpath = "//img[contains(@src,'classkick-logo')]")
	public WebElement classKickLogoImg;

	@FindBy(xpath = "//form[@name='anonStudentLoginForm']//div[text()='Start Working']")
	public WebElement startWorkingLbl;

	@FindBy(xpath = "//input[@name='classCode']")
	public WebElement classCodeTxtBox;

	@FindBy(xpath = "//div[contains(text(),'class code was not found')]")
	public WebElement badClassCodeMessage;

	@FindBy(xpath = "//a[contains(text(),\"what's a class code?\")]")
	public WebElement whatsAClassCodeLnk;

//  landing page btn element 
	@FindBy(xpath = "//button[contains(text(),'log in')]")
	public WebElement loginBtn;

//  login page login btn element
	@FindBy(xpath = "//button[@aria-label=\"Log in to account\"]")
	public WebElement loginPageLoginBtn;

	@FindBy(xpath = "//button[contains(text(),'sign up')]")
	public WebElement signUpBtn;

//	Account login Page Elements
	@FindBy(xpath = "//div[contains(text(),'Account Login')]")
	public WebElement accountLoginLbl;

	@FindBy(xpath = "//span[contains(text(),'Continue with Google')]")
	public WebElement continueWithGoogleTxt;

	@FindBy(xpath = "//button[contains(@class,'google-sign-in')]")
	public WebElement continueWithGoogleBtn;

	@FindBy(xpath = "//button[contains(@class,'google-sign-in')]//img")
	public WebElement continueWithGoogleImage;

	@FindBy(xpath = "//span[contains(text(),'Continue with Clever')]")
	public WebElement continueWithCleverTxt;

	@FindBy(xpath = "//button[contains(@class,'clever-sign-in')]//img")
	public WebElement continueWithCleverImage;

	@FindBy(xpath = "//button[contains(@class,'clever-sign-in')]")
	public WebElement continueWithCleverBtn;

	@FindBy(xpath = "//button[contains(text(),'Continue to Classkick')]")
	public WebElement continueToClasskick;

	@FindBy(xpath = "//input[@aria-label='Enter email or username here']")
	public WebElement emailTxtBox;

	@FindBy(xpath = "//input[@aria-label='Enter password here']")
	public WebElement passwordTxtBox;

	@FindBy(xpath = "//div[@ng-message='error']")
	public WebElement whoopsErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Please enter password')]")
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "//md-checkbox[@aria-label=\"Remember Me\"]")
	public WebElement rememberMeChkBox;

	@FindBy(xpath = "//*[contains(text(),'Remember Me')]")
	public WebElement teacherSignUpRememberMeChkBox;

	@FindBy(xpath = "//*[contains(text(),'Show Password')]")
	public WebElement teacherSignUpShowPasswordeChkBox;

	@FindBy(xpath = "//button[contains(text(),'Log In')]")
	public WebElement logBtn;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password?')]")
	public WebElement forgotPasswordLnk;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	public WebElement signUpAccountLoginBtn;

// 	Reset Password Page elements
	@FindBy(xpath = "//div[contains(text(),'Reset Password')]")
	public WebElement resetPasswordTxt;

	@FindBy(xpath = "//input[@name='emailInput']")
	public WebElement emailInputField;

	@FindBy(xpath = "//span[contains(text(),'Students:')]")
	public WebElement studentsTxt;

	@FindBy(xpath = "//span[contains(text(),'Please ask your teacher to reset your password.')]")
	public WebElement pleaseAskTeacherResetTxt;

	@FindBy(xpath = "//span[contains(text(),'Teachers:')]")
	public WebElement tescherTxt;

	@FindBy(xpath = " ")
	public WebElement iAmAStudentOrTeacherSelection;

	@FindBy(xpath = "//span[contains(text(),'Please enter your email address and we will send a')]")
	public WebElement pleaseEnterEmailTxt;

	@FindBy(xpath = "//input[@name='emailInput']")
	public WebElement teschersResetPasswordEmailInputField;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement submitBtn;

	@FindBy(name = "emailInput")
	public WebElement teacherSignUpEmailTxtBox;

	@FindBy(name = "passwordInput")
	public WebElement teacherSignUpPasswordTxtBox;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	public WebElement teacherSignUpBtn;

	@FindBy(xpath = "//div[contains(text(),'Email address is already in use')]")
	public WebElement emailIdAlreadyExist;

	@FindBy(xpath = "//input[@aria-label='Class code input']")
	public WebElement studentSignUpTxt;

	@FindBy(xpath = "//div[text()='Student Sign Up']")
	public WebElement studentSignUpTitleTxt;

	@FindBy(xpath = "//input[@aria-label='Class code input']")
	public WebElement classCodeInputTxtBox;

	@FindBy(xpath = "//input[@name='classCode']")
	public WebElement enterClassCodeHereTxtBox;

	@FindBy(xpath = "//input[@name='classCodeInput']")
	WebElement studentSignUpClassCodeTxtBox;

	@FindBy(xpath = "//input[@name='classCode']")
	public WebElement classCodeInputBox;

	@FindBy(xpath = "//button[@aria-label='Create account with email or username']")
	public WebElement signUpUserNameEmail;

	@FindBy(name = "emailOrUsernameInput")
	public WebElement emailInputBox;

	@FindBy(name = "passwordInput")
	public WebElement passwordInputBox;

	@FindBy(xpath = "//div[contains(text(),'Email address is already in use')]")
	public WebElement errorMessage;

	@FindBy(xpath = "//a[@aria-label='View our Terms of Service']")
	public WebElement termsOfServices;

	@FindBy(xpath = "//a[@aria-label=\"View our Privacy Policy\"]")
	public WebElement viewPrivacyPolicy;

	@FindBy(xpath = "//input[@aria-label='Email or phone']")
	public WebElement googleEmailInputBox;

	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	public WebElement googleNextBtn;

	@FindBy(xpath = "//input[@aria-label=\"Enter your password\"]")
	public WebElement googlePasswordInputBox;

	@FindBy(xpath = "//div[contains(text(), 'class code was not found')]")
	public WebElement classCodeErrorMessage;

	@FindBy(xpath = "//input[@aria-label='Name input']")
	public WebElement nameInputTxtBox;

	@FindBy(xpath = "//button[@aria-label=\"Log in with class code\"]")
	public WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(), 'Continue')]")
	public WebElement ReviewStudentAccountsContinueBtn;

	@FindBy(xpath = "//button[@aria-label='Log in with class code']")
	public WebElement classkickProStudentGoBtn;

	@FindBy(xpath = "//p[contains(text(), 'Whoops! Looks like your email and/or password are incorrect.')]")
	public WebElement errorMessageEmail;

	@FindBy(xpath = "//div[contains(text(),'Couldn’t find your Google Account')]")
	public WebElement googleErrorMessage;

	@FindBy(xpath = "(//button[contains(text(), 'Go')])[1]")
	public WebElement clickGoBtn;
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * @
	 * 
	 * @FindBy(xpath = "") public WebElement ;
	 * 
	 * @FindBy(xpath = "") public WebElement ;
	 * 
	 * @FindBy(xpath = "") public WebElement ;
	 * 
	 * @FindBy(xpath = "") public WebElement ;
	 * 
	 */

	 // handle "Classkick works best in the Google Chrome browser!" alert
	 public void handleWorksBestInBrowserAlert() throws InterruptedException {
		if (CommonUtils.isElementDisplayed(continueToClasskick)) {
			verifyElementVisible(continueToClasskick);
			CommonUtils.clickElement(continueToClasskick);
		}
	 }

// 	Reset Password Page elements There was a Problem pop up elements
	public void loginUsingEmailAndPassword(String email, String password, String rememberMeFlag)
			throws InterruptedException {
		CommonUtils.sleep(2000);
		sendKeysToElement(emailTxtBox, email);
		sendKeysToElement(passwordTxtBox, password);
		if (rememberMeFlag.equalsIgnoreCase("false")) {
			rememberMeChkBox.click();
		}
		CommonUtils.sleep(4000);
		CommonUtils.clickUsingJS(logBtn);

	}

	public void loginEmailAndPassword(String email, String password) throws InterruptedException {
		sendKeysToElement(teacherSignUpEmailTxtBox, email);
		sendKeysToElement(teacherSignUpPasswordTxtBox, password);
		Thread.sleep(2000);
		teacherSignUpBtn.click();
	}

	// landing page elements
	public void verifyLandingScreen() throws InterruptedException {
		CommonUtils.sleep(2000);
		CommonUtils.verifyElementPresent(classKickLogoImg);
		// verifyElementVisible(classKickLogoImg);
		verifyElementVisible(startWorkingLbl);
		verifyElementVisible(classCodeTxtBox);
		verifyElementVisible(whatsAClassCodeLnk);
		verifyElementVisible(loginBtn);
		verifyElementVisible(signUpBtn);

	}

	// Account login screen elements
	public void verifyLoginScreen() throws InterruptedException {
		verifyElementVisible(classKickLogoImg);
		// verifyElementVisible(whoopsErrorMessage);
		verifyElementVisible(accountLoginLbl);
		verifyElementVisible(continueWithGoogleBtn);
		verifyElementVisible(continueWithGoogleTxt);
		verifyElementVisible(continueWithCleverBtn);
		verifyElementVisible(continueWithCleverTxt);
		verifyElementVisible(continueWithCleverImage);
		verifyElementVisible(emailTxtBox);
		verifyElementVisible(passwordTxtBox);
		verifyElementVisible(rememberMeChkBox);
		verifyElementVisible(loginPageLoginBtn);
		verifyElementVisible(forgotPasswordLnk);
		verifyElementVisible(signUpAccountLoginBtn);
	}

	public void verifySignUpScreen() throws InterruptedException {
		verifyElementVisible(classKickLogoImg);
		verifyElementVisible(teacherSignUpEmailTxtBox);
		verifyElementVisible(teacherSignUpPasswordTxtBox);
		verifyElementVisible(teacherSignUpRememberMeChkBox);
		verifyElementVisible(teacherSignUpBtn);
		verifyElementVisible(teacherSignUpShowPasswordeChkBox);
	}

	public void selectUserType(String selectUserType) {

		WebElement usrType = driver.findElement(By.xpath("//div[contains(text(),'" + selectUserType + "')]"));
		CommonUtils.waitForElement(usrType);
		usrType.click();
	}

	public void selectEmailTypeForTeacher(String emailTypeTeacher) {

		WebElement emailType = driver.findElement(By.xpath("//button[contains(text(),'" + emailTypeTeacher + "')]"));
		CommonUtils.waitForElement(emailType);
		emailType.click();

	}

	public void teacherSignUpRandomCredentials() {
		Random rnd = new Random();
		int randomNumber = 100000 + rnd.nextInt(900000);
		String randomEmailTxt = "test2" + randomNumber + "@mailnator.com";
		System.out.println("Random email id is: " + randomEmailTxt);
		CommonUtils.waitForElement(teacherSignUpEmailTxtBox);
		teacherSignUpEmailTxtBox.sendKeys(randomEmailTxt);
		teacherSignUpPasswordTxtBox.sendKeys("Welcome@123");
		teacherSignUpBtn.click();
//		sendKeysToElement(teacherSignUpEmailTxtBox, randomEmailTxt);
//		sendKeysToElement(teacherSignUpPasswordTxtBox, "Test123");
//		PropertiesUtils.setProperty("SignUp_Email", randomEmailTxt);
//		PropertiesUtils.setProperty("SignUp_UserName", "");
	}

	public void validateErrorMsg(String expectedErrorMsgTxt) {
		CommonUtils.waitForElement(emailIdAlreadyExist);
		String actualErrorMsgTxt = emailIdAlreadyExist.getText();
		Assert.assertEquals(expectedErrorMsgTxt, actualErrorMsgTxt);
	}

//created a new method 	to verify password screen
	public void verifyPasswordScreen() throws InterruptedException {
		verifyElementVisible(teschersResetPasswordEmailInputField);
		verifyElementVisible(studentsTxt);
		verifyElementVisible(pleaseAskTeacherResetTxt);
		verifyElementVisible(tescherTxt); // web
		verifyElementVisible(pleaseEnterEmailTxt);
	}

	public void verfiyEmailAndPasswordFieldsAreBlank() {
		verifyTextFieldIsEmpty(emailTxtBox);
		verifyTextFieldIsEmpty(passwordTxtBox);
	}

	public void clickloginbtn(String buttonLabel) throws InterruptedException {
		// button[@aria-label="Log in to account"]
		// driver.findElement(By.xpath("//button[@aria-label=" + buttonLabel +
		// "')]")).click();
		
		CommonUtils.CheckFirfoxPopup(continueToClasskick);

		CommonUtils.verifyElementVisible(By.xpath("//button[contains(text(),'" + buttonLabel + "')]"));
		driver.findElement(By.xpath("//button[contains(text(),'" + buttonLabel + "')]")).click();
		System.out.println("clicked on login button");
	}

	public void clickSignUpBtn(String buttonLabel) throws InterruptedException {
		// CommonUtils.clickUsingJS(buttonLabel);
		CommonUtils.CheckFirfoxPopup(continueToClasskick);

		CommonUtils.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'" + buttonLabel + "')]")).click();
		CommonUtils.sleep(1000);
		System.out.println("clicked on SignUp button");
	}

	public void validateStudentSignupPage() {
		CommonUtils.verifyElementPresent(studentSignUpTitleTxt);
	}

	public void enterClassCode(String studentClassCode) {
		CommonUtils.sleep(2000);
		CommonUtils.sendKeysToElement(studentSignUpClassCodeTxtBox, studentClassCode);
		// CommonUtils.sendKeysToElement(classCodeInputTxtBox, studentClassCode);
	}

	public void clickSignUpWithUnOrEmail() {
		CommonUtils.clickUsingJS(signUpUserNameEmail);

		try {

			while (signUpUserNameEmail.isDisplayed()) {

				CommonUtils.clickUsingJS(signUpUserNameEmail);
			}

		} catch (Exception e) {

		}
		// CommonUtils.clickElement(signUpUserNameEmail);

	}

	public void enterStudentCredentials(String studentEmail, String studentPassword) {
		CommonUtils.sendKeysToElement(emailInputBox, studentEmail);
		CommonUtils.sendKeysToElement(passwordInputBox, studentPassword);
	}

	public void clickSignUpBtn() {
		CommonUtils.clickUsingJS(teacherSignUpBtn);
	}

	public void validateEmailErrorMessage() {
		CommonUtils.verifyElementPresent(errorMessage);

	}

	public void validateTermsAndServices() {
		CommonUtils.verifyElementPresent(termsOfServices);
		CommonUtils.verifyElementPresent(viewPrivacyPolicy);

	}

	public void enterUserAndPassword(String userName, String passWord) {
		int characterLength = Integer.parseInt(userName);
		userName = "M" + CommonUtils.generateRandomText(characterLength);

		try {
			PropertiesUtils.setValueinTestData("student_user_name", userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CommonUtils.sendKeysToElement(emailInputBox, userName);
		CommonUtils.sendKeysToElement(passwordInputBox, passWord);
	}

	public void selectGoogleSignUp() {

		CommonUtils.verifyElementPresent(continueWithGoogleBtn);
		CommonUtils.clickUsingJS(continueWithGoogleBtn);

		try {

			while (continueWithGoogleBtn.isDisplayed()) {

				CommonUtils.clickUsingJS(continueWithGoogleBtn);
			}

		} catch (Exception e) {

		}
	}

	public void validateGoogleTab() {
		String currentWindow = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			String winTitle = driver.switchTo().window(winHandle).getTitle();
			driver.manage().window().maximize();
			System.out.println("Title of the new window >>>>>>>>>>>>>>>>>" + winTitle);
			if (winTitle.contains("Google")) {

				Assert.assertEquals("Sign in - Google Accounts", winTitle);
				break;
			} else {

			}
		}
	}

	public void enterGoogleEmailId(String googleEmail) {

		CommonUtils.sendKeysToElement(googleEmailInputBox, googleEmail);
	}

	public void enterGooglePassWord(String googlePassWord) {
		CommonUtils.sendKeysToElement(googlePasswordInputBox, googlePassWord);

	}

	public void clickGoogleNextBtn() {
		CommonUtils.clickUsingJS(googleNextBtn);

	}

	public void errorMessage() {
		CommonUtils.sleep(2000);
		;
		CommonUtils.verifyElementTextEqualsIgnoreCase(classCodeErrorMessage, "CLASS CODE WAS NOT FOUND");
	}

	public void enterClassCode() {
		CommonUtils.sendKeysToElement(classCodeInputBox, "XY6O7S");
	}

	public void enterStudentName() {
		CommonUtils.sendKeysToElement(nameInputTxtBox, "Bob");

	}

	public void enterStudentName(String studentName) {
		CommonUtils.sleep(4000);
		CommonUtils.sendKeysToElement(nameInputTxtBox, studentName);

	}

	public void clickContinueBtn() {
		CommonUtils.sleep(2000);
		CommonUtils.clickUsingJS(ReviewStudentAccountsContinueBtn);

	}

	public void enterExisitingStudentName() {
		CommonUtils.sendKeysToElement(nameInputTxtBox, "basic student");

	}

	public void verifyLoggedInWithGoogle() {
		CommonUtils.sleep(2000);
		String currentWindow = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {

			if (!(winHandle.equals(currentWindow))) {
				driver.switchTo().window(winHandle);
			}
		}
	}

	public void verifyFailureMessage() {
		CommonUtils.verifyElementPresent(errorMessageEmail);

	}

	public void verifyGoogleErrorMessage() {
		CommonUtils.verifyElementPresent(googleErrorMessage);

	}

	public void clickGoBtn() {
		CommonUtils.clickUsingJS(clickGoBtn);

	}

	public void enterRandomStudentName() {

		String randomName = CommonUtils.generateRandomText(5);

		CommonUtils.sendKeysToElement(nameInputTxtBox, randomName);

	}

}
