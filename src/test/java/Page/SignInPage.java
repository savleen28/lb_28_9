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
		type(username, usernameInputField);
		return this;
	}

	@Step
	public SignInPage typePassword(String password) {
		/* new SignInPage(). */showPasswordIfHidden();
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
	public SignInPage clickForgotPassword() { // change the return type
		click(forgotPassword);
		return this;
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

}
