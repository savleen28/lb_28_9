package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Random1;
import Page.ActionBar;
import Page.ConfirmationPage;
import Page.ForgotPasswordPage;
import Page.HomePage;
import Page.SignInPage;
import Page.SignUpPage1;
import Page.SignUpStep2Page;
import Page.StartPage;
import actions.Actions;
import reporting.CustomAssert;
import ru.yandex.qatools.allure.annotations.Title;
import actions.GeneralActions;
import datapool.DataProviderPool;
import Base.BaseTest;
import utils.Mail;

public class SignInUpTest extends BaseTest{
	/*@Title("TST-423")
	@Test(testName = "TST-423", description = "Sign In screen (Functional), 'Signing In in 123Loadboard.'")
	public void signUpScreenFunctional() throws InterruptedException {
		CustomAssert customAssert = new CustomAssert();
		StartPage startPage = new StartPage();
		SignInPage signInPage = startPage.clickSignInButton();
		//CustomAssert.hardAssertTrue(signInPage.isPageOpened(), "Start Page was not opened"); //check this
		//Create new user
		SignUpPage1 signUpPage = signInPage.clickSignUpLink();
		//CustomAssert.hardAssertFalse(signUpPage.isPageOpened(), "Sign Up page was not opened");
		String firstName = "FirstName" + Random1.genFirstNameRandomNo();
		String lastName = "LastName" + Random1.genLastNameRandomNo();
		String unverifiedEmail = "qa" + Random1.genShortRandNumber() + "@test.123loadboard.us";
		String unverifiedPassword = "password";
        String phoneNumber = "8005551212";
        String companyName = "Dummy Company";
        String cardNo = "4242424242424242";
        String month = "01 - January";
        String year = "2024";
        String csc = "024";
        GeneralActions generalActions = new GeneralActions();
        generalActions.typeSignUpInfo(unverifiedEmail, unverifiedPassword, firstName, lastName, companyName, phoneNumber);
        SignUpStep2Page signUpStep2 = signUpPage.clickSignUpButton();
        generalActions.typeSignUpStep2Info(firstName, cardNo, month, year, csc);
        signUpStep2.clickTerms();
        signUpStep2.clickApply();
        customAssert.assertAll();
        //Mail mail = new Mail();
        Thread.sleep(60000L);
        Mail.confirmProfileEmailUpdate("qa@test.123loadboard.us","tKj7tQjd1Gkrdu7K",unverifiedEmail);
        StartPage startPage1 = new StartPage();
		SignInPage signInPage1 = startPage.clickSignInButton();
		signInPage1.typeUsername(unverifiedEmail).typePassword(unverifiedPassword).clickSignIn();
        
        
        
       }*/
	
	/*public static void main(String[] args) {
		String unverifiedEmail = "qa26756966@test.123loadboard.us";
		 Mail.confirmProfileEmailUpdate("qa@test.123loadboard.us","tKj7tQjd1Gkrdu7K",unverifiedEmail);
	}*/
	
	/*@Title("TST-427")
	@Test(testName = "TST-427", description = "Sign In screen (Functional) and check confirmation details, 'Signing In in 123Loadboard.'")
	public static void signUpConfirmation() {
		CustomAssert customAssert = new CustomAssert();
		StartPage startPage = new StartPage();
		SignInPage signInPage = startPage.clickSignInButton();
		//CustomAssert.hardAssertTrue(signInPage.isPageOpened(), "Start Page was not opened"); //check this
		//Create new user
		SignUpPage1 signUpPage = signInPage.clickSignUpLink();
		//CustomAssert.hardAssertFalse(signUpPage.isPageOpened(), "Sign Up page was not opened");
		String firstName = "FirstName" + Random1.genFirstNameRandomNo();
		String lastName = "LastName" + Random1.genLastNameRandomNo();
		String unverifiedEmail = "qa" + Random1.genShortRandNumber() + "@test.123loadboard.us";
		String unverifiedPassword = "password";
        String phoneNumber = "8005551212";
        String companyName = "Dummy Company";
        String cardNo = "4242424242424242";
        String month = "01 - January";
        String year = "2024";
        String csc = "024";
        String updatedEmail = "qa" + Random1.genShortRandNumber() + "@test.123loadboard.us";
        GeneralActions generalActions = new GeneralActions();
        generalActions.typeSignUpInfo(unverifiedEmail, unverifiedPassword, firstName, lastName, companyName, phoneNumber);
        SignUpStep2Page signUpStep2 = signUpPage.clickSignUpButton();
        generalActions.typeSignUpStep2Info(firstName, cardNo, month, year, csc);
        signUpStep2.clickTerms();
        signUpStep2.clickApply();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.isConfMessagePresent(customAssert);
        confirmationPage.clickUpdateEmail().typeEmail(updatedEmail).clickUpdateEmailButton();
        confirmationPage.clickResendEmail();
        confirmationPage.isResendEmailTextPresent(customAssert);
        customAssert.assertAll();
        
	}*/
	
	/*@Title("TST-424")
	@Test(testName = "TST-424", dataProvider = DataProviderPool.NO_ADDON_CREDENTIALS, dataProviderClass = DataProviderPool.class, description = "Sign In screen (Functional), 'Signing In in 123Loadboard.'")
	public static void signInFunctional(String login,String password) {
		CustomAssert customAssert = new CustomAssert();
		StartPage startPage = new StartPage();
		startPage.clickSignInButton();
		new ActionBar().clickBackButton();
		 customAssert.softAssertTrue(startPage.isPageOpened(), "Start page was not opened after clicking 'back' button.");
		 startPage.waitForPageToLoad()
         .click10DayTrialButton()
         .waitForPageToLoad();
		 String firstName = "FirstName" + Random1.genFirstNameRandomNo();
			String lastName = "LastName" + Random1.genLastNameRandomNo();
			String unverifiedEmail = "qa" + Random1.genShortRandNumber() + "@test.123loadboard.us";
			String unverifiedPassword = "password";
	        String phoneNumber = "8005551212";
	        String companyName = "Dummy Company";
	        String cardNo = "4242424242424242";
	        String month = "01 - January";
	        String year = "2024";
	        String csc = "024";
	        GeneralActions generalActions = new GeneralActions();
	        generalActions.typeSignUpInfo(unverifiedEmail, unverifiedPassword, firstName, lastName, companyName, phoneNumber);
	        SignUpPage1 signUpPage = new SignUpPage1();
	        SignUpStep2Page signUpStep2 = signUpPage.clickSignUpButton();
	        generalActions.typeSignUpStep2Info(firstName, cardNo, month, year, csc);
	        signUpStep2.clickTerms();
	        signUpStep2.clickApply();
	        SignInPage signInPage = startPage.clickSignInButton();
		    signInPage.typeUsername("username").typePassword("password").clickSignIn();
		    customAssert.softAssertTrue(new SignInPage().getIncorrectEmailErrorMessage(customAssert), "There was no error message after filling in wrong credentials.");
		    signInPage.typeUsername(login).typePassword("incorrect").clickSignIn();
		    customAssert.softAssertTrue(new SignInPage().getIncorrectEmailErrorMessage(customAssert), "There was no error message after filling in wrong credentials.");
		    ForgotPasswordPage forgotPasswordPage = signInPage.clickForgotPassword();
		    customAssert.softAssertTrue(forgotPasswordPage.isPageOpened(), " 'Forgot password page' was not opened after clicking corresponding link.");
		    new ActionBar().clickBackButton();
		    new SignInPage().waitForPageToLoad().typeUsername(unverifiedEmail).typePassword(unverifiedPassword).clickSignIn();
		    HomePage homePage = new HomePage();
		    customAssert.softAssertTrue(homePage.checkUnverifiedAccountMessage(customAssert), "There was no check your inbox to confirm your email address message");
		   homePage.clickLogoutDropdown().clickLogout();
		   generalActions.login(login, password);
		   customAssert.softAssertTrue(homePage.isPageOpened(), "User was not logged in");
		   customAssert.assertAll();
		 }*/
	
	
	/*@Title("TST-426")
	@Test(testName = "TST-426",description = "Forgot password (Functional), 'User forgets password.'", dataProvider = DataProviderPool.NO_ADDON_CREDENTIALS, dataProviderClass = DataProviderPool.class)
	public void forgotPasswordFunctionalTest(String email, String password) throws InterruptedException {
		String notRegisteredEmail = "notregisteredemail@gmail.com";
		String incorrectEmail = "incorrectemail";
		CustomAssert customAssert = new CustomAssert();
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
		if (!forgotPasswordPage.isPageOpened()) {
			StartPage startPage = new StartPage();
			startPage.clickSignInButton().waitForPageToLoad();
			CustomAssert.hardAssertTrue(new SignInPage().clickForgotPassword().isPageOpened(),
					"Forgot Password Page was not opened");
		}
		forgotPasswordPage.typeEmail(notRegisteredEmail).clickResetPassword();
		forgotPasswordPage.isErrorMessageNotRegisteredEmailDisplayed(customAssert);
		//ForgotPasswordPage forgotPasswordPage1 = new ForgotPasswordPage();
		new ForgotPasswordPage().typeEmail(incorrectEmail).clickResetPassword();
		Thread.sleep(10000L);
		forgotPasswordPage.isInvalidEmailErrorMessageDisplayed(customAssert);
		new ForgotPasswordPage().typeEmail("qa47136518@test.123loadboard.us").clickResetPassword();
		Thread.sleep(20000L);
		forgotPasswordPage.isEmailSentMessageDisplayed(customAssert);
		customAssert.assertAll();
		
	}*/
	
	/*@Title("TST-5")
	@Test(testName = "TST-5",description = "Sign Out (Functional), 'Signing out from application.'", dataProvider = DataProviderPool.NO_ADDON_CREDENTIALS, dataProviderClass = DataProviderPool.class)
	public void signOutFunctionalTest(String login, String password) {
		CustomAssert customAssert = new CustomAssert();
		StartPage startPage = new StartPage();
		startPage.clickSignInButton();
		GeneralActions generalActions = new GeneralActions();
		generalActions.login(login, password);
		HomePage homePage = new HomePage();
		homePage.clickLogoutDropdown().clickLogout();
		CustomAssert.hardAssertTrue(new StartPage().isPageOpened(), "Start page was not opened after signing out.");
        customAssert.assertAll();
		
	}*/
	
	@Title("TST-6")
	@Test(testName = "TST-6",description = "Sign Out (Functional), 'Signing out from application.'", dataProvider = DataProviderPool.VERIFIED_CREDENTIALS, dataProviderClass = DataProviderPool.class)
	public void signUpWithExistingIdTest(String login, String password) {
		 String firstName = "FirstName" + Random1.genFirstNameRandomNo();
			String lastName = "LastName" + Random1.genLastNameRandomNo();
			String unverifiedEmail = "qa" + Random1.genShortRandNumber() + "@test.123loadboard.us";
			String unverifiedPassword = "password";
	        String phoneNumber = "8005551212";
		CustomAssert customAssert = new CustomAssert();
		StartPage startPage = new StartPage();
		SignInPage signInPage = startPage.clickSignInButton();
		SignUpPage1 signUpPage = signInPage.clickSignUpLink();
		signUpPage.clickSignUpButton();
		signUpPage.checkEmailRequiredErrorMessage(customAssert).checkPasswordRequiredErrorMessage(customAssert)
		.checkFirstNameRequiredErrorMessage(customAssert).checkLastNameRequiredErrorMessage(customAssert).checkPhoneNoNameRequiredErrorMessage(customAssert);
		signUpPage.typeEmail(unverifiedEmail).typeFirstName(firstName).typeLastName(lastName)
		.typePhoneNumber(phoneNumber).clickSignUpButton();
		signUpPage.checkPasswordRequiredErrorMessage(customAssert);
		signUpPage.typeEmail("").typePassword(unverifiedPassword).typeFirstName(firstName).typeLastName(lastName).typePhoneNumber(phoneNumber).clickSignUpButton();
		signUpPage.checkEmailRequiredErrorMessage(customAssert);
		
		customAssert.assertAll();
	}

}
