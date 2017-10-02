package Page;

import utils.Constants;
import Base.BasePage;
import reporting.CustomAssert;
import ru.yandex.qatools.allure.annotations.Step;
import Configuration.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
	/*WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}*/
	
	public SignInPage() {
		PageFactory.initElements(driver(), this);
	}

	@FindBy(name = config.signIn)
	public WebElement signInButton;

	@FindBy(xpath = config.showHidePasswordCheckBox)
	public WebElement showHidePasswordCheckBox;

	@FindBy(xpath = config.email)
	public WebElement usernameInputField;

	@FindBy(xpath = config.password)
	public WebElement passwordInputField;

	@FindBy(xpath = config.rememberMeCheckBox)
	public WebElement rememberMe;

	@FindBy(xpath = config.forgotPasswordLink)
	public WebElement forgotPassword;

	@FindBy(className = config.signUpLink)
	public WebElement signUp;
	
	@FindBy(xpath = config.incorrectEmailErrorMessage)
	public WebElement incorrectEmailError;

	@Step
	public SignInPage waitForPageToLoad() {
		waitForElementVisibility(signInButton);
		return this;
	}

	@Step
	public boolean isPageOpened() {
		Boolean promise = isElementPresent(Constants.ELEMENT_30_TIMEOUT_SECONDS, signInButton);
		// Attachments.takeScreenshot();
		return promise;
	}

	@Step
	public SignInPage typeUsername(String username) {
		waitForElementVisibility(usernameInputField);
		usernameInputField.clear();
		type(username, usernameInputField);
		return this;
	}

	@Step
	public SignInPage typePassword(String password) {
		/* new SignInPage(). */showPasswordIfHidden();
		passwordInputField.clear();
		type(password, passwordInputField);

		return this;
	}

	@Step
	public void showPasswordIfHidden() {

		if (!showHidePasswordCheckBox.isSelected()) {
			click(showHidePasswordCheckBox);
		}

	}

	@Step
	public SignInPage clickSignIn() {
		click(signInButton);
		wait(5);
		return this;
	}

	@Step
	public SignInPage selectRememberMeIfNotSelected() {
		if (!rememberMe.isSelected()) {
			click(rememberMe);
		}
		return this;
	}

	@Step
	public ForgotPasswordPage clickForgotPassword() { 
		click(forgotPassword);
		return PageFactory.initElements(driver(), ForgotPasswordPage.class);
	}

	@Step
	public SignUpPage1 clickSignUpLink() {
		click(signUp);
		return PageFactory.initElements(driver(), SignUpPage1.class);
	}

	@Step
	public SignInPage checkEmailInputPlaceholder(CustomAssert customAssert) {

		if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, usernameInputField)) {
			try {
				usernameInputField.clear();
			} catch (WebDriverException wde) {
				System.err.println("Catching error during clearing username field. Ignoring.");
			}
			String expectedText = "Email";
			String actualText = usernameInputField.getAttribute("placeholder");
			customAssert.softAssertTrue(expectedText.equals(actualText),
					"Unexpected username field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText
							+ "'.");
		} else {
			customAssert.fail("Can not check Email input placeholder as it was not found.");
		}
		return this;
	}

	@Step
	public SignInPage checkPasswordInputPlaceholder(CustomAssert customAssert) {

		if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, passwordInputField)) {
			try {
				passwordInputField.clear();
			} catch (WebDriverException wde) {
				System.err.println("Catching error during clearing password field. Ignoring.");
			}
			String expectedText = "Password";
			String actualText = passwordInputField.getAttribute("placeholder");
			customAssert.softAssertTrue(expectedText.equals(actualText),
					"Unexpected username field placeholder. Expected: '" + expectedText + "'. Actual: '" + actualText
							+ "'.");
		} else {
			customAssert.fail("Can not check password input placeholder as it was not found.");
		}
		return this;
	}
	
	
	
	
	@Step
	public boolean getIncorrectEmailErrorMessage(CustomAssert customAssert) {
		if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, incorrectEmailError)) {
		String expectedMessage = "The email/username or password you entered is incorrect. Please verify your login details and try again.";
		String actualMessage = incorrectEmailError.getText();
		customAssert.softAssertTrue(expectedMessage.equals(actualMessage),
				"Unexpected username field placeholder. Expected: '" + expectedMessage + "'. Actual: '" + actualMessage
						+ "'.");
		}
		else {
			customAssert.fail("Can not check Email error message as it was not found.");
			return false;
		}
		return true;
	}

}
