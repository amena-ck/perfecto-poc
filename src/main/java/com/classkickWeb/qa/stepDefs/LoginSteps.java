package com.classkickWeb.qa.stepDefs;

import java.io.IOException;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.classkickWeb.qa.pages.LoginPage;
import com.classkickWeb.qa.utils.DriverUtils;
import com.perfecto.sampleproject.PerfectoClasskickTeacherLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends PerfectoClasskickTeacherLogin{
	
	//LoginPage loginPage = new LoginPage(PerfectoClasskickTeacherLogin.getDriver());
	LoginPage loginPage = new LoginPage();
	

	@Given("I validate that email and password fields are empty")
	public void i_validate_that_email_and_password_fields_are_empty() {
		loginPage.verfiyEmailAndPasswordFieldsAreBlank();
	}
	
	@Test(priority=2)
	@Given("I validate login page is loaded")
	public void i_validate_login_page_is_loaded() throws IOException, InterruptedException {
		loginPage.verifyLandingScreen();
	}

	@Given("I click on {string} button on the landing page")
	public void i_click_on_button_on_the_landing_page(String buttonLabel) throws IOException, InterruptedException {
		loginPage.clickloginbtn(buttonLabel);
	}
	
	@And("I enter class code")
	public void i_enter_class_code() {
		loginPage.enterClassCode();
	}

	@And("I enter existing student name")
	public void i_enter_existing_student_name() {
		loginPage.enterExisitingStudentName();
	}
	
	@Given("I enter student name")
	public void i_enter_student_name() {
		loginPage.enterStudentName();
	}
	
	
	@Given("I enter random student name")
	public void i_enter_random_student_name() {
		loginPage.enterRandomStudentName();
	}
	 
	@Then("I click on continue button")
	public void i_click_on_continue_button() {
		loginPage.clickContinueBtn();
	}
	
	
	@And("I enter student {string} name")
	public void i_enter_student_name(String enterStudentName) {
		loginPage.enterStudentName(enterStudentName);
	}

	 @And("I click on go button")
	 public void i_click_on_go_button() {
		 loginPage.clickGoBtn();
	 }
	

	@Given("I clicks on sign up button on landing page")
	public void userClicksOnSignUp() throws InterruptedException {
		loginPage.handleWorksBestInBrowserAlert();
		loginPage.clickloginbtn("sign up");
	}

	@Given("I clicks on login button on landing page")
	public void userClickOnLoginBtn() throws InterruptedException {
		loginPage.handleWorksBestInBrowserAlert();
		loginPage.clickloginbtn("log in");
	}

	// uncomment this
	@Given("I validate account login page is loaded")
	public void i_validate_account_login_page_is_loaded() throws InterruptedException {
		loginPage.verifyLoginScreen();
	}

	@When("I enter the username {string} and password {string} on login screen with remember me {string}")
	public void i_enter_the_username_and_password_on_login_screen(String email, String password, String rememberMeFlag)
			throws InterruptedException {
		loginPage.loginUsingEmailAndPassword(email, password, rememberMeFlag);
	}
	
	
	@Then("I verify Failure message")
	public void i_verify_failure_message() {
		loginPage.verifyFailureMessage();
	}
	


	@And("I validate user is logged out")
	public void i_validate_user_is_logged_out() {
		String expectedText = "Start Working";
		String actualText = loginPage.startWorkingLbl.getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Then("I click on forgot password link")
	public void i_click_on_forgot_password_link() {
		loginPage.forgotPasswordLnk.click();
	}

	@Then("I validate the reset password page")
	public void i_validate_the_reset_password_page() {
		String expectedText = "Reset Password";
		String actualText = loginPage.resetPasswordTxt.getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Then("I enter an email not associated with user")
	public void i_enter_an_email_not_associated_with_user() {
		loginPage.emailInputField.sendKeys("kead@gmail.com");
	}

	@Then("I click submit")
	public void i_click_submit() {
		loginPage.submitBtn.click();
	}

	@Then("I verify message indicating that user does not exist")
	public void i_varify_message_indicating_that_user_dose_not_exist() {
		String expectedText = "WHOOPS! THE EMAIL YOU PROVIDED WAS NOT FOUND";
		// String actualText = loginPage.whoopsErrorMessage.getText();
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, 20);

		String actualtext = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-message='error']"))).getText();
		// Assert.assertTrue(expectedText.equalsIgnoreCase(actualText));
		System.out.println("Expected text is " + expectedText);
		System.out.println("Actual text is " + actualtext);
		Assert.assertEquals(expectedText, actualtext);
	}

	@Then("I enter the wrong class code")
	public void i_enter_the_wrong_class_code() {
		loginPage.classCodeTxtBox.sendKeys("ooih65g");

	}

	@Then("I validate the error message")
	public void i_validate_the_error_message() {
		loginPage.errorMessage();

	}

	@Then("I enter the class code")
	public void i_enter_the_class_code() {
		loginPage.classCodeTxtBox.sendKeys("3WQKNT");
	}
	
	@Then("I verify could not find email error message")
	public void i_verify_could_not_find_email_error_message() {
		loginPage.verifyGoogleErrorMessage();
	}



}
