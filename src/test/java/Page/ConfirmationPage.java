package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import reporting.CustomAssert;
import Base.BasePage;
import Configuration.config;
import ru.yandex.qatools.allure.annotations.Step;

public class ConfirmationPage extends BasePage {
	public ConfirmationPage() {
		PageFactory.initElements(driver(), this);
	}
	
	@FindBy(xpath = config.confMessageText)
	WebElement confirmationMessage;
	
	@FindBy(xpath = config.updateEmailLink)
	WebElement updateEmail;
	
	@FindBy(xpath = config.resendEmailLink)
	WebElement resendEmail;
	
	@FindBy(xpath = config.resendEmailText)
	WebElement resendEmailMessage;
	
	@FindBy(xpath = config.updateEmailTextBox)
	WebElement updateEmailTextBox;
	
	@FindBy(xpath = config.updateEmailButton)
	WebElement updateEmailButton;
	
	@FindBy(xpath = config.updateEmailText)
	WebElement updateEmailText;
	
	@Step
    public boolean isThankYouForRegisteringMessagePresent() {
        return isElementDisplayed(Constants.ELEMENT_60_TIMEOUT_SECONDS, confirmationMessage);
    }
	
	@Step
	public ConfirmationPage isConfMessagePresent(CustomAssert customAssert) {
		if (isThankYouForRegisteringMessagePresent()) {
		String actualText = confirmationMessage.getText();
		String expectedText = "An email has been sent to";
		 customAssert.softAssertTrue(actualText.contains(expectedText),
                 "Unexpected text after registration. Expected to contain: '" + expectedText + "'. Found: '" + actualText + "'.");
     } else {
         customAssert.fail("Can not check text after registration as it was not found.");
     }
		
		return this;
	}
	
	@Step
	public ConfirmationPage clickUpdateEmail() {
		click(updateEmail);
		wait(5);
		return this;
	}
	
	
	@Step
	public ConfirmationPage typeEmail(String email) {
		waitForElementVisibility(updateEmailTextBox);
		updateEmailTextBox.clear();
		type(email, updateEmailTextBox);
		return this;
	}
	
	@Step
	public ConfirmationPage clickUpdateEmailButton() {
		click(updateEmailButton);
		wait(5);
		return this;
	}
	
	@Step
	public ConfirmationPage clickResendEmail() {
		click(resendEmail);
		wait(5);
		return this;
	}
	
	@Step
	public boolean isResendEmailMessagePresent() {
		return isElementDisplayed(Constants.ELEMENT_60_TIMEOUT_SECONDS, resendEmailMessage);
	}
	
	@Step
	public ConfirmationPage isResendEmailTextPresent(CustomAssert customAssert) {
		if (isResendEmailMessagePresent()) {
		String actualText = resendEmailMessage.getText();
		String expectedText = "A new email verification has been sent. If you do not receive an email within the next few minutes, call 877-875-5301 (9am-5pm M-F EST)";
		 customAssert.softAssertTrue(actualText.contains(expectedText),
                 "Unexpected text after registration. Expected to contain: '" + expectedText + "'. Found: '" + actualText + "'.");
     } else {
         customAssert.fail("Can not check text after resend email click as it was not found.");
     }
		
		return this;
	}
	
	@Step
	public boolean isUpdateEmailMessagePresent() {
		return isElementDisplayed(Constants.ELEMENT_60_TIMEOUT_SECONDS, updateEmailText);
	}
	
	@Step
	public ConfirmationPage isUpdateEmailTextPresent(CustomAssert customAssert) {
		if (isUpdateEmailMessagePresent()) {
		String actualText = updateEmailText.getText();
		String expectedText = "Email address has been modified to . A new email verification has been sent. If you do not receive an email within the next few minutes, call 877-875-5301 (9am-5pm M-F EST)";
		 customAssert.softAssertTrue(actualText.contains(expectedText),
                 "Unexpected text after registration. Expected to contain: '" + expectedText + "'. Found: '" + actualText + "'.");
     } else {
         customAssert.fail("Can not check text after resend email click as it was not found.");
     }
		
		return this;
	}
	
	

}
