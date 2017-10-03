package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reporting.CustomAssert;
import Base.BasePage;
import Configuration.config;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Constants;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage() {
		PageFactory.initElements(driver(), this);
	}
	
	@FindBy(xpath = config.resetPasswordButton)
	public WebElement resetPassword;
	
	@FindBy(xpath = config.resetEmailTextBox)
	public WebElement resetEmail;
	
	@FindBy(xpath = config.resetPasswordInstructions)
	public WebElement resetPasswordMessage;
	
	@FindBy(xpath = config.incorrectEmailErrorMessage)
	public WebElement invalidEmail;
	
	@Step
    public boolean isPageOpened() {
        Boolean promise = isElementPresent(Constants.ELEMENT_30_TIMEOUT_SECONDS, resetPassword);
       // Attachments.takeScreenshot();
        return promise;
    }
	
	@Step
	public ForgotPasswordPage typeEmail(String email) {
		resetEmail.clear();
		type(email, resetEmail);
		return this;
	}
	
	@Step
	public ForgotPasswordPage clickResetPassword() {
		click(resetPassword);
		return this;
	}
	
	
	@Step
    public boolean isResetPasswordMailHaveBeenSentMsgPresent() {
        wait(5);
        return isElementPresent(Constants.ELEMENT_30_TIMEOUT_SECONDS, resetPasswordMessage);
    }
	
	@Step
    public ForgotPasswordPage isErrorMessageNotRegisteredEmailDisplayed(CustomAssert customAssert) {
        wait(5);
        String expectedMessage = "Please verify your email and try again. If problem persists, call 877-875-5301.";
        String actualMessage = resetPasswordMessage.getText();
        customAssert.softAssertTrue(expectedMessage.equals(actualMessage), "Incorrect error message displayed");
        return this;
        
    }
	
	
	@Step
    public ForgotPasswordPage isEmailSentMessageDisplayed(CustomAssert customAssert) {
        wait(5);
        String expectedMessage = "Reset password instructions have been sent again to your email address. If you do not receive an email within the next few minutes, call 877-875-5301 (9am-5pm M-F EST)";
        String actualMessage = resetPasswordMessage.getText();
        customAssert.softAssertTrue(expectedMessage.equals(actualMessage), "Incorrect email sent message displayed");
        return this;
        
    }
	
	@Step
	public ForgotPasswordPage isInvalidEmailErrorMessageDisplayed(CustomAssert customAssert) {
		if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, invalidEmail)) {
			String expectedMessage = "Email is not valid";
			String actualMessage = invalidEmail.getText();
			customAssert.softAssertTrue(expectedMessage.equals(actualMessage), "Incorrect error message displayed");
		} else {
			customAssert.fail("Can not check Email error message as it was not found.");
		}
		return this;
	}
	
}
