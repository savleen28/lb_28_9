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
	 
	 @FindBy(xpath = config.logoutDropdown)
	 public WebElement dropdown;
	 
	 @FindBy(xpath = config.logoutButton)
	 public WebElement logout;
	 
	 @FindBy(xpath = config.loadSearchLink)
	 public WebElement loadSearch;
	 
	 
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
	 
	 @Step
	  public HomePage clickLogoutDropdown(){
		 click(dropdown);
		 return this;
	 }
	 
	 @Step
	 public StartPage clickLogout() {
		 click(logout);
		 return PageFactory.initElements(driver(), StartPage.class);
	 }
	 
	 @Step
	    public boolean isPageOpened() {
	        return isPageOpened(Constants.ELEMENT_30_TIMEOUT_SECONDS);
	    }

	    @Step
	    public boolean isPageOpened(int timeout) {
	        Boolean promise = isElementPresent(timeout, loadSearch);
	        //Attachments.takeScreenshot();
	        return promise;
	    }
	    
}
