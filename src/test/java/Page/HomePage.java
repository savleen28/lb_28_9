package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Configuration.config;
import reporting.CustomAssert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Constants;
import Base.BasePage;

public class HomePage extends BasePage{
	public HomePage() {
		PageFactory.initElements(driver(), this);
	}

	 @FindBy(xpath = config.unverifiedAccountMessage)
	 public WebElement unverifiedAccMessage;
	 
	 
	 @Step
		public boolean checkUnverifiedAccountMessage(CustomAssert customAssert) {
			if (isElementDisplayed(Constants.ELEMENT_30_TIMEOUT_SECONDS, unverifiedAccMessage)) {
			String expectedMessage = "Check your INBOX to confirm your email address.";
			String actualMessage = unverifiedAccMessage.getText();
			customAssert.softAssertTrue(expectedMessage.equals(actualMessage),
					"Unexpected username field placeholder. Expected: '" + expectedMessage + "'. Actual: '" + actualMessage
							+ "'.");
			}
			else {
				customAssert.fail("Can not check unverified account message as it was not found.");
				return false;
			}
			return true;
		}
}
